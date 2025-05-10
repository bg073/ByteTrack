package com.bytetrack.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.bytetrack.data.model.Food
import com.bytetrack.data.model.MealType
import com.bytetrack.ui.theme.ByteTrackTheme
import com.bytetrack.ui.viewmodels.LogFoodViewModel

class FoodDetailsActivity : ComponentActivity() {
    
    companion object {
        const val EXTRA_BARCODE = "extra_barcode"
        const val EXTRA_FOOD = "extra_food"
    }
    
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val barcode = intent.getStringExtra(EXTRA_BARCODE)
        val food = intent.getParcelableExtra<Food>(EXTRA_FOOD)
        
        setContent {
            ByteTrackTheme {
                val viewModel: LogFoodViewModel = viewModel()
                val scannedFood by viewModel.scannedFood.observeAsState()
                val isLoading by viewModel.isLoading.observeAsState(false)
                val errorMessage by viewModel.errorMessage.observeAsState("")
                
                LaunchedEffect(key1 = true) {
                    if (food != null) {
                        // If food was passed directly, use it
                        viewModel.setScannedFood(food)
                    } else if (!barcode.isNullOrEmpty()) {
                        // Otherwise search by barcode
                        viewModel.searchFoodByBarcode(barcode)
                    } else {
                        // No food or barcode, finish activity
                        finish()
                    }
                }
                
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Food Details") },
                            navigationIcon = {
                                IconButton(onClick = { finish() }) {
                                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        when {
                            isLoading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.padding(16.dp)
                                )
                                Text("Loading food information...")
                            }
                            !errorMessage.isNullOrEmpty() -> {
                                Text(
                                    text = "Error: Scan Qr Again",
                                    color = MaterialTheme.colorScheme.error,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                            scannedFood != null -> {
                                FoodDetailsContent(
                                    food = scannedFood!!,
                                    onAddFood = { food, mealType, servingSize ->
                                        viewModel.logFoodEntry(food, mealType, servingSize)
                                        finish()
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FoodDetailsContent(
    food: Food,
    onAddFood: (Food, MealType, Float) -> Unit
) {
    var servingSize by remember { mutableStateOf("1") }
    var selectedMealType by remember { mutableStateOf(MealType.BREAKFAST) }
    
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Food image
        food.imageUrl?.let { imageUrl ->
            AsyncImage(
                model = imageUrl,
                contentDescription = "Food image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Food name
        Text(
            text = food.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Nutrition info card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Nutrition Information",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                NutritionInfo(label = "Calories", value = "${food.calories} kcal")
                NutritionInfo(label = "Carbs", value = "${food.carbs}g")
                NutritionInfo(label = "Protein", value = "${food.protein}g")
                NutritionInfo(label = "Fat", value = "${food.fat}g")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Serving size input
        OutlinedTextField(
            value = servingSize,
            onValueChange = { servingSize = it },
            label = { Text("Serving Size") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Meal type selection
        Text(
            text = "Meal Type",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        MealTypeOption(
            mealType = MealType.BREAKFAST,
            isSelected = selectedMealType == MealType.BREAKFAST,
            onSelected = { selectedMealType = MealType.BREAKFAST }
        )
        
        MealTypeOption(
            mealType = MealType.LUNCH,
            isSelected = selectedMealType == MealType.LUNCH,
            onSelected = { selectedMealType = MealType.LUNCH }
        )
        
        MealTypeOption(
            mealType = MealType.DINNER,
            isSelected = selectedMealType == MealType.DINNER,
            onSelected = { selectedMealType = MealType.DINNER }
        )
        
        MealTypeOption(
            mealType = MealType.SNACK,
            isSelected = selectedMealType == MealType.SNACK,
            onSelected = { selectedMealType = MealType.SNACK }
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Add food button
        Button(
            onClick = {
                onAddFood(
                    food,
                    selectedMealType,
                    servingSize.toFloatOrNull() ?: 1f
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Add Food",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun NutritionInfo(label: String, value: String) {
    Text(
        text = "$label: $value",
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun MealTypeOption(
    mealType: MealType,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onSelected
        )
        
        Text(
            text = when (mealType) {
                MealType.BREAKFAST -> "Breakfast"
                MealType.LUNCH -> "Lunch"
                MealType.DINNER -> "Dinner"
                MealType.SNACK -> "Snack"
            },
            modifier = Modifier.padding(start = 8.dp)
        )
    }
} 