package com.bytetrack.ui.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.bytetrack.ui.theme.AnimationDuration
import com.bytetrack.ui.theme.StandardEasing
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun GoalSettingDialog(
    currentGoal: Int,
    onDismiss: () -> Unit,
    onSetGoal: (Int) -> Unit
) {
    var sliderPosition by remember { mutableFloatStateOf(currentGoal.toFloat()) }
    val calorieGoal by remember { derivedStateOf { sliderPosition.toInt() } }
    
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Set Your Daily Calorie Goal",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Calorie display
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = calorieGoal.toString(),
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        
                        Text(
                            text = "calories",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Slider for adjusting goal
                Text(
                    text = "Adjust your daily calorie goal",
                    style = MaterialTheme.typography.bodyMedium
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it },
                    valueRange = 1200f..3500f,
                    steps = 23,
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.primary,
                        activeTrackColor = MaterialTheme.colorScheme.primary,
                        inactiveTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                    )
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "1200",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                    
                    Text(
                        text = "3500",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Goal recommendations
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lightbulb,
                            contentDescription = "Tip",
                            tint = Color(0xFFFFC107)
                        )
                        
                        Text(
                            text = "For your height and activity level, we recommend around 2000 calories daily.",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Action buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Cancel")
                    }
                    
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    
                    Button(
                        onClick = {
                            onSetGoal(calorieGoal)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Save Goal")
                    }
                }
            }
        }
    }
}

@Composable
fun GoalRewardAnimation(
    show: Boolean,
    message: String = "Goal Reached!",
    onDismiss: () -> Unit
) {
    var showStars by remember { mutableStateOf(false) }
    
    // Trophy animation
    val trophyScale = remember { Animatable(0f) }
    val trophyRotation = remember { Animatable(0f) }
    
    // Delayed stars animation
    LaunchedEffect(show) {
        if (show) {
            // Animate trophy
            trophyScale.snapTo(0f)
            trophyRotation.snapTo(-10f)
            
            trophyScale.animateTo(
                targetValue = 1f,
                animationSpec = spring(
                    dampingRatio = 0.4f,
                    stiffness = 300f
                )
            )
            
            trophyRotation.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
            )
            
            // Show stars after trophy appears
            delay(300)
            showStars = true
            
            // Auto dismiss after some time
            delay(3000)
            onDismiss()
        } else {
            showStars = false
        }
    }
    
    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.95f)
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                // Background overlay
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black.copy(alpha = 0.7f),
                    shape = RoundedCornerShape(16.dp)
                ) {}
                
                // Content
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Trophy icon with animation
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = "Trophy",
                        tint = Color(0xFFFFD700), // Gold color
                        modifier = Modifier
                            .size(120.dp)
                            .scale(trophyScale.value)
                            .rotate(trophyRotation.value)
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Text(
                        text = message,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Keep up the great work!",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center
                    )
                    
                    Spacer(modifier = Modifier.height(32.dp))
                    
                    Button(
                        onClick = onDismiss,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Continue")
                    }
                }
                
                // Animated stars
                if (showStars) {
                    CelebrationStars()
                }
            }
        }
    }
}

@Composable
fun CelebrationStars() {
    // Create 20 animated stars
    repeat(20) { index ->
        val delay = index * 60L // Stagger star animations
        val startPositionX = Random.nextFloat() * 1f
        val startPositionY = Random.nextFloat() * 0.5f + 0.5f // Start in lower half
        
        val endPositionX = startPositionX + (Random.nextFloat() * 0.4f - 0.2f) // Random drift
        val endPositionY = startPositionY - Random.nextFloat() * 0.7f // Drift upward
        
        val rotation = remember { Animatable(0f) }
        val alpha = remember { Animatable(0f) }
        val scale = remember { Animatable(0f) }
        
        LaunchedEffect(Unit) {
            delay(delay)
            
            // Parallel animations
            rotation.animateTo(
                targetValue = 360f * (Random.nextFloat() * 3f),
                animationSpec = tween(
                    durationMillis = 1500 + (Random.nextInt(1000)),
                    easing = StandardEasing
                )
            )
            
            alpha.animateTo(
                targetValue = 0f,
                animationSpec = keyframes {
                    0f at 0
                    1f at 100
                    1f at 1200
                    0f at 2000
                }
            )
            
            scale.animateTo(
                targetValue = 0f,
                animationSpec = keyframes {
                    0f at 0
                    0.3f at 100
                    0.7f at 500
                    1f at 1000
                    0.5f at 1800
                    0f at 2000
                }
            )
        }
        
        // Star positioned randomly on screen
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(alpha.value)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color(0xFFFFD700).copy(alpha = alpha.value), // Gold
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(
                        start = (endPositionX * 320).dp,
                        top = (endPositionY * 500).dp
                    )
                    .size((20 + (index % 3) * 8).dp)
                    .rotate(rotation.value)
                    .scale(scale.value)
            )
        }
    }
} 