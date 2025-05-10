package com.bytetrack.utils

import android.annotation.SuppressLint
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import java.util.concurrent.Executors

class BarcodeAnalyzer(private val onBarcodeDetected: (String) -> Unit) : ImageAnalysis.Analyzer {
    
    // Configure the barcode scanner to detect all formats
    private val options = BarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_EAN_13,
            Barcode.FORMAT_EAN_8,
            Barcode.FORMAT_UPC_A,
            Barcode.FORMAT_UPC_E,
            Barcode.FORMAT_CODE_39,
            Barcode.FORMAT_CODE_93,
            Barcode.FORMAT_CODE_128,
            Barcode.FORMAT_QR_CODE
        )
        .enableAllPotentialBarcodes()
        .build()
    
    private val scanner = BarcodeScanning.getClient(options)
    private val executor = Executors.newSingleThreadExecutor()
    
    // Keep track of the last detected barcode for verification
    private var lastDetectedBarcode: String? = null
    private var consecutiveDetections = 0
    
    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            
            // Process image and detect barcodes
            scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    if (barcodes.isEmpty()) {
                        // No barcode detected, reset tracking
                        lastDetectedBarcode = null
                        consecutiveDetections = 0
                        onBarcodeDetected("")
                    } else {
                        // Process all detected barcodes, sorted by confidence
                        val sortedBarcodes = barcodes.filter { it.rawValue != null }
                            .sortedByDescending { 
                                // Prioritize product barcodes (EAN, UPC formats)
                                when (it.format) {
                                    Barcode.FORMAT_EAN_13, 
                                    Barcode.FORMAT_EAN_8,
                                    Barcode.FORMAT_UPC_A,
                                    Barcode.FORMAT_UPC_E -> 100
                                    else -> 50
                                } 
                            }
                        
                        if (sortedBarcodes.isNotEmpty()) {
                            val topBarcode = sortedBarcodes.first().rawValue!!
                            
                            // Check if we've consistently detected the same barcode
                            if (topBarcode == lastDetectedBarcode) {
                                consecutiveDetections++
                                // After a few consistent detections, report the barcode
                                if (consecutiveDetections >= 2) {
                                    onBarcodeDetected(topBarcode)
                                }
                            } else {
                                // Reset for new barcode
                                lastDetectedBarcode = topBarcode
                                consecutiveDetections = 1
                                // Report immediately to show feedback, but don't confirm yet
                                onBarcodeDetected(topBarcode)
                            }
                        }
                    }
                }
                .addOnFailureListener {
                    // In case of scanner failures, reset
                    lastDetectedBarcode = null
                    consecutiveDetections = 0
                    onBarcodeDetected("")
                }
                .addOnCompleteListener {
                    // When the image is from CameraX, we must call close to avoid memory leaks
                    imageProxy.close()
                }
        } else {
            imageProxy.close()
        }
    }
} 