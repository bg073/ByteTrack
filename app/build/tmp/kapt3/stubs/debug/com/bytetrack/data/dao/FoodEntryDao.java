package com.bytetrack.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\'J,\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\'J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\'J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\'J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\'J\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/bytetrack/data/dao/FoodEntryDao;", "", "deleteFoodEntry", "", "foodEntry", "Lcom/bytetrack/data/model/FoodEntry;", "(Lcom/bytetrack/data/model/FoodEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFoodEntriesForDateRange", "Landroidx/lifecycle/LiveData;", "", "startDate", "Ljava/util/Date;", "endDate", "getFoodEntriesForMealType", "mealType", "Lcom/bytetrack/data/model/MealType;", "getFoodEntryById", "id", "", "getTotalCaloriesForDateRange", "", "getTotalCarbsForDateRange", "", "getTotalFatForDateRange", "getTotalProteinForDateRange", "insertFoodEntry", "updateFoodEntry", "app_debug"})
@androidx.room.Dao()
public abstract interface FoodEntryDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertFoodEntry(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.FoodEntry foodEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateFoodEntry(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.FoodEntry foodEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteFoodEntry(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.FoodEntry foodEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM food_entries WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.bytetrack.data.model.FoodEntry> getFoodEntryById(long id);
    
    @androidx.room.Query(value = "SELECT * FROM food_entries WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.bytetrack.data.model.FoodEntry>> getFoodEntriesForDateRange(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate);
    
    @androidx.room.Query(value = "SELECT * FROM food_entries WHERE date BETWEEN :startDate AND :endDate AND mealType = :mealType ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.bytetrack.data.model.FoodEntry>> getFoodEntriesForMealType(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate, @org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.MealType mealType);
    
    @androidx.room.Query(value = "SELECT SUM(f.calories * fe.servings) FROM food_entries fe JOIN foods f ON fe.foodId = f.id WHERE fe.date BETWEEN :startDate AND :endDate")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> getTotalCaloriesForDateRange(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate);
    
    @androidx.room.Query(value = "SELECT SUM(f.protein * fe.servings) FROM food_entries fe JOIN foods f ON fe.foodId = f.id WHERE fe.date BETWEEN :startDate AND :endDate")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Float> getTotalProteinForDateRange(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate);
    
    @androidx.room.Query(value = "SELECT SUM(f.carbs * fe.servings) FROM food_entries fe JOIN foods f ON fe.foodId = f.id WHERE fe.date BETWEEN :startDate AND :endDate")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Float> getTotalCarbsForDateRange(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate);
    
    @androidx.room.Query(value = "SELECT SUM(f.fat * fe.servings) FROM food_entries fe JOIN foods f ON fe.foodId = f.id WHERE fe.date BETWEEN :startDate AND :endDate")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Float> getTotalFatForDateRange(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate);
}