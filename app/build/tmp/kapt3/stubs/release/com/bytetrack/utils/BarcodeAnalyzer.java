package com.bytetrack.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/bytetrack/utils/BarcodeAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "onBarcodeDetected", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "consecutiveDetections", "", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "lastDetectedBarcode", "options", "Lcom/google/mlkit/vision/barcode/BarcodeScannerOptions;", "scanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "analyze", "imageProxy", "Landroidx/camera/core/ImageProxy;", "app_release"})
public final class BarcodeAnalyzer implements androidx.camera.core.ImageAnalysis.Analyzer {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onBarcodeDetected = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.barcode.BarcodeScannerOptions options = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.barcode.BarcodeScanner scanner = null;
    private final java.util.concurrent.ExecutorService executor = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String lastDetectedBarcode;
    private int consecutiveDetections = 0;
    
    public BarcodeAnalyzer(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onBarcodeDetected) {
        super();
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"UnsafeOptInUsageError"})
    public void analyze(@org.jetbrains.annotations.NotNull()
    androidx.camera.core.ImageProxy imageProxy) {
    }
}