package com.bytetrack.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/bytetrack/data/api/OpenFoodFactsService;", "", "getProductByBarcode", "Lretrofit2/Response;", "Lcom/bytetrack/data/api/OpenFoodFactsResponse;", "barcode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"})
public abstract interface OpenFoodFactsService {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://world.openfoodfacts.org/";
    @org.jetbrains.annotations.NotNull()
    public static final com.bytetrack.data.api.OpenFoodFactsService.Companion Companion = null;
    
    @retrofit2.http.GET(value = "api/v0/product/{barcode}.json")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProductByBarcode(@retrofit2.http.Path(value = "barcode")
    @org.jetbrains.annotations.NotNull()
    java.lang.String barcode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.bytetrack.data.api.OpenFoodFactsResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/bytetrack/data/api/OpenFoodFactsService$Companion;", "", "()V", "BASE_URL", "", "app_release"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://world.openfoodfacts.org/";
        
        private Companion() {
            super();
        }
    }
}