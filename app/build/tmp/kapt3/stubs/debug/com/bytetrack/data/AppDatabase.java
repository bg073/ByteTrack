package com.bytetrack.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/bytetrack/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "drinkEntryDao", "Lcom/bytetrack/data/dao/DrinkEntryDao;", "foodDao", "Lcom/bytetrack/data/dao/FoodDao;", "foodEntryDao", "Lcom/bytetrack/data/dao/FoodEntryDao;", "goalHistoryDao", "Lcom/bytetrack/data/dao/GoalHistoryDao;", "userProfileDao", "Lcom/bytetrack/data/dao/UserProfileDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.bytetrack.data.model.Food.class, com.bytetrack.data.model.FoodEntry.class, com.bytetrack.data.model.DrinkEntry.class, com.bytetrack.data.model.UserProfile.class, com.bytetrack.data.model.GoalHistory.class}, version = 2, exportSchema = false)
@androidx.room.TypeConverters(value = {com.bytetrack.utils.Converters.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.bytetrack.data.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.bytetrack.data.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bytetrack.data.dao.FoodDao foodDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bytetrack.data.dao.FoodEntryDao foodEntryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bytetrack.data.dao.DrinkEntryDao drinkEntryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bytetrack.data.dao.UserProfileDao userProfileDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bytetrack.data.dao.GoalHistoryDao goalHistoryDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/bytetrack/data/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/bytetrack/data/AppDatabase;", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getDatabase", "context", "Landroid/content/Context;", "DatabaseCallback", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.data.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/bytetrack/data/AppDatabase$Companion$DatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "()V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_debug"})
        static final class DatabaseCallback extends androidx.room.RoomDatabase.Callback {
            
            public DatabaseCallback() {
                super();
            }
            
            @java.lang.Override()
            public void onCreate(@org.jetbrains.annotations.NotNull()
            androidx.sqlite.db.SupportSQLiteDatabase db) {
            }
        }
    }
}