package com.bytetrack.ui.screens.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001aP\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u0013"}, d2 = {"QuickAddItem", "", "name", "", "calories", "", "type", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "QuickAddPanel", "quickAddItems", "", "Lcom/bytetrack/ui/viewmodels/HomeViewModel$QuickAddItem;", "onAddItem", "Lkotlin/Function1;", "onAddCustomFood", "onAddCustomDrink", "app_debug"})
public final class QuickAddPanelKt {
    
    @androidx.compose.runtime.Composable()
    public static final void QuickAddPanel(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bytetrack.ui.viewmodels.HomeViewModel.QuickAddItem> quickAddItems, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.bytetrack.ui.viewmodels.HomeViewModel.QuickAddItem, kotlin.Unit> onAddItem, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddCustomFood, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddCustomDrink, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void QuickAddItem(@org.jetbrains.annotations.NotNull()
    java.lang.String name, int calories, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}