package com.bytetrack.ui.screens.logdrink;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a$\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a,\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a@\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a$\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006!"}, d2 = {"AmountChip", "", "amount", "", "isSelected", "", "onClick", "Lkotlin/Function0;", "AmountSelector", "onAmountChanged", "Lkotlin/Function1;", "DrinkLogScreen", "modifier", "Landroidx/compose/ui/Modifier;", "onBackClick", "viewModel", "Lcom/bytetrack/ui/viewmodels/DrinkLogViewModel;", "DrinkTypeOption", "type", "Lcom/bytetrack/data/model/DrinkType;", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "color", "Landroidx/compose/ui/graphics/Color;", "DrinkTypeOption-xwkQ0AY", "(Lcom/bytetrack/data/model/DrinkType;Landroidx/compose/ui/graphics/vector/ImageVector;ZLkotlin/jvm/functions/Function0;J)V", "DrinkTypeSelection", "selectedDrinkType", "onDrinkTypeSelected", "NutritionValue", "label", "", "value", "app_release"})
public final class DrinkLogScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void DrinkLogScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull()
    com.bytetrack.ui.viewmodels.DrinkLogViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DrinkTypeSelection(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.DrinkType selectedDrinkType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.bytetrack.data.model.DrinkType, kotlin.Unit> onDrinkTypeSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AmountSelector(float amount, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onAmountChanged) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AmountChip(float amount, boolean isSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NutritionValue(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
}