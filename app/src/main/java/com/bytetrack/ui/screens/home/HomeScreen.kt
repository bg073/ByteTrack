package com.bytetrack.ui.screens.home

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bytetrack.R
import com.bytetrack.data.model.UserProfile
import com.bytetrack.ui.viewmodels.HomeViewModel
import kotlin.math.min

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onLogMealClick: () -> Unit = {},
    onLogDrinkClick: () -> Unit = {},
    viewModel: HomeViewModel = viewModel()
) {
    // Refresh data when the screen is shown
    LaunchedEffect(key1 = true) {
        viewModel.refreshData()
    }
    
    // Get observed state with safe defaults
    val caloriesState = viewModel.todayCalories.observeAsState()
    val waterIntakeState = viewModel.waterIntake.observeAsState()
    val userProfileState = viewModel.userProfile.observeAsState()
    
    // Set safe values regardless of null
    val calories = caloriesState.value ?: 0
    val waterIntake = waterIntakeState.value ?: 0f
    val profile = userProfileState.value ?: UserProfile(dailyCalorieGoal = 2000)
    val dailyGoal = profile.dailyCalorieGoal
    val caloriesRemaining = dailyGoal - calories
    
    // Calculate progress percentages
    val calorieProgress = min((calories.toFloat() / dailyGoal), 1f)
    val waterGoal = 2000f // Default 2L water goal (could be from user profile)
    val waterProgress = min((waterIntake / waterGoal), 1f)
    
    // Animated progress
    val animatedCalorieProgress = remember { Animatable(0f) }
    val animatedWaterProgress = remember { Animatable(0f) }
    
    // Start animations when values change
    LaunchedEffect(calorieProgress) {
        animatedCalorieProgress.animateTo(
            targetValue = calorieProgress,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
    }
    
    LaunchedEffect(waterProgress) {
        animatedWaterProgress.animateTo(
            targetValue = waterProgress,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Decorative top background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
        )
        
        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Welcome header
            Text(
                text = "Today's Progress",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
            )
            
            // Nutrition summary card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Daily Nutrition",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        
                        BadgedBox(
                            badge = {
                                Badge {
                                    Text("${(calorieProgress * 100).toInt()}%")
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalDining,
                                contentDescription = "Nutrition",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Calorie progress circle
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CalorieProgressCircle(
                            progress = animatedCalorieProgress.value,
                            calories = calories,
                            caloriesRemaining = caloriesRemaining,
                            dailyGoal = dailyGoal
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Quick add buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        QuickAddButton(
                            text = "Breakfast",
                            onClick = onLogMealClick
                        )
                        
                        QuickAddButton(
                            text = "Lunch",
                            onClick = onLogMealClick
                        )
                        
                        QuickAddButton(
                            text = "Dinner",
                            onClick = onLogMealClick
                        )
                        
                        QuickAddButton(
                            text = "Snack",
                            onClick = onLogMealClick
                        )
                    }
                }
            }
            
            // Water tracking card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Hydration",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        
                        BadgedBox(
                            badge = {
                                Badge {
                                    Text("${(waterProgress * 100).toInt()}%")
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.WaterDrop,
                                contentDescription = "Water",
                                tint = Color(0xFF2196F3) // Water blue
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Water progress indicator
                    WaterProgressIndicator(
                        progress = animatedWaterProgress.value,
                        waterIntake = waterIntake,
                        waterGoal = waterGoal
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Add water button
                    Button(
                        onClick = onLogDrinkClick,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2196F3) // Water blue
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add, 
                            contentDescription = "Add",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(text = "Add Water or Drink")
                    }
                }
            }
            
            // Activity card (placeholder for future expansion)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Activity",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        
                        Icon(
                            imageVector = Icons.Default.DirectionsRun,
                            contentDescription = "Activity",
                            tint = Color(0xFF4CAF50) // Activity green
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        ActivityMetric(
                            value = "0",
                            label = "Steps",
                            color = Color(0xFF4CAF50)
                        )
                        
                        ActivityMetric(
                            value = "0",
                            label = "Cal. Burned",
                            color = Color(0xFFFF9800)
                        )
                        
                        ActivityMetric(
                            value = "0",
                            label = "Minutes",
                            color = Color(0xFFE91E63)
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    OutlinedButton(
                        onClick = { /* Connect activity tracker */ },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFF4CAF50)
                        )
                    ) {
                        Text("Connect Activity Tracker")
                    }
                }
            }
            
            // Main action buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = onLogMealClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocalDining,
                        contentDescription = "Log Food",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = "Log Food")
                }
                
                Button(
                    onClick = onLogDrinkClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.WaterDrop,
                        contentDescription = "Log Drink",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = "Log Drink")
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun CalorieProgressCircle(
    progress: Float,
    calories: Int,
    caloriesRemaining: Int,
    dailyGoal: Int
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(200.dp)
    ) {
        // Background circle
        Canvas(modifier = Modifier.size(200.dp)) {
            drawArc(
                color = Color.LightGray.copy(alpha = 0.3f),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 16f, cap = StrokeCap.Round)
            )
            
            // Progress arc - color based on progress
            val progressColor = when {
                progress < 0.5f -> Color(0xFF4CAF50) // Green
                progress < 0.8f -> Color(0xFFFFC107) // Yellow
                progress < 1.0f -> Color(0xFFFF9800) // Orange
                else -> Color(0xFFF44336) // Red if over
            }
            
            drawArc(
                color = progressColor,
                startAngle = -90f,
                sweepAngle = 360f * progress,
                useCenter = false,
                style = Stroke(width = 16f, cap = StrokeCap.Round)
            )
        }
        
        // Calorie text
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = calories.toString(),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = "calories consumed",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = if (caloriesRemaining > 0) "$caloriesRemaining left" else "Goal reached!",
                style = MaterialTheme.typography.bodyLarge,
                color = if (caloriesRemaining > 0) 
                    MaterialTheme.colorScheme.primary 
                else 
                    Color(0xFF4CAF50),
                fontWeight = FontWeight.Medium
            )
            
            Text(
                text = "Daily Goal: $dailyGoal",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
fun WaterProgressIndicator(
    progress: Float,
    waterIntake: Float,
    waterGoal: Float
) {
    val waterColor = Color(0xFF2196F3)
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Water progress bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray.copy(alpha = 0.3f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                waterColor.copy(alpha = 0.7f),
                                waterColor
                            )
                        )
                    )
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Text summary
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${waterIntake.toInt()} ml",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = waterColor
            )
            
            Text(
                text = "Goal: ${waterGoal.toInt()} ml",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
fun QuickAddButton(
    text: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add $text",
                tint = MaterialTheme.colorScheme.primary
            )
        }
        
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun ActivityMetric(
    value: String,
    label: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = color
        )
        
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
} 