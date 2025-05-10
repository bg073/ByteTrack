package com.bytetrack.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u000f"}, d2 = {"Lcom/bytetrack/data/repository/OpenFoodFactsRepository;", "", "()V", "api", "Lcom/bytetrack/data/api/OpenFoodFactsService;", "getProductByBarcode", "Lkotlin/Result;", "Lcom/bytetrack/data/model/Food;", "barcode", "", "getProductByBarcode-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapResponseToFood", "response", "Lcom/bytetrack/data/api/OpenFoodFactsResponse;", "app_debug"})
public final class OpenFoodFactsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.bytetrack.data.api.OpenFoodFactsService api = null;
    
    public OpenFoodFactsRepository() {
        super();
    }
    
    private final com.bytetrack.data.model.Food mapResponseToFood(com.bytetrack.data.api.OpenFoodFactsResponse response, java.lang.String barcode) {
        return null;
    }
}