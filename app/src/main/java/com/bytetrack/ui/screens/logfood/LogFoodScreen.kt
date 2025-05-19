package com.bytetrack.ui.screens.logfood

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bytetrack.R
import com.bytetrack.ui.BarcodeScannerActivity
import com.bytetrack.ui.FoodDetailsActivity
import com.bytetrack.ui.theme.*
import com.bytetrack.ui.viewmodels.LogFoodViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun LogFoodScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    viewModel: LogFoodViewModel = viewModel()
) {
    val context = LocalContext.current
    
    // State for showing the result dialog
    var showResultDialog by remember { mutableStateOf(false) }
    var scanResult by remember { mutableStateOf("") }
    
    // Animation state for staggered entrance
    var startAnimation by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        startAnimation = true
    }
    
    val barcodeScannerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val barcode = result.data?.getStringExtra(BarcodeScannerActivity.BARCODE_RESULT)
            if (!barcode.isNullOrEmpty()) {
                // Show result dialog first
                scanResult = barcode
                showResultDialog = true
            }
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Log Food") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header section with animated entrance
                AnimatedVisibility(
                    visible = startAnimation,
                    enter = fadeIn(
                        animationSpec = tween(
                            durationMillis = AnimationDuration.MEDIUM,
                            easing = StandardEasing
                        )
                    ) + expandIn(
                        animationSpec = tween(
                            durationMillis = AnimationDuration.MEDIUM,
                            easing = StandardEasing
                        ),
                        expandFrom = Alignment.TopCenter
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "How would you like to add food?",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(vertical = 24.dp)
                    )
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Staggered animation for options
                val options = listOf(
                    Triple(
                        "Scan Barcode", 
                        "Quickly scan a product barcode to add food", 
                        Icons.Default.QrCodeScanner to MaterialTheme.colorScheme.primary
                    ) to {
                        val intent = Intent(context, BarcodeScannerActivity::class.java)
                        barcodeScannerLauncher.launch(intent)
                    },
                    Triple(
                        "Take Photo", 
                        "Take a photo of your food for recognition", 
                        Icons.Default.PhotoCamera to Color(0xFF4CAF50)
                    ) to {
                        // TODO: Implement photo recognition 
                    },
                    Triple(
                        "Search Food Database", 
                        "Search our extensive food database", 
                        Icons.Default.Search to Color(0xFF2196F3)
                    ) to {
                        // TODO: Implement manual entry
                    },
                    Triple(
                        "Custom Food Entry", 
                        "Create a custom food with nutrition info", 
                        Icons.Default.Add to Color(0xFFFF9800)
                    ) to {
                        // TODO: Implement custom food entry
                    }
                )
                
                options.forEachIndexed { index, (optionData, onClick) ->
                    val (title, description, iconData) = optionData
                    val (icon, iconTint) = iconData
                    
                    AnimatedVisibility(
                        visible = startAnimation,
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = AnimationDuration.MEDIUM,
                                delayMillis = 100 + (index * 50),
                                easing = StandardEasing
                            )
                        ) + slideInVertically(
                            animationSpec = tween(
                                durationMillis = AnimationDuration.MEDIUM,
                                delayMillis = 100 + (index * 50),
                                easing = StandardEasing
                            ),
                            initialOffsetY = { it / 2 }
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        AnimatedLogFoodOptionCard(
                            title = title,
                            description = description,
                            icon = icon,
                            iconTint = iconTint,
                            onClick = onClick,
                            index = index
                        )
                        
                        if (index < options.size - 1) {
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Recent foods section with animated entrance
                AnimatedVisibility(
                    visible = startAnimation,
                    enter = fadeIn(
                        animationSpec = tween(
                            durationMillis = AnimationDuration.MEDIUM,
                            delayMillis = 100 + (options.size * 50),
                            easing = StandardEasing
                        )
                    ) + slideInVertically(
                        animationSpec = tween(
                            durationMillis = AnimationDuration.MEDIUM,
                            delayMillis = 100 + (options.size * 50),
                            easing = StandardEasing
                        ),
                        initialOffsetY = { it / 2 }
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Recent Foods",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Text(
                                text = "Your recently logged foods will appear here for quick access",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            }
        }
        
        // Show result dialog when barcode is scanned
        AnimatedVisibility(
            visible = showResultDialog,
            enter = enterFromBottomTransition(),
            exit = exitToBottomTransition()
        ) {
            BarcodeResultDialog(
                barcode = scanResult,
                onDismiss = { showResultDialog = false },
                onConfirm = {
                    // Navigate to food details
                    val intent = Intent(context, FoodDetailsActivity::class.java).apply {
                        putExtra(FoodDetailsActivity.EXTRA_BARCODE, scanResult)
                    }
                    context.startActivity(intent)
                    showResultDialog = false
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimatedLogFoodOptionCard(
    title: String,
    description: String,
    icon: ImageVector,
    iconTint: Color,
    onClick: () -> Unit,
    index: Int
) {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { mutableStateOf(1f) }
    val animatedScale by animateFloatAsState(
        targetValue = scale.value,
        animationSpec = buttonClickAnimationSpec(),
        label = "scaleAnimation"
    )
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animatedScale),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = {
            // Add a small animation effect when clicked
            scale.value = 0.95f
            coroutineScope.launch {
                delay(100)
                scale.value = 1f
                onClick()
            }
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(iconTint.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = iconTint,
                    modifier = Modifier.size(28.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun BarcodeResultDialog(
    barcode: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Animated success icon
                val pulseAnimation = remember { Animatable(1f) }
                LaunchedEffect(pulseAnimation) {
                    pulseAnimation.animateTo(
                        targetValue = 1.2f,
                        animationSpec = pulseAnimationSpec()
                    )
                }
                
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Success",
                    tint = Color(0xFF4CAF50),
                    modifier = Modifier
                        .size(64.dp)
                        .graphicsLayer {
                            scaleX = pulseAnimation.value
                            scaleY = pulseAnimation.value
                        }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "Barcode Detected!",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Barcode: $barcode",
                    style = MaterialTheme.typography.bodyLarge
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "We'll look up nutrition information for this product",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                    ) {
                        Text("Cancel")
                    }
                    
                    Button(
                        onClick = onConfirm,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text("Continue")
                    }
                }
            }
        }
    }
} 