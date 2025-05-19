package com.bytetrack.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bytetrack.data.model.GoalHistory
import java.util.Date

@Dao
interface GoalHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoalHistory(goalHistory: GoalHistory): Long
    
    @Update
    suspend fun updateGoalHistory(goalHistory: GoalHistory)
    
    @Query("SELECT * FROM goal_history ORDER BY date DESC")
    suspend fun getAllGoalHistory(): List<GoalHistory>
    
    @Query("SELECT * FROM goal_history WHERE goalType = :goalType ORDER BY date DESC")
    suspend fun getGoalHistoryByType(goalType: String): List<GoalHistory>
    
    @Query("SELECT * FROM goal_history WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    suspend fun getGoalHistoryBetweenDates(startDate: Date, endDate: Date): List<GoalHistory>
    
    @Query("SELECT * FROM goal_history WHERE achieved = 1 ORDER BY date DESC")
    suspend fun getAchievedGoals(): List<GoalHistory>
    
    @Query("SELECT COUNT(*) FROM goal_history WHERE achieved = 1")
    suspend fun getAchievedGoalsCount(): Int
} 