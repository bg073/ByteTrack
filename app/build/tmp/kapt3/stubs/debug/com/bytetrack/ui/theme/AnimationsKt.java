package com.bytetrack.ui.theme;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u001a\u001a\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u001a\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u0010\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u0010\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015\u001a*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000eH\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\u00a8\u0006\u001a"}, d2 = {"EmphasizedEasing", "Landroidx/compose/animation/core/Easing;", "getEmphasizedEasing", "()Landroidx/compose/animation/core/Easing;", "FastOutSlowInEasing", "getFastOutSlowInEasing", "StandardEasing", "getStandardEasing", "buttonClickAnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "contentEnterTransition", "Landroidx/compose/animation/EnterTransition;", "duration", "", "delay", "contentExitTransition", "Landroidx/compose/animation/ExitTransition;", "enterFromBottomTransition", "exitToBottomTransition", "pulseAnimationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "staggeredAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "index", "baseDelay", "app_debug"})
public final class AnimationsKt {
    @org.jetbrains.annotations.NotNull()
    private static final androidx.compose.animation.core.Easing FastOutSlowInEasing = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.compose.animation.core.Easing EmphasizedEasing = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.compose.animation.core.Easing StandardEasing = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.core.Easing getFastOutSlowInEasing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.core.Easing getEmphasizedEasing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.core.Easing getStandardEasing() {
        return null;
    }
    
    /**
     * Standard entry animation for cards and content areas
     */
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.EnterTransition contentEnterTransition(int duration, int delay) {
        return null;
    }
    
    /**
     * Standard exit animation for cards and content areas
     */
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.ExitTransition contentExitTransition(int duration) {
        return null;
    }
    
    /**
     * Animation for entering from the bottom (e.g. dialogs, bottom sheets)
     */
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.EnterTransition enterFromBottomTransition(int duration) {
        return null;
    }
    
    /**
     * Animation for exiting to the bottom (e.g. dialogs, bottom sheets)
     */
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.ExitTransition exitToBottomTransition(int duration) {
        return null;
    }
    
    /**
     * Staggered animation for lists
     */
    @androidx.compose.runtime.Composable()
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.core.TweenSpec<java.lang.Float> staggeredAnimationSpec(int index, int duration, int baseDelay) {
        return null;
    }
    
    /**
     * Button click animation
     */
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.core.SpringSpec<java.lang.Float> buttonClickAnimationSpec() {
        return null;
    }
    
    /**
     * Pulse animation spec
     */
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.animation.core.InfiniteRepeatableSpec<java.lang.Float> pulseAnimationSpec() {
        return null;
    }
}