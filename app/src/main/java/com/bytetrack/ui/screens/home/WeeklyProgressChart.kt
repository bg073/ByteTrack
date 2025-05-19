package com.bytetrack.ui.screens.home

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bytetrack.ui.theme.AnimationDuration
import com.bytetrack.ui.theme.StandardEasing
import com.bytetrack.ui.viewmodels.HomeViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun WeeklyProgressChart(
    weeklyData: List<HomeViewModel.DailyProgress>,
    modifier: Modifier = Modifier
) {
    // Max values for scaling the chart
    val maxCalories = weeklyData.maxOfOrNull { it.calories } ?: 2000
    val targetCalories = weeklyData.firstOrNull()?.calories ?: 2000
    
    // Format dates for display
    val dayFormatter = SimpleDateFormat("EEE", Locale.getDefault())
    val formattedDays = weeklyData.map { dayFormatter.format(it.date) }
    
    // Animation for chart
    val animationProgress = remember { Animatable(0f) }
    LaunchedEffect(weeklyData) {
        animationProgress.snapTo(0f)
        animationProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = AnimationDuration.LONG,
                easing = StandardEasing
            )
        )
    }
    
    // Capture theme colors to use inside Canvas
    val primaryColor = MaterialTheme.colorScheme.primary
    val primaryColorAlpha = primaryColor.copy(alpha = 0.7f)
    val primaryColorAlpha2 = primaryColor.copy(alpha = 0.2f)
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Weekly Progress",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Draw the chart
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            // Draw the chart 
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .align(Alignment.BottomCenter)
            ) {
                val width = size.width
                val height = size.height
                val usableWidth = width - 40f
                
                // Calculate points for the path
                val points = weeklyData.mapIndexed { index, data ->
                    val x = 20f + (index * (usableWidth / (weeklyData.size - 1)))
                    val normalizedCalories = (data.calories.toFloat() / maxCalories)
                    val y = height - 20f - (normalizedCalories * (height - 40f)) * animationProgress.value
                    Offset(x, y)
                }
                
                // Draw connecting lines
                if (points.size >= 2) {
                    for (i in 0 until points.size - 1) {
                        drawLine(
                            color = primaryColor,
                            start = points[i],
                            end = points[i + 1],
                            strokeWidth = 5f,
                            cap = StrokeCap.Round
                        )
                    }
                }
                
                // Draw dots for each data point
                points.forEachIndexed { index, offset ->
                    val isToday = index == points.lastIndex
                    val dotColor = if (isToday) {
                        primaryColor
                    } else {
                        primaryColorAlpha
                    }
                    
                    // Draw points with larger dot for today
                    drawCircle(
                        color = dotColor,
                        center = offset,
                        radius = if (isToday) 8f else 6f
                    )
                    
                    // Draw white inner circle for a ring effect
                    drawCircle(
                        color = Color.White,
                        center = offset,
                        radius = if (isToday) 4f else 3f
                    )
                }
                
                // Optional: Add a gradient under the chart
                if (points.size >= 2) {
                    val fillPath = Path().apply {
                        moveTo(points.first().x, height)
                        lineTo(points.first().x, points.first().y)
                        
                        // Add all points
                        for (i in 1 until points.size) {
                            lineTo(points[i].x, points[i].y)
                        }
                        
                        // Complete the path back to the bottom
                        lineTo(points.last().x, height)
                        close()
                    }
                    
                    drawPath(
                        path = fillPath,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                primaryColorAlpha2,
                                Color.Transparent
                            ),
                            startY = 0f,
                            endY = height
                        )
                    )
                }
            }
            
            // X-axis labels
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                formattedDays.forEach { day ->
                    Text(
                        text = day,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall,
                        color = onSurfaceColor
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Trend summary
        val weeklyAvg = weeklyData.map { it.calories }.average().toInt()
        val todayCalories = weeklyData.lastOrNull()?.calories ?: 0
        val trend = todayCalories - weeklyAvg
        val trendText = when {
            trend > 100 -> "Trending higher than your weekly average"
            trend < -100 -> "Trending lower than your weekly average"
            else -> "On track with your weekly average"
        }
        
        val trendColor = when {
            trend > 100 -> Color(0xFFF44336)  // Red for higher
            trend < -100 -> Color(0xFF4CAF50) // Green for lower
            else -> primaryColor  // Primary for on track
        }
        
        Text(
            text = trendText,
            style = MaterialTheme.typography.bodySmall,
            color = trendColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun DailySummaryPill(
    day: String,
    value: Int,
    color: Color,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                if (isSelected) color.copy(alpha = 0.15f)
                else MaterialTheme.colorScheme.surface
            )
            .padding(horizontal = 12.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = day,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Text(
                text = value.toString(),
                fontSize = 14.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) color else MaterialTheme.colorScheme.onSurface
            )
        }
    }
} 