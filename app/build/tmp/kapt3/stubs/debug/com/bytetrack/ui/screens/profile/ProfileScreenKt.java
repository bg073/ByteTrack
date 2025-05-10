package com.bytetrack.ui.screens.profile;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a@\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a@\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001c"}, d2 = {"ProfileScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/bytetrack/ui/viewmodels/ProfileViewModel;", "ProfileTextField", "value", "", "onValueChange", "Lkotlin/Function1;", "label", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "ProfileTextField-YyDlPXQ", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;I)V", "ThemeToggle", "isDarkTheme", "", "onThemeChange", "saveUserProfile", "currentProfile", "Lcom/bytetrack/data/model/UserProfile;", "name", "age", "height", "weight", "calorieGoal", "app_debug"})
public final class ProfileScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ProfileScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.bytetrack.ui.viewmodels.ProfileViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ThemeToggle(boolean isDarkTheme, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onThemeChange) {
    }
    
    private static final void saveUserProfile(com.bytetrack.ui.viewmodels.ProfileViewModel viewModel, com.bytetrack.data.model.UserProfile currentProfile, java.lang.String name, java.lang.String age, java.lang.String height, java.lang.String weight, java.lang.String calorieGoal) {
    }
}