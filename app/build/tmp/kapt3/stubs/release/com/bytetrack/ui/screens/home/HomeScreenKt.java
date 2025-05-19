package com.bytetrack.ui.screens.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a(\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0007\u001a<\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a\u001e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007\u001a \u0010\u001b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001e"}, d2 = {"ActivityMetric", "", "value", "", "label", "color", "Landroidx/compose/ui/graphics/Color;", "ActivityMetric-mxwnekA", "(Ljava/lang/String;Ljava/lang/String;J)V", "CalorieProgressCircle", "progress", "", "calories", "", "caloriesRemaining", "dailyGoal", "HomeScreen", "modifier", "Landroidx/compose/ui/Modifier;", "onLogMealClick", "Lkotlin/Function0;", "onLogDrinkClick", "viewModel", "Lcom/bytetrack/ui/viewmodels/HomeViewModel;", "QuickAddButton", "text", "onClick", "WaterProgressIndicator", "waterIntake", "waterGoal", "app_release"})
public final class HomeScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogMealClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogDrinkClick, @org.jetbrains.annotations.NotNull()
    com.bytetrack.ui.viewmodels.HomeViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CalorieProgressCircle(float progress, int calories, int caloriesRemaining, int dailyGoal) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void WaterProgressIndicator(float progress, float waterIntake, float waterGoal) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void QuickAddButton(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}