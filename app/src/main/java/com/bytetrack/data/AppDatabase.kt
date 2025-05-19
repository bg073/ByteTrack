package com.bytetrack.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bytetrack.data.dao.DrinkEntryDao
import com.bytetrack.data.dao.FoodDao
import com.bytetrack.data.dao.FoodEntryDao
import com.bytetrack.data.dao.GoalHistoryDao
import com.bytetrack.data.dao.UserProfileDao
import com.bytetrack.data.model.DrinkEntry
import com.bytetrack.data.model.Food
import com.bytetrack.data.model.FoodEntry
import com.bytetrack.data.model.GoalHistory
import com.bytetrack.data.model.UserProfile
import com.bytetrack.utils.Converters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        Food::class, 
        FoodEntry::class, 
        DrinkEntry::class, 
        UserProfile::class,
        GoalHistory::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun foodDao(): FoodDao
    abstract fun foodEntryDao(): FoodEntryDao
    abstract fun drinkEntryDao(): DrinkEntryDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun goalHistoryDao(): GoalHistoryDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        // Migration from version 1 to 2 (adding GoalHistory table)
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Create the goal_history table
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `goal_history` (" +
                    "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`goalType` TEXT NOT NULL, " +
                    "`previousValue` INTEGER NOT NULL, " +
                    "`newValue` INTEGER NOT NULL, " +
                    "`date` INTEGER NOT NULL, " +
                    "`achieved` INTEGER NOT NULL DEFAULT 0)"
                )
            }
        }
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "bytetrack_database"
                )
                .fallbackToDestructiveMigration()
                .addMigrations(MIGRATION_1_2)
                .addCallback(DatabaseCallback())
                .build()
                
                INSTANCE = instance
                instance
            }
        }
        
        private class DatabaseCallback : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        // Create default user profile
                        val userProfileDao = database.userProfileDao()
                        val defaultUserProfile = UserProfile()
                        userProfileDao.insertUserProfile(defaultUserProfile)
                    }
                }
            }
        }
    }
} 