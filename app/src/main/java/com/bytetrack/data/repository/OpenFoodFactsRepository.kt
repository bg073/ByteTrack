package com.bytetrack.data.repository

import com.bytetrack.data.api.RetrofitClient
import com.bytetrack.data.model.Food
import com.bytetrack.data.api.OpenFoodFactsResponse
import com.bytetrack.data.api.Product
import kotlin.math.roundToInt

class OpenFoodFactsRepository {
    
    private val api = RetrofitClient.openFoodFactsService
    
    suspend fun getProductByBarcode(barcode: String): Result<Food?> {
        return try {
            val response = api.getProductByBarcode(barcode)
            if (response.isSuccessful) {
                val foodFactsResponse = response.body()
                if (foodFactsResponse != null && foodFactsResponse.status == 1) {
                    Result.success(mapResponseToFood(foodFactsResponse, barcode))
                } else {
                    Result.success(null) // Product not found but API call was successful
                }
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private fun mapResponseToFood(response: OpenFoodFactsResponse, barcode: String): Food {
        val product = response.product
        val nutriments = product.nutriments

        // Calculate calories per serving or use default if not available
        val calories = nutriments?.energy_kcal_100g?.roundToInt() ?: 0
        val protein = nutriments?.proteins_100g ?: 0f
        val carbs = nutriments?.carbohydrates_100g ?: 0f
        val fat = nutriments?.fat_100g ?: 0f
        
        return Food(
            name = product.product_name ?: "Unknown Product",
            barcode = barcode,
            calories = calories,
            protein = protein,
            carbs = carbs,
            fat = fat,
            imageUrl = product.image_url,
            servingSize = 100f,
            servingUnit = "g"
        )
    }
} 