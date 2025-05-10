package com.bytetrack.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bJ\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0019J\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/bytetrack/data/repository/FoodEntryRepository;", "", "foodEntryDao", "Lcom/bytetrack/data/dao/FoodEntryDao;", "(Lcom/bytetrack/data/dao/FoodEntryDao;)V", "deleteFoodEntry", "", "foodEntry", "Lcom/bytetrack/data/model/FoodEntry;", "(Lcom/bytetrack/data/model/FoodEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFoodEntriesForDate", "Landroidx/lifecycle/LiveData;", "", "date", "Ljava/util/Date;", "getFoodEntriesForDateAndMealType", "mealType", "Lcom/bytetrack/data/model/MealType;", "getFoodEntriesForToday", "getFoodEntryById", "id", "", "getTotalCaloriesForToday", "", "getTotalNutrientsForToday", "", "", "insertFoodEntry", "updateFoodEntry", "app_debug"})
public final class FoodEntryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.bytetrack.data.dao.FoodEntryDao foodEntryDao = null;
    
    public FoodEntryRepository(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.dao.FoodEntryDao foodEntryDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.data.model.FoodEntry>> getFoodEntriesForToday() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.data.model.FoodEntry>> getFoodEntriesForDate(@org.jetbrains.annotations.NotNull()
    java.util.Date date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.data.model.FoodEntry>> getFoodEntriesForDateAndMealType(@org.jetbrains.annotations.NotNull()
    java.util.Date date, @org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.MealType mealType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getTotalCaloriesForToday() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, androidx.lifecycle.LiveData<?>> getTotalNutrientsForToday() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertFoodEntry(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.FoodEntry foodEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFoodEntry(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.FoodEntry foodEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteFoodEntry(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.FoodEntry foodEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bytetrack.data.model.FoodEntry> getFoodEntryById(long id) {
        return null;
    }
}