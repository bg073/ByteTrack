package com.bytetrack.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_dailyStats", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$DailyStats;", "_monthlyStats", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$MonthlyStats;", "_weeklyStats", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$WeeklyStats;", "dailyStats", "Landroidx/lifecycle/LiveData;", "getDailyStats", "()Landroidx/lifecycle/LiveData;", "database", "Lcom/bytetrack/data/AppDatabase;", "foodEntryRepository", "Lcom/bytetrack/data/repository/FoodEntryRepository;", "monthlyStats", "getMonthlyStats", "weeklyStats", "getWeeklyStats", "loadDailyStats", "", "loadMonthlyStats", "loadWeeklyStats", "DailyStats", "MonthlyStats", "WeeklyStats", "app_release"})
public final class StatsViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.bytetrack.data.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bytetrack.data.repository.FoodEntryRepository foodEntryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.bytetrack.ui.viewmodels.StatsViewModel.DailyStats> _dailyStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.StatsViewModel.DailyStats> dailyStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.bytetrack.ui.viewmodels.StatsViewModel.WeeklyStats> _weeklyStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.StatsViewModel.WeeklyStats> weeklyStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.bytetrack.ui.viewmodels.StatsViewModel.MonthlyStats> _monthlyStats = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.StatsViewModel.MonthlyStats> monthlyStats = null;
    
    public StatsViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.StatsViewModel.DailyStats> getDailyStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.StatsViewModel.WeeklyStats> getWeeklyStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.StatsViewModel.MonthlyStats> getMonthlyStats() {
        return null;
    }
    
    private final void loadDailyStats() {
    }
    
    private final void loadWeeklyStats() {
    }
    
    private final void loadMonthlyStats() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel$DailyStats;", "", "date", "Ljava/util/Date;", "totalCalories", "", "totalProtein", "", "totalCarbs", "totalFat", "(Ljava/util/Date;IFFF)V", "getDate", "()Ljava/util/Date;", "getTotalCalories", "()I", "getTotalCarbs", "()F", "getTotalFat", "getTotalProtein", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"})
    public static final class DailyStats {
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date date = null;
        private final int totalCalories = 0;
        private final float totalProtein = 0.0F;
        private final float totalCarbs = 0.0F;
        private final float totalFat = 0.0F;
        
        public DailyStats(@org.jetbrains.annotations.NotNull()
        java.util.Date date, int totalCalories, float totalProtein, float totalCarbs, float totalFat) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date getDate() {
            return null;
        }
        
        public final int getTotalCalories() {
            return 0;
        }
        
        public final float getTotalProtein() {
            return 0.0F;
        }
        
        public final float getTotalCarbs() {
            return 0.0F;
        }
        
        public final float getTotalFat() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        public final float component4() {
            return 0.0F;
        }
        
        public final float component5() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.DailyStats copy(@org.jetbrains.annotations.NotNull()
        java.util.Date date, int totalCalories, float totalProtein, float totalCarbs, float totalFat) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel$MonthlyStats;", "", "startDate", "Ljava/util/Date;", "endDate", "dailyCalories", "", "", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Map;)V", "getDailyCalories", "()Ljava/util/Map;", "getEndDate", "()Ljava/util/Date;", "getStartDate", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"})
    public static final class MonthlyStats {
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date startDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date endDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<java.util.Date, java.lang.Integer> dailyCalories = null;
        
        public MonthlyStats(@org.jetbrains.annotations.NotNull()
        java.util.Date startDate, @org.jetbrains.annotations.NotNull()
        java.util.Date endDate, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.util.Date, java.lang.Integer> dailyCalories) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date getStartDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date getEndDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.util.Date, java.lang.Integer> getDailyCalories() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.util.Date, java.lang.Integer> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.MonthlyStats copy(@org.jetbrains.annotations.NotNull()
        java.util.Date startDate, @org.jetbrains.annotations.NotNull()
        java.util.Date endDate, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.util.Date, java.lang.Integer> dailyCalories) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel$WeeklyStats;", "", "startDate", "Ljava/util/Date;", "endDate", "dailyCalories", "", "", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Map;)V", "getDailyCalories", "()Ljava/util/Map;", "getEndDate", "()Ljava/util/Date;", "getStartDate", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"})
    public static final class WeeklyStats {
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date startDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date endDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<java.util.Date, java.lang.Integer> dailyCalories = null;
        
        public WeeklyStats(@org.jetbrains.annotations.NotNull()
        java.util.Date startDate, @org.jetbrains.annotations.NotNull()
        java.util.Date endDate, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.util.Date, java.lang.Integer> dailyCalories) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date getStartDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date getEndDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.util.Date, java.lang.Integer> getDailyCalories() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.util.Date, java.lang.Integer> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.WeeklyStats copy(@org.jetbrains.annotations.NotNull()
        java.util.Date startDate, @org.jetbrains.annotations.NotNull()
        java.util.Date endDate, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.util.Date, java.lang.Integer> dailyCalories) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}