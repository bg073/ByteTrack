package com.bytetrack.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bJ\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/bytetrack/data/repository/DrinkEntryRepository;", "", "drinkEntryDao", "Lcom/bytetrack/data/dao/DrinkEntryDao;", "(Lcom/bytetrack/data/dao/DrinkEntryDao;)V", "deleteDrinkEntry", "", "drinkEntry", "Lcom/bytetrack/data/model/DrinkEntry;", "(Lcom/bytetrack/data/model/DrinkEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDrinkEntriesForDate", "Landroidx/lifecycle/LiveData;", "", "date", "Ljava/util/Date;", "getDrinkEntriesForDateAndType", "type", "Lcom/bytetrack/data/model/DrinkType;", "getDrinkEntriesForToday", "getDrinkEntryById", "id", "", "getTotalCaloriesFromDrinksForToday", "", "getTotalLiquidForToday", "", "getTotalWaterForToday", "insertDrinkEntry", "updateDrinkEntry", "app_debug"})
public final class DrinkEntryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.bytetrack.data.dao.DrinkEntryDao drinkEntryDao = null;
    
    public DrinkEntryRepository(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.dao.DrinkEntryDao drinkEntryDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.data.model.DrinkEntry>> getDrinkEntriesForToday() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.data.model.DrinkEntry>> getDrinkEntriesForDate(@org.jetbrains.annotations.NotNull()
    java.util.Date date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.data.model.DrinkEntry>> getDrinkEntriesForDateAndType(@org.jetbrains.annotations.NotNull()
    java.util.Date date, @org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.DrinkType type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Float> getTotalLiquidForToday() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Float> getTotalWaterForToday() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getTotalCaloriesFromDrinksForToday() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertDrinkEntry(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.DrinkEntry drinkEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateDrinkEntry(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.DrinkEntry drinkEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteDrinkEntry(@org.jetbrains.annotations.NotNull()
    com.bytetrack.data.model.DrinkEntry drinkEntry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bytetrack.data.model.DrinkEntry> getDrinkEntryById(long id) {
        return null;
    }
}