package com.bytetrack.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0006XYZ[\\]B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u000208H\u0002J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0011H\u0002J\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0011H\u0002J\b\u0010F\u001a\u00020\u0011H\u0002J\b\u0010G\u001a\u00020\u0011H\u0002J\b\u0010H\u001a\u000208H\u0002J\b\u0010I\u001a\u000208H\u0002J\b\u0010J\u001a\u000208H\u0002J\b\u0010K\u001a\u000208H\u0002J\b\u0010L\u001a\u000208H\u0002J&\u0010M\u001a\u0002082\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\t2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0011H\u0002J\u0016\u0010P\u001a\u0002082\u0006\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0011J\u0010\u0010Q\u001a\u0002082\b\u0010R\u001a\u0004\u0018\u00010\u0013J\u0010\u0010S\u001a\u0002082\b\u0010<\u001a\u0004\u0018\u00010\u0015J\u000e\u0010T\u001a\u0002082\u0006\u0010U\u001a\u00020\u0017J\u0018\u0010V\u001a\u0002082\u0006\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0011H\u0002J\u0010\u0010W\u001a\u0002082\u0006\u0010U\u001a\u00020\u0017H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010$\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\f0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0019\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0019\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001dR\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001d\u00a8\u0006^"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_dailyStats", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$DailyStats;", "_filteredMealData", "", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$MealData;", "_monthlyStats", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$MonthlyStats;", "_nutritionInsights", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$NutritionInsight;", "_selectedDateRange", "Lkotlin/Pair;", "Ljava/util/Date;", "_selectedFoodCategory", "Lcom/bytetrack/ui/viewmodels/FoodCategory;", "_selectedMealType", "Lcom/bytetrack/ui/viewmodels/ViewMealType;", "_selectedTimeFrame", "Lcom/bytetrack/ui/viewmodels/TimeFrame;", "_weeklyStats", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$WeeklyStats;", "dailyStats", "Landroidx/lifecycle/LiveData;", "getDailyStats", "()Landroidx/lifecycle/LiveData;", "database", "Lcom/bytetrack/data/AppDatabase;", "filteredMealData", "getFilteredMealData", "foodEntryRepository", "Lcom/bytetrack/data/repository/FoodEntryRepository;", "mealDataCache", "", "", "monthlyStats", "getMonthlyStats", "nutritionInsights", "getNutritionInsights", "preferences", "Landroid/content/SharedPreferences;", "selectedDateRange", "getSelectedDateRange", "selectedFoodCategory", "getSelectedFoodCategory", "selectedMealType", "getSelectedMealType", "selectedTimeFrame", "getSelectedTimeFrame", "weeklyStats", "getWeeklyStats", "applyFilters", "", "cacheDailyStats", "stats", "convertMealType", "mealType", "Lcom/bytetrack/data/model/MealType;", "determineFoodCategory", "food", "Lcom/bytetrack/data/model/Food;", "generateInsights", "generateSampleMealData", "startDate", "endDate", "getCachedMealData", "getEndOfYear", "getStartOfYear", "loadDailyStats", "loadFilteredMealData", "loadMonthlyStats", "loadStats", "loadWeeklyStats", "processAndCacheFoodEntries", "entries", "Lcom/bytetrack/data/model/FoodEntry;", "setCustomDateRange", "setFoodCategory", "category", "setMealType", "setTimeFrame", "timeFrame", "setupMealDataObservers", "updateDateRange", "DailyStats", "MealData", "MonthlyStats", "NutritionData", "NutritionInsight", "WeeklyStats", "app_debug"})
public final class StatsViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.bytetrack.data.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bytetrack.data.repository.FoodEntryRepository foodEntryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences preferences = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.bytetrack.ui.viewmodels.TimeFrame> _selectedTimeFrame = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.TimeFrame> selectedTimeFrame = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.bytetrack.ui.viewmodels.ViewMealType> _selectedMealType = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.ViewMealType> selectedMealType = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.bytetrack.ui.viewmodels.FoodCategory> _selectedFoodCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.FoodCategory> selectedFoodCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.util.Date, java.util.Date>> _selectedDateRange = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Pair<java.util.Date, java.util.Date>> selectedDateRange = null;
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
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.bytetrack.ui.viewmodels.StatsViewModel.MealData>> _filteredMealData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.ui.viewmodels.StatsViewModel.MealData>> filteredMealData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.bytetrack.ui.viewmodels.StatsViewModel.NutritionInsight>> _nutritionInsights = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.ui.viewmodels.StatsViewModel.NutritionInsight>> nutritionInsights = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.util.List<com.bytetrack.ui.viewmodels.StatsViewModel.MealData>> mealDataCache = null;
    
    public StatsViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.TimeFrame> getSelectedTimeFrame() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.ViewMealType> getSelectedMealType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bytetrack.ui.viewmodels.FoodCategory> getSelectedFoodCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Pair<java.util.Date, java.util.Date>> getSelectedDateRange() {
        return null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.ui.viewmodels.StatsViewModel.MealData>> getFilteredMealData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bytetrack.ui.viewmodels.StatsViewModel.NutritionInsight>> getNutritionInsights() {
        return null;
    }
    
    public final void setTimeFrame(@org.jetbrains.annotations.NotNull()
    com.bytetrack.ui.viewmodels.TimeFrame timeFrame) {
    }
    
    public final void setMealType(@org.jetbrains.annotations.Nullable()
    com.bytetrack.ui.viewmodels.ViewMealType mealType) {
    }
    
    public final void setFoodCategory(@org.jetbrains.annotations.Nullable()
    com.bytetrack.ui.viewmodels.FoodCategory category) {
    }
    
    public final void setCustomDateRange(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate) {
    }
    
    private final void updateDateRange(com.bytetrack.ui.viewmodels.TimeFrame timeFrame) {
    }
    
    private final java.util.Date getStartOfYear() {
        return null;
    }
    
    private final java.util.Date getEndOfYear() {
        return null;
    }
    
    private final void applyFilters() {
    }
    
    private final void loadStats() {
    }
    
    private final void loadDailyStats() {
    }
    
    private final void cacheDailyStats(com.bytetrack.ui.viewmodels.StatsViewModel.DailyStats stats) {
    }
    
    private final void loadWeeklyStats() {
    }
    
    private final void loadMonthlyStats() {
    }
    
    private final void loadFilteredMealData() {
    }
    
    private final java.util.List<com.bytetrack.ui.viewmodels.StatsViewModel.MealData> generateSampleMealData(java.util.Date startDate, java.util.Date endDate) {
        return null;
    }
    
    private final java.util.List<com.bytetrack.ui.viewmodels.StatsViewModel.MealData> getCachedMealData(java.util.Date startDate, java.util.Date endDate) {
        return null;
    }
    
    private final void setupMealDataObservers(java.util.Date startDate, java.util.Date endDate) {
    }
    
    private final void processAndCacheFoodEntries(java.util.List<com.bytetrack.data.model.FoodEntry> entries, java.util.Date startDate, java.util.Date endDate) {
    }
    
    private final com.bytetrack.ui.viewmodels.ViewMealType convertMealType(com.bytetrack.data.model.MealType mealType) {
        return null;
    }
    
    private final com.bytetrack.ui.viewmodels.FoodCategory determineFoodCategory(com.bytetrack.data.model.Food food) {
        return null;
    }
    
    private final void generateInsights() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u00c6\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u00c6\u0003Jg\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000bH\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00d6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006*"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel$DailyStats;", "", "date", "Ljava/util/Date;", "totalCalories", "", "totalProtein", "", "totalCarbs", "totalFat", "mealBreakdown", "", "Lcom/bytetrack/ui/viewmodels/ViewMealType;", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$NutritionData;", "categoryBreakdown", "Lcom/bytetrack/ui/viewmodels/FoodCategory;", "(Ljava/util/Date;IFFFLjava/util/Map;Ljava/util/Map;)V", "getCategoryBreakdown", "()Ljava/util/Map;", "getDate", "()Ljava/util/Date;", "getMealBreakdown", "getTotalCalories", "()I", "getTotalCarbs", "()F", "getTotalFat", "getTotalProtein", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class DailyStats {
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date date = null;
        private final int totalCalories = 0;
        private final float totalProtein = 0.0F;
        private final float totalCarbs = 0.0F;
        private final float totalFat = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> mealBreakdown = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> categoryBreakdown = null;
        
        public DailyStats(@org.jetbrains.annotations.NotNull()
        java.util.Date date, int totalCalories, float totalProtein, float totalCarbs, float totalFat, @org.jetbrains.annotations.NotNull()
        java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> mealBreakdown, @org.jetbrains.annotations.NotNull()
        java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> categoryBreakdown) {
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
        public final java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> getMealBreakdown() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> getCategoryBreakdown() {
            return null;
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
        public final java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.DailyStats copy(@org.jetbrains.annotations.NotNull()
        java.util.Date date, int totalCalories, float totalProtein, float totalCarbs, float totalFat, @org.jetbrains.annotations.NotNull()
        java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> mealBreakdown, @org.jetbrains.annotations.NotNull()
        java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData> categoryBreakdown) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u00c6\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel$MealData;", "", "date", "Ljava/util/Date;", "mealType", "Lcom/bytetrack/ui/viewmodels/ViewMealType;", "nutrition", "Lcom/bytetrack/ui/viewmodels/StatsViewModel$NutritionData;", "foodCategory", "Lcom/bytetrack/ui/viewmodels/FoodCategory;", "(Ljava/util/Date;Lcom/bytetrack/ui/viewmodels/ViewMealType;Lcom/bytetrack/ui/viewmodels/StatsViewModel$NutritionData;Lcom/bytetrack/ui/viewmodels/FoodCategory;)V", "getDate", "()Ljava/util/Date;", "getFoodCategory", "()Lcom/bytetrack/ui/viewmodels/FoodCategory;", "getMealType", "()Lcom/bytetrack/ui/viewmodels/ViewMealType;", "getNutrition", "()Lcom/bytetrack/ui/viewmodels/StatsViewModel$NutritionData;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class MealData {
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date date = null;
        @org.jetbrains.annotations.NotNull()
        private final com.bytetrack.ui.viewmodels.ViewMealType mealType = null;
        @org.jetbrains.annotations.NotNull()
        private final com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData nutrition = null;
        @org.jetbrains.annotations.Nullable()
        private final com.bytetrack.ui.viewmodels.FoodCategory foodCategory = null;
        
        public MealData(@org.jetbrains.annotations.NotNull()
        java.util.Date date, @org.jetbrains.annotations.NotNull()
        com.bytetrack.ui.viewmodels.ViewMealType mealType, @org.jetbrains.annotations.NotNull()
        com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData nutrition, @org.jetbrains.annotations.Nullable()
        com.bytetrack.ui.viewmodels.FoodCategory foodCategory) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date getDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.ViewMealType getMealType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData getNutrition() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.bytetrack.ui.viewmodels.FoodCategory getFoodCategory() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.ViewMealType component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.bytetrack.ui.viewmodels.FoodCategory component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.MealData copy(@org.jetbrains.annotations.NotNull()
        java.util.Date date, @org.jetbrains.annotations.NotNull()
        com.bytetrack.ui.viewmodels.ViewMealType mealType, @org.jetbrains.annotations.NotNull()
        com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData nutrition, @org.jetbrains.annotations.Nullable()
        com.bytetrack.ui.viewmodels.FoodCategory foodCategory) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\n0\t\u00a2\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\u001b\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\n0\tH\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\rH\u00c6\u0003J\t\u0010\'\u001a\u00020\rH\u00c6\u0003J\t\u0010(\u001a\u00020\rH\u00c6\u0003J\u001b\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\n0\tH\u00c6\u0003J\u0093\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00062\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\n0\tH\u00c6\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020\u0007H\u00d6\u0001J\t\u0010/\u001a\u000200H\u00d6\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001f\u00a8\u00061"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel$MonthlyStats;", "", "startDate", "Ljava/util/Date;", "endDate", "dailyCalories", "", "", "weeklyAverages", "", "Lkotlin/Pair;", "monthlyAvgCalories", "monthlyAvgProtein", "", "monthlyAvgCarbs", "monthlyAvgFat", "topCategories", "Lcom/bytetrack/ui/viewmodels/FoodCategory;", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Map;Ljava/util/List;IFFFLjava/util/List;)V", "getDailyCalories", "()Ljava/util/Map;", "getEndDate", "()Ljava/util/Date;", "getMonthlyAvgCalories", "()I", "getMonthlyAvgCarbs", "()F", "getMonthlyAvgFat", "getMonthlyAvgProtein", "getStartDate", "getTopCategories", "()Ljava/util/List;", "getWeeklyAverages", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class MonthlyStats {
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date startDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date endDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<java.util.Date, java.lang.Integer> dailyCalories = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<kotlin.Pair<java.util.Date, java.lang.Integer>> weeklyAverages = null;
        private final int monthlyAvgCalories = 0;
        private final float monthlyAvgProtein = 0.0F;
        private final float monthlyAvgCarbs = 0.0F;
        private final float monthlyAvgFat = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<kotlin.Pair<com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Integer>> topCategories = null;
        
        public MonthlyStats(@org.jetbrains.annotations.NotNull()
        java.util.Date startDate, @org.jetbrains.annotations.NotNull()
        java.util.Date endDate, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.util.Date, java.lang.Integer> dailyCalories, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends kotlin.Pair<? extends java.util.Date, java.lang.Integer>> weeklyAverages, int monthlyAvgCalories, float monthlyAvgProtein, float monthlyAvgCarbs, float monthlyAvgFat, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends kotlin.Pair<? extends com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Integer>> topCategories) {
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
        public final java.util.List<kotlin.Pair<java.util.Date, java.lang.Integer>> getWeeklyAverages() {
            return null;
        }
        
        public final int getMonthlyAvgCalories() {
            return 0;
        }
        
        public final float getMonthlyAvgProtein() {
            return 0.0F;
        }
        
        public final float getMonthlyAvgCarbs() {
            return 0.0F;
        }
        
        public final float getMonthlyAvgFat() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<kotlin.Pair<com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Integer>> getTopCategories() {
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
        public final java.util.List<kotlin.Pair<java.util.Date, java.lang.Integer>> component4() {
            return null;
        }
        
        public final int component5() {
            return 0;
        }
        
        public final float component6() {
            return 0.0F;
        }
        
        public final float component7() {
            return 0.0F;
        }
        
        public final float component8() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<kotlin.Pair<com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Integer>> component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.MonthlyStats copy(@org.jetbrains.annotations.NotNull()
        java.util.Date startDate, @org.jetbrains.annotations.NotNull()
        java.util.Date endDate, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.util.Date, java.lang.Integer> dailyCalories, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends kotlin.Pair<? extends java.util.Date, java.lang.Integer>> weeklyAverages, int monthlyAvgCalories, float monthlyAvgProtein, float monthlyAvgCarbs, float monthlyAvgFat, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends kotlin.Pair<? extends com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Integer>> topCategories) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel$NutritionData;", "", "calories", "", "protein", "", "carbs", "fat", "(IFFF)V", "getCalories", "()I", "getCarbs", "()F", "getFat", "getProtein", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class NutritionData {
        private final int calories = 0;
        private final float protein = 0.0F;
        private final float carbs = 0.0F;
        private final float fat = 0.0F;
        
        public NutritionData(int calories, float protein, float carbs, float fat) {
            super();
        }
        
        public final int getCalories() {
            return 0;
        }
        
        public final float getProtein() {
            return 0.0F;
        }
        
        public final float getCarbs() {
            return 0.0F;
        }
        
        public final float getFat() {
            return 0.0F;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final float component2() {
            return 0.0F;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        public final float component4() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.NutritionData copy(int calories, float protein, float carbs, float fat) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel$NutritionInsight;", "", "type", "Lcom/bytetrack/ui/viewmodels/InsightType;", "title", "", "description", "value", "", "recommendation", "(Lcom/bytetrack/ui/viewmodels/InsightType;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getRecommendation", "getTitle", "getType", "()Lcom/bytetrack/ui/viewmodels/InsightType;", "getValue", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class NutritionInsight {
        @org.jetbrains.annotations.NotNull()
        private final com.bytetrack.ui.viewmodels.InsightType type = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String title = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String description = null;
        private final float value = 0.0F;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String recommendation = null;
        
        public NutritionInsight(@org.jetbrains.annotations.NotNull()
        com.bytetrack.ui.viewmodels.InsightType type, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String description, float value, @org.jetbrains.annotations.Nullable()
        java.lang.String recommendation) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.InsightType getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDescription() {
            return null;
        }
        
        public final float getValue() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getRecommendation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.InsightType component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        public final float component4() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.NutritionInsight copy(@org.jetbrains.annotations.NotNull()
        com.bytetrack.ui.viewmodels.InsightType type, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String description, float value, @org.jetbrains.annotations.Nullable()
        java.lang.String recommendation) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003J\t\u0010$\u001a\u00020\nH\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0006H\u00c6\u0003J\u0015\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u0006H\u00c6\u0003J\u0087\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u00062\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u0006H\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u0007H\u00d6\u0001J\t\u0010-\u001a\u00020.H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b\u00a8\u0006/"}, d2 = {"Lcom/bytetrack/ui/viewmodels/StatsViewModel$WeeklyStats;", "", "startDate", "Ljava/util/Date;", "endDate", "dailyCalories", "", "", "averageCalories", "averageProtein", "", "averageCarbs", "averageFat", "mealTypePercentages", "Lcom/bytetrack/ui/viewmodels/ViewMealType;", "foodCategoryPercentages", "Lcom/bytetrack/ui/viewmodels/FoodCategory;", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Map;IFFFLjava/util/Map;Ljava/util/Map;)V", "getAverageCalories", "()I", "getAverageCarbs", "()F", "getAverageFat", "getAverageProtein", "getDailyCalories", "()Ljava/util/Map;", "getEndDate", "()Ljava/util/Date;", "getFoodCategoryPercentages", "getMealTypePercentages", "getStartDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class WeeklyStats {
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date startDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Date endDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<java.util.Date, java.lang.Integer> dailyCalories = null;
        private final int averageCalories = 0;
        private final float averageProtein = 0.0F;
        private final float averageCarbs = 0.0F;
        private final float averageFat = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, java.lang.Float> mealTypePercentages = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Float> foodCategoryPercentages = null;
        
        public WeeklyStats(@org.jetbrains.annotations.NotNull()
        java.util.Date startDate, @org.jetbrains.annotations.NotNull()
        java.util.Date endDate, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.util.Date, java.lang.Integer> dailyCalories, int averageCalories, float averageProtein, float averageCarbs, float averageFat, @org.jetbrains.annotations.NotNull()
        java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, java.lang.Float> mealTypePercentages, @org.jetbrains.annotations.NotNull()
        java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Float> foodCategoryPercentages) {
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
        
        public final int getAverageCalories() {
            return 0;
        }
        
        public final float getAverageProtein() {
            return 0.0F;
        }
        
        public final float getAverageCarbs() {
            return 0.0F;
        }
        
        public final float getAverageFat() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, java.lang.Float> getMealTypePercentages() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Float> getFoodCategoryPercentages() {
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
        
        public final int component4() {
            return 0;
        }
        
        public final float component5() {
            return 0.0F;
        }
        
        public final float component6() {
            return 0.0F;
        }
        
        public final float component7() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, java.lang.Float> component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Float> component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bytetrack.ui.viewmodels.StatsViewModel.WeeklyStats copy(@org.jetbrains.annotations.NotNull()
        java.util.Date startDate, @org.jetbrains.annotations.NotNull()
        java.util.Date endDate, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.util.Date, java.lang.Integer> dailyCalories, int averageCalories, float averageProtein, float averageCarbs, float averageFat, @org.jetbrains.annotations.NotNull()
        java.util.Map<com.bytetrack.ui.viewmodels.ViewMealType, java.lang.Float> mealTypePercentages, @org.jetbrains.annotations.NotNull()
        java.util.Map<com.bytetrack.ui.viewmodels.FoodCategory, java.lang.Float> foodCategoryPercentages) {
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