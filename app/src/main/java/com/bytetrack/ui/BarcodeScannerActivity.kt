package com.bytetrack.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.bytetrack.ui.theme.ByteTrackTheme
import com.bytetrack.utils.BarcodeAnalyzer
import kotlinx.coroutines.delay
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class BarcodeScannerActivity : ComponentActivity() {
    
    private lateinit var cameraExecutor: ExecutorService
    
    companion object {
        const val BARCODE_RESULT = "barcode_result"
        private const val BARCODE_CONFIRM_DELAY = 15L // Reduced from 800ms to 400ms
    }
    
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted, camera will be started in the Composable
        } else {
            Toast.makeText(this, "Camera permission required", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        cameraExecutor = Executors.newSingleThreadExecutor()
        
        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
        
        setContent {
            ByteTrackTheme {
                BarcodeScanner(
                    cameraExecutor = cameraExecutor,
                    onBarcodeDetected = { barcode ->
                        val resultIntent = Intent().apply {
                            putExtra(BARCODE_RESULT, barcode)
                        }
                        setResult(RESULT_OK, resultIntent)
                        finish()
                    },
                    onClose = { finish() },
                    confirmDelay = BARCODE_CONFIRM_DELAY
                )
            }
        }
    }
    
    private fun allPermissionsGranted() = ContextCompat.checkSelfPermission(
        this, Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED
    
    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }
}

@Composable
fun BarcodeScanner(
    cameraExecutor: ExecutorService,
    onBarcodeDetected: (String) -> Unit,
    onClose: () -> Unit,
    confirmDelay: Long
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    // Track scanning states
    var isScanning by remember { mutableStateOf(true) }
    var currentBarcode by remember { mutableStateOf<String?>(null) }
    var barcodeDetectionTimestamp by remember { mutableStateOf(0L) }
    var showFeedback by remember { mutableStateOf(false) }
    var feedbackMessage by remember { mutableStateOf("") }
    
    // Animation for the scanner box
    val infiniteTransition = rememberInfiniteTransition(label = "scannerTransition")
    val animatedPathWidth by infiniteTransition.animateFloat(
        initialValue = 2f,
        targetValue = 5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pathWidth"
    )
    
    // Box color changes to green when barcode is detected
    val boxColor = if (currentBarcode != null) {
        Color.Green
    } else {
        Color.White
    }
    
    Box(modifier = Modifier.fillMaxSize()) {
        // Camera Preview using AndroidView
        AndroidView(
            factory = { ctx ->
                val previewView = PreviewView(ctx)
                val preview = Preview.Builder().build()
                val selector = CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()
                
                preview.setSurfaceProvider(previewView.surfaceProvider)
                
                val imageAnalysis = ImageAnalysis.Builder()
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .build()
                
                imageAnalysis.setAnalyzer(
                    cameraExecutor,
                    BarcodeAnalyzer { barcode ->
                        if (barcode.isNotEmpty() && isScanning) {
                            val currentTime = System.currentTimeMillis()
                            
                            if (currentBarcode == barcode) {
                                // Same barcode detected again, check if we've seen it long enough
                                if (currentTime - barcodeDetectionTimestamp >= confirmDelay) {
                                    isScanning = false
                                    onBarcodeDetected(barcode)
                                }
                            } else {
                                // New barcode detected, reset timer
                                currentBarcode = barcode
                                barcodeDetectionTimestamp = currentTime
                                
                                // Show feedback that we detected something
                                feedbackMessage = "Barcode detected: $barcode\nKeep steady..."
                                showFeedback = true
                            }
                        } else if (barcode.isEmpty() && currentBarcode != null) {
                            // Lost barcode, reset
                            currentBarcode = null
                            showFeedback = false
                        }
                    }
                )
                
                try {
                    val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
                    cameraProviderFuture.addListener({
                        val cameraProvider = cameraProviderFuture.get()
                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner,
                            selector,
                            preview,
                            imageAnalysis
                        )
                    }, ContextCompat.getMainExecutor(ctx))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                
                previewView
            },
            modifier = Modifier.fillMaxSize()
        )
        
        // Overlay with scan area
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Barcode scanner frame 
            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                
                // Define dimensions for the scanner box
                val boxWidth = canvasWidth * 0.8f
                val boxHeight = boxWidth * 0.6f
                
                // Calculate the top-left position for the box
                val topLeftX = (canvasWidth - boxWidth) / 2
                val topLeftY = (canvasHeight - boxHeight) / 2
                
                // Draw semi-transparent overlay
                drawRect(
                    color = Color.Black.copy(alpha = 0.5f),
                    size = Size(canvasWidth, canvasHeight)
                )
                
                // Draw transparent scan area
                drawRect(
                    color = Color.Transparent,
                    topLeft = Offset(topLeftX, topLeftY),
                    size = Size(boxWidth, boxHeight)
                )
                
                // Draw scan box border (solid line, no path effect)
                drawRect(
                    color = boxColor,
                    topLeft = Offset(topLeftX, topLeftY),
                    size = Size(boxWidth, boxHeight),
                    style = Stroke(width = 3f)
                )
                
                // Draw corner indicators
                val cornerLength = boxWidth * 0.15f
                val cornerWidth = 10f
                
                // Top-left corner
                drawLine(
                    color = boxColor,
                    start = Offset(topLeftX, topLeftY),
                    end = Offset(topLeftX + cornerLength, topLeftY),
                    strokeWidth = cornerWidth
                )
                drawLine(
                    color = boxColor,
                    start = Offset(topLeftX, topLeftY),
                    end = Offset(topLeftX, topLeftY + cornerLength),
                    strokeWidth = cornerWidth
                )
                
                // Top-right corner
                drawLine(
                    color = boxColor,
                    start = Offset(topLeftX + boxWidth, topLeftY),
                    end = Offset(topLeftX + boxWidth - cornerLength, topLeftY),
                    strokeWidth = cornerWidth
                )
                drawLine(
                    color = boxColor,
                    start = Offset(topLeftX + boxWidth, topLeftY),
                    end = Offset(topLeftX + boxWidth, topLeftY + cornerLength),
                    strokeWidth = cornerWidth
                )
                
                // Bottom-left corner
                drawLine(
                    color = boxColor,
                    start = Offset(topLeftX, topLeftY + boxHeight),
                    end = Offset(topLeftX + cornerLength, topLeftY + boxHeight),
                    strokeWidth = cornerWidth
                )
                drawLine(
                    color = boxColor,
                    start = Offset(topLeftX, topLeftY + boxHeight),
                    end = Offset(topLeftX, topLeftY + boxHeight - cornerLength),
                    strokeWidth = cornerWidth
                )
                
                // Bottom-right corner
                drawLine(
                    color = boxColor,
                    start = Offset(topLeftX + boxWidth, topLeftY + boxHeight),
                    end = Offset(topLeftX + boxWidth - cornerLength, topLeftY + boxHeight),
                    strokeWidth = cornerWidth
                )
                drawLine(
                    color = boxColor,
                    start = Offset(topLeftX + boxWidth, topLeftY + boxHeight),
                    end = Offset(topLeftX + boxWidth, topLeftY + boxHeight - cornerLength),
                    strokeWidth = cornerWidth
                )
            }
            
            // Instructions text at the top
            // Removed instruction text
        }
        
        // Close button
        IconButton(
            onClick = onClose,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = Color.White
            )
        }
        
        // Feedback card when barcode is detected
        AnimatedVisibility(
            visible = showFeedback,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = feedbackMessage,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            color = MaterialTheme.colorScheme.primary,
                            strokeWidth = 2.dp
                        )
                        
                        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                        
                        Text(
                            text = "Confirming barcode...",
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
        
        // When no barcode is detected for a while, show helper message
        LaunchedEffect(currentBarcode) {
            if (currentBarcode == null) {
                delay(5000) // Wait 5 seconds
                if (currentBarcode == null && isScanning) {
                    feedbackMessage = "Can't find barcode. Move camera further away or ensure good lighting."
                    showFeedback = true
                    
                    // Auto-hide after 3 seconds
                    delay(3000)
                    if (currentBarcode == null) {
                        showFeedback = false
                    }
                }
            }
        }
    }
} 