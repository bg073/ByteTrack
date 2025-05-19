package com.bytetrack.data.repository

import com.bytetrack.data.dao.GoalHistoryDao
import com.bytetrack.data.model.GoalHistory
import java.util.Date

class GoalHistoryRepository(private val goalHistoryDao: GoalHistoryDao) {
    
    suspend fun insertGoalHistory(goalHistory: GoalHistory): Long {
        return goalHistoryDao.insertGoalHistory(goalHistory)
    }
    
    suspend fun updateGoalHistory(goalHistory: GoalHistory) {
        goalHistoryDao.updateGoalHistory(goalHistory)
    }
    
    suspend fun getAllGoalHistory(): List<GoalHistory> {
        return goalHistoryDao.getAllGoalHistory()
    }
    
    suspend fun getGoalHistoryByType(goalType: String): List<GoalHistory> {
        return goalHistoryDao.getGoalHistoryByType(goalType)
    }
    
    suspend fun getGoalHistoryBetweenDates(startDate: Date, endDate: Date): List<GoalHistory> {
        return goalHistoryDao.getGoalHistoryBetweenDates(startDate, endDate)
    }
    
    suspend fun getAchievedGoals(): List<GoalHistory> {
        return goalHistoryDao.getAchievedGoals()
    }
    
    suspend fun getAchievedGoalsCount(): Int {
        return goalHistoryDao.getAchievedGoalsCount()
    }
} 