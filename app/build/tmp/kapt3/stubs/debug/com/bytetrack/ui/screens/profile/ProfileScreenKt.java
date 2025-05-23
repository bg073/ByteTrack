package com.bytetrack.ui.screens.profile;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0016\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0007\u001a4\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a(\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007\u001a2\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a@\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u001a\u0010\u0010#\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a$\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\f2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a\u000e\u0010\'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t\u001a@\u0010)\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u00060"}, d2 = {"GoalHistoryItem", "", "goal", "Lcom/bytetrack/data/model/GoalHistory;", "GoalHistoryList", "goalHistory", "", "NotificationToggle", "title", "", "description", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "ProfileHeader", "name", "profilePictureUri", "Landroid/net/Uri;", "onEditPictureClick", "Lkotlin/Function0;", "ProfileScreen", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/bytetrack/ui/viewmodels/ProfileViewModel;", "onError", "ProfileTextField", "value", "onValueChange", "label", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "ProfileTextField-YyDlPXQ", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;I)V", "SectionHeader", "ThemeToggle", "isDarkTheme", "onThemeChange", "getGoalTypeDisplayName", "goalType", "saveUserProfile", "currentProfile", "Lcom/bytetrack/data/model/UserProfile;", "age", "height", "weight", "calorieGoal", "app_debug"})
public final class ProfileScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ProfileScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.bytetrack.ui.viewmodels.ProfileViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ProfileHeader(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    android.net.Uri profilePictureUri, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEditPictureClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SectionHeader(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NotificationToggle(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean checked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onCheckedChange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ThemeToggle(boolean isDarkTheme, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onThemeChange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GoalHistoryList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bytetrack.data.model.GoalHistory> goalHistory) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GoalHistoryItem(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.GoalHistory goal) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getGoalTypeDisplayName(@org.jetbrains.annotations.NotNull()
    java.lang.String goalType) {
        return null;
    }
    
    private static final void saveUserProfile(com.bytetrack.ui.viewmodels.ProfileViewModel viewModel, com.bytetrack.data.model.UserProfile currentProfile, java.lang.String name, java.lang.String age, java.lang.String height, java.lang.String weight, java.lang.String calorieGoal) {
    }
}