package com.bytetrack.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/bytetrack/ui/viewmodels/ProfileViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "database", "Lcom/bytetrack/data/AppDatabase;", "userProfile", "Landroidx/lifecycle/LiveData;", "Lcom/bytetrack/data/model/UserProfile;", "getUserProfile", "()Landroidx/lifecycle/LiveData;", "userProfileRepository", "Lcom/bytetrack/data/repository/UserProfileRepository;", "updatePremiumStatus", "", "isPremium", "", "updateTheme", "theme", "", "updateUserProfile", "app_release"})
public final class ProfileViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.bytetrack.data.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bytetrack.data.repository.UserProfileRepository userProfileRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.bytetrack.data.model.UserProfile> userProfile = null;
    
    public ProfileViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bytetrack.data.model.UserProfile> getUserProfile() {
        return null;
    }
    
    public final void updateUserProfile(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.UserProfile userProfile) {
    }
    
    public final void updateTheme(@org.jetbrains.annotations.NotNull()
    java.lang.String theme) {
    }
    
    public final void updatePremiumStatus(boolean isPremium) {
    }
}