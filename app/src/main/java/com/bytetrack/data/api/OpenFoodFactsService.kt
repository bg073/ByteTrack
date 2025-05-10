package com.bytetrack.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenFoodFactsService {
    
    @GET("api/v0/product/{barcode}.json")
    suspend fun getProductByBarcode(@Path("barcode") barcode: String): Response<OpenFoodFactsResponse>
    
    companion object {
        const val BASE_URL = "https://world.openfoodfacts.org/"
    }
}

data class OpenFoodFactsResponse(
    val code: String,
    val product: Product,
    val status: Int,
    val status_verbose: String
)

data class Product(
    val product_name: String? = null,
    val brands: String? = null,
    val image_url: String? = null,
    val nutriments: Nutriments? = null
)

data class Nutriments(
    val energy_kcal_100g: Float = 0f,
    val carbohydrates_100g: Float = 0f,
    val fat_100g: Float = 0f,
    val proteins_100g: Float = 0f,
    val salt_100g: Float = 0f,
    val sugars_100g: Float = 0f,
    val fiber_100g: Float = 0f
) 