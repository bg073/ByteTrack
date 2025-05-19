package com.bytetrack.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/bytetrack/data/dao/GoalHistoryDao;", "", "getAchievedGoals", "", "Lcom/bytetrack/data/model/GoalHistory;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAchievedGoalsCount", "", "getAllGoalHistory", "getGoalHistoryBetweenDates", "startDate", "Ljava/util/Date;", "endDate", "(Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGoalHistoryByType", "goalType", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertGoalHistory", "", "goalHistory", "(Lcom/bytetrack/data/model/GoalHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateGoalHistory", "", "app_debug"})
@androidx.room.Dao()
public abstract interface GoalHistoryDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertGoalHistory(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.GoalHistory goalHistory, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateGoalHistory(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.GoalHistory goalHistory, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM goal_history ORDER BY date DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllGoalHistory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.bytetrack.data.model.GoalHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM goal_history WHERE goalType = :goalType ORDER BY date DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGoalHistoryByType(@org.jetbrains.annotations.NotNull()
    java.lang.String goalType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.bytetrack.data.model.GoalHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM goal_history WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGoalHistoryBetweenDates(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.bytetrack.data.model.GoalHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM goal_history WHERE achieved = 1 ORDER BY date DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAchievedGoals(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.bytetrack.data.model.GoalHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM goal_history WHERE achieved = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAchievedGoalsCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}