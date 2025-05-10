package com.bytetrack.ui.screens.logdrink

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bytetrack.data.model.DrinkType
import com.bytetrack.ui.viewmodels.DrinkLogViewModel
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkLogScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    viewModel: DrinkLogViewModel = viewModel()
) {
    val context = LocalContext.current
    
    var selectedDrinkType by remember { mutableStateOf(DrinkType.WATER) }
    var amount by remember { mutableStateOf(250f) } // Default to 250ml
    var calories by remember { mutableStateOf(0) } // Default to 0 calories for water
    
    // Calculate calories based on drink type and amount
    LaunchedEffect(selectedDrinkType, amount) {
        calories = when (selectedDrinkType) {
            DrinkType.WATER -> 0
            DrinkType.COFFEE -> (amount * 0.1f).toInt() // ~1 calorie per 10ml of black coffee
            DrinkType.TEA -> (amount * 0.1f).toInt() // ~1 calorie per 10ml of tea without sugar
            DrinkType.SODA -> (amount * 0.4f).toInt() // ~40 calories per 100ml
            DrinkType.JUICE -> (amount * 0.5f).toInt() // ~50 calories per 100ml
            DrinkType.SMOOTHIE -> (amount * 0.6f).toInt() // ~60 calories per 100ml
            DrinkType.ALCOHOL -> (amount * 0.7f).toInt() // ~70 calories per 100ml
            DrinkType.OTHER -> (amount * 0.4f).toInt() // Default to 40 calories per 100ml
        }
    }
    
    // Format current date
    val dateFormat = SimpleDateFormat("EEEE, MMMM d", Locale.getDefault())
    val currentDate = dateFormat.format(Date())
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Log Drink") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Date display
            Text(
                text = currentDate,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Drink type selection
            DrinkTypeSelection(
                selectedDrinkType = selectedDrinkType,
                onDrinkTypeSelected = { selectedDrinkType = it }
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Amount selection
            AmountSelector(
                amount = amount,
                onAmountChanged = { amount = it }
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Calorie information
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Nutritional Information",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        NutritionValue(
                            label = "Amount",
                            value = "${amount.toInt()} ml"
                        )
                        
                        NutritionValue(
                            label = "Calories",
                            value = "$calories cal"
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Log button
            Button(
                onClick = {
                    viewModel.logDrink(
                        type = selectedDrinkType,
                        amount = amount,
                        calories = calories
                    )
                    onBackClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = when (selectedDrinkType) {
                        DrinkType.WATER -> Color(0xFF2196F3) // Water blue
                        DrinkType.COFFEE -> Color(0xFF795548) // Coffee brown
                        DrinkType.TEA -> Color(0xFF8D6E63) // Tea brown
                        DrinkType.SODA -> Color(0xFFF44336) // Soda red
                        DrinkType.JUICE -> Color(0xFFFF9800) // Juice orange
                        DrinkType.SMOOTHIE -> Color(0xFF9C27B0) // Smoothie purple
                        DrinkType.ALCOHOL -> Color(0xFFFFEB3B) // Alcohol yellow
                        DrinkType.OTHER -> Color(0xFF607D8B) // Other blue-grey
                    }
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Log drink",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "LOG ${selectedDrinkType.name}",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun DrinkTypeSelection(
    selectedDrinkType: DrinkType,
    onDrinkTypeSelected: (DrinkType) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Select Drink Type",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DrinkTypeOption(
                type = DrinkType.WATER,
                icon = Icons.Default.WaterDrop,
                isSelected = selectedDrinkType == DrinkType.WATER,
                onClick = { onDrinkTypeSelected(DrinkType.WATER) },
                color = Color(0xFF2196F3) // Water blue
            )
            
            DrinkTypeOption(
                type = DrinkType.COFFEE,
                icon = Icons.Default.Coffee,
                isSelected = selectedDrinkType == DrinkType.COFFEE,
                onClick = { onDrinkTypeSelected(DrinkType.COFFEE) },
                color = Color(0xFF795548) // Coffee brown
            )
            
            DrinkTypeOption(
                type = DrinkType.TEA,
                icon = Icons.Default.EmojiFoodBeverage,
                isSelected = selectedDrinkType == DrinkType.TEA,
                onClick = { onDrinkTypeSelected(DrinkType.TEA) },
                color = Color(0xFF8D6E63) // Tea brown
            )
            
            DrinkTypeOption(
                type = DrinkType.SODA,
                icon = Icons.Default.LocalDrink,
                isSelected = selectedDrinkType == DrinkType.SODA,
                onClick = { onDrinkTypeSelected(DrinkType.SODA) },
                color = Color(0xFFF44336) // Soda red
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DrinkTypeOption(
                type = DrinkType.JUICE,
                icon = Icons.Default.Liquor,
                isSelected = selectedDrinkType == DrinkType.JUICE,
                onClick = { onDrinkTypeSelected(DrinkType.JUICE) },
                color = Color(0xFFFF9800) // Juice orange
            )
            
            DrinkTypeOption(
                type = DrinkType.SMOOTHIE,
                icon = Icons.Default.Blender,
                isSelected = selectedDrinkType == DrinkType.SMOOTHIE,
                onClick = { onDrinkTypeSelected(DrinkType.SMOOTHIE) },
                color = Color(0xFF9C27B0) // Smoothie purple
            )
            
            DrinkTypeOption(
                type = DrinkType.ALCOHOL,
                icon = Icons.Default.LocalBar,
                isSelected = selectedDrinkType == DrinkType.ALCOHOL,
                onClick = { onDrinkTypeSelected(DrinkType.ALCOHOL) },
                color = Color(0xFFFFEB3B) // Alcohol yellow
            )
            
            DrinkTypeOption(
                type = DrinkType.OTHER,
                icon = Icons.Default.MoreHoriz,
                isSelected = selectedDrinkType == DrinkType.OTHER,
                onClick = { onDrinkTypeSelected(DrinkType.OTHER) },
                color = Color(0xFF607D8B) // Other blue-grey
            )
        }
    }
}

@Composable
fun DrinkTypeOption(
    type: DrinkType,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
    color: Color
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) color.copy(alpha = 0.3f) else Color.Transparent,
        label = "bgColorAnimation"
    )
    
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.1f else 1.0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scaleAnimation"
    )
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)
            .width(80.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(64.dp * scale)
                .clip(CircleShape)
                .background(backgroundColor)
                .clickable(onClick = onClick)
                .border(
                    width = if (isSelected) 2.dp else 1.dp,
                    color = if (isSelected) color else MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                    shape = CircleShape
                )
                .padding(12.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = type.name,
                tint = if (isSelected) color else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                modifier = Modifier.size(32.dp)
            )
        }
        
        Text(
            text = type.name.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
            style = MaterialTheme.typography.bodySmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun AmountSelector(
    amount: Float,
    onAmountChanged: (Float) -> Unit
) {
    val commonAmounts = listOf(100f, 200f, 250f, 330f, 500f, 750f, 1000f)
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Amount",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Text(
            text = "${amount.toInt()} ml",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Common amounts
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            commonAmounts.forEach { ml ->
                AmountChip(
                    amount = ml,
                    isSelected = amount == ml,
                    onClick = { onAmountChanged(ml) }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Custom amount slider
        Slider(
            value = amount,
            onValueChange = { onAmountChanged(it) },
            valueRange = 50f..2000f,
            steps = 39, // (2000-50)/50 = 39 steps (every 50ml)
            modifier = Modifier.fillMaxWidth()
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "50ml",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            
            Text(
                text = "2000ml",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmountChip(
    amount: Float,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) 
            MaterialTheme.colorScheme.primary 
        else 
            MaterialTheme.colorScheme.surface,
        label = "chipBgColorAnimation"
    )
    
    val textColor by animateColorAsState(
        targetValue = if (isSelected) 
            MaterialTheme.colorScheme.onPrimary 
        else 
            MaterialTheme.colorScheme.onSurface,
        label = "chipTextColorAnimation"
    )
    
    SuggestionChip(
        onClick = onClick,
        label = {
            Text(
                text = "${amount.toInt()} ml",
                color = textColor
            )
        },
        shape = RoundedCornerShape(16.dp),
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderColor = if (isSelected) 
                MaterialTheme.colorScheme.primary 
            else 
                MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
            borderWidth = if (isSelected) 0.dp else 1.dp
        ),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = backgroundColor
        ),
        modifier = Modifier.padding(horizontal = 4.dp)
    )
}

@Composable
fun NutritionValue(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
} 