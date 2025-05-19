package com.bytetrack.ui.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bytetrack.ui.theme.AnimationDuration
import com.bytetrack.ui.theme.StandardEasing
import com.bytetrack.ui.viewmodels.HomeViewModel

@Composable
fun QuickAddPanel(
    quickAddItems: List<HomeViewModel.QuickAddItem>,
    onAddItem: (HomeViewModel.QuickAddItem) -> Unit,
    onAddCustomFood: () -> Unit,
    onAddCustomDrink: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(
            durationMillis = AnimationDuration.SHORT,
            easing = StandardEasing
        ),
        label = "dropdownRotation"
    )
    
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Header with toggle
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Quick Add",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.weight(1f))
                
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = if (expanded) "Collapse" else "Expand",
                    modifier = Modifier.rotate(rotationState)
                )
            }
            
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn(
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                ) + expandVertically(
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                ),
                exit = fadeOut(
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                ) + shrinkVertically(
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    // Recently used items
                    Text(
                        text = "Recently Added",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                    
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    ) {
                        items(quickAddItems) { item ->
                            QuickAddItem(
                                name = item.name,
                                calories = item.calories,
                                type = item.type,
                                onClick = { onAddItem(item) }
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Custom food/drink buttons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        TextButton(
                            onClick = onAddCustomFood,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.RestaurantMenu,
                                contentDescription = "Add Food",
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Text("Add Food")
                        }
                        
                        TextButton(
                            onClick = onAddCustomDrink,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalCafe,
                                contentDescription = "Add Drink",
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Text("Add Drink")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuickAddItem(
    name: String,
    calories: Int,
    type: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val icon: ImageVector
    val backgroundColor: Color
    
    when (type) {
        "food" -> {
            icon = Icons.Default.Fastfood
            backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
        }
        "drink" -> {
            icon = if (name.contains("Water", ignoreCase = true)) {
                Icons.Default.WaterDrop
            } else {
                Icons.Default.Coffee
            }
            backgroundColor = Color(0xFF2196F3).copy(alpha = 0.1f)
        }
        else -> {
            icon = Icons.Default.LocalDining
            backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
        }
    }
    
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .width(85.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Icon with background
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(backgroundColor)
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = name,
                tint = when (type) {
                    "food" -> MaterialTheme.colorScheme.primary
                    "drink" -> Color(0xFF2196F3)
                    else -> MaterialTheme.colorScheme.primary
                },
                modifier = Modifier.size(32.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Item name
        Text(
            text = name,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
        
        // Calories
        Text(
            text = "$calories cal",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
} 