package com.bytetrack.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\'J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\'J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/bytetrack/data/dao/UserProfileDao;", "", "getDailyCalorieGoal", "Landroidx/lifecycle/LiveData;", "", "getDailyWaterGoal", "getUserProfile", "Lcom/bytetrack/data/model/UserProfile;", "getUserProfileSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserTheme", "", "insertUserProfile", "", "userProfile", "(Lcom/bytetrack/data/model/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePremiumStatus", "isPremium", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTheme", "theme", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "app_release"})
@androidx.room.Dao()
public abstract interface UserProfileDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUserProfile(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.UserProfile userProfile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUserProfile(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.UserProfile userProfile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM user_profile WHERE id = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.bytetrack.data.model.UserProfile> getUserProfile();
    
    @androidx.room.Query(value = "SELECT * FROM user_profile WHERE id = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserProfileSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.bytetrack.data.model.UserProfile> $completion);
    
    @androidx.room.Query(value = "SELECT dailyCalorieGoal FROM user_profile WHERE id = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> getDailyCalorieGoal();
    
    @androidx.room.Query(value = "SELECT dailyWaterGoal FROM user_profile WHERE id = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> getDailyWaterGoal();
    
    @androidx.room.Query(value = "SELECT theme FROM user_profile WHERE id = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.String> getUserTheme();
    
    @androidx.room.Query(value = "UPDATE user_profile SET theme = :theme WHERE id = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTheme(@org.jetbrains.annotations.NotNull()
    java.lang.String theme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_profile SET isPremium = :isPremium WHERE id = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePremiumStatus(boolean isPremium, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}