package com.bytetrack.ui.screens.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bytetrack.R
import com.bytetrack.data.model.GoalHistory
import com.bytetrack.data.model.UserProfile
import com.bytetrack.ui.theme.AnimationDuration
import com.bytetrack.ui.theme.StandardEasing
import com.bytetrack.ui.viewmodels.ProfileViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel(),
    onError: (String) -> Unit = {}
) {
    val userProfile by viewModel.userProfile.observeAsState(UserProfile())
    val profilePictureUri by viewModel.profilePictureUri.observeAsState()
    val mealReminderEnabled by viewModel.mealReminderEnabled.observeAsState(false)
    val waterReminderEnabled by viewModel.waterReminderEnabled.observeAsState(false)
    val weeklyReportEnabled by viewModel.weeklyReportEnabled.observeAsState(false)
    val goalHistory by viewModel.goalHistory.observeAsState(emptyList())
    
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var calorieGoal by remember { mutableStateOf("") }
    var isDarkTheme by remember { mutableStateOf(false) }
    
    var showGoalHistory by remember { mutableStateOf(false) }
    
    // Update the state when userProfile changes
    val currentUserProfile = userProfile
    if (currentUserProfile != null) {
        name = currentUserProfile.name
        age = currentUserProfile.age.toString()
        height = currentUserProfile.height.toString()
        weight = currentUserProfile.weight.toString()
        calorieGoal = currentUserProfile.dailyCalorieGoal.toString()
        isDarkTheme = currentUserProfile.theme == "dark"
    }
    
    // Image picker launcher
    val context = LocalContext.current
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        viewModel.setProfilePicture(uri)
    }
    
    // Save profile on onPause
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                saveUserProfile(
                    viewModel,
                    userProfile,
                    name,
                    age,
                    height,
                    weight,
                    calorieGoal
                )
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Profile Header with Image
        ProfileHeader(
            name = name,
            profilePictureUri = profilePictureUri,
            onEditPictureClick = { imagePicker.launch("image/*") }
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Personal Information Section
        SectionHeader(title = "Personal Information")
        
        ProfileTextField(
            value = name,
            onValueChange = { name = it },
            label = "Name"
        )
        
        ProfileTextField(
            value = age,
            onValueChange = { age = it },
            label = "Age",
            keyboardType = KeyboardType.Number
        )
        
        ProfileTextField(
            value = height,
            onValueChange = { height = it },
            label = "Height (cm)",
            keyboardType = KeyboardType.Decimal
        )
        
        ProfileTextField(
            value = weight,
            onValueChange = { weight = it },
            label = "Weight (kg)",
            keyboardType = KeyboardType.Decimal
        )
        
        ProfileTextField(
            value = calorieGoal,
            onValueChange = { calorieGoal = it },
            label = "Daily Calorie Goal",
            keyboardType = KeyboardType.Number
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Notification Preferences Section
        SectionHeader(title = "Notification Preferences")
        
        NotificationToggle(
            title = "Meal Reminders",
            description = "Remind me to log my meals",
            checked = mealReminderEnabled,
            onCheckedChange = { viewModel.setMealReminderEnabled(it) }
        )
        
        NotificationToggle(
            title = "Water Reminders",
            description = "Remind me to stay hydrated",
            checked = waterReminderEnabled,
            onCheckedChange = { viewModel.setWaterReminderEnabled(it) }
        )
        
        NotificationToggle(
            title = "Weekly Reports",
            description = "Send me weekly nutrition reports",
            checked = weeklyReportEnabled,
            onCheckedChange = { viewModel.setWeeklyReportEnabled(it) }
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // App Preferences Section
        SectionHeader(title = "App Preferences")
        
        ThemeToggle(
            isDarkTheme = isDarkTheme,
            onThemeChange = { isChecked ->
                isDarkTheme = isChecked
                val theme = if (isChecked) "dark" else "light"
                viewModel.updateTheme(theme)
            }
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Goal History Section
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showGoalHistory = !showGoalHistory }
                .padding(vertical = 8.dp)
        ) {
            Icon(
                Icons.Default.History,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Text(
                text = "Goal History",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                if (showGoalHistory) Icons.Default.Check else Icons.Default.Add,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
        
        AnimatedVisibility(
            visible = showGoalHistory,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            GoalHistoryList(goalHistory = goalHistory)
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { /* TODO: Implement premium subscription */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.premium))
        }
    }
}

@Composable
fun ProfileHeader(
    name: String,
    profilePictureUri: Uri?,
    onEditPictureClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomEnd) {
                // Profile Picture
                if (profilePictureUri != null) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(profilePictureUri)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    )
                } else {
                    // Default profile picture
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer)
                            .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Default Profile",
                            modifier = Modifier.size(60.dp),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
                
                // Edit button
                FloatingActionButton(
                    onClick = onEditPictureClick,
                    modifier = Modifier.size(40.dp),
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Edit Profile Picture",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Username
            Text(
                text = if (name.isNotBlank()) name else "Add Your Name",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        Divider(
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
            thickness = 1.dp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun NotificationToggle(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
fun ThemeToggle(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(id = R.string.dark_mode),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Switch between light and dark theme",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Switch(
            checked = isDarkTheme,
            onCheckedChange = onThemeChange
        )
    }
}

@Composable
fun GoalHistoryList(goalHistory: List<GoalHistory>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        if (goalHistory.isEmpty()) {
            Text(
                text = "No goal history yet. Changes to your goals will appear here.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        } else {
            goalHistory.take(5).forEach { goal ->
                GoalHistoryItem(goal)
            }
            
            if (goalHistory.size > 5) {
                Text(
                    text = "View all ${goalHistory.size} goal changes",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .align(Alignment.End)
                        .clickable { /* TODO: Navigate to full history */ }
                )
            }
        }
    }
}

@Composable
fun GoalHistoryItem(goal: GoalHistory) {
    val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
    val formattedDate = remember(goal.date) { dateFormat.format(goal.date) }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = getGoalTypeDisplayName(goal.goalType),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "$formattedDate",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${goal.previousValue}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "Changed to",
                    modifier = Modifier.padding(horizontal = 4.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "${goal.newValue}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (goal.achieved) 
                        MaterialTheme.colorScheme.primary
                    else 
                        MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

fun getGoalTypeDisplayName(goalType: String): String {
    return when (goalType) {
        "CALORIE" -> "Calorie Goal"
        "WATER" -> "Water Goal"
        "PROTEIN" -> "Protein Goal"
        "CARBS" -> "Carbohydrate Goal"
        "FAT" -> "Fat Goal"
        else -> goalType
    }
}

private fun saveUserProfile(
    viewModel: ProfileViewModel,
    currentProfile: UserProfile,
    name: String,
    age: String,
    height: String,
    weight: String,
    calorieGoal: String
) {
    val newCalorieGoal = calorieGoal.toIntOrNull() ?: 2000
    
    // Check if the calorie goal has changed
    if (currentProfile.dailyCalorieGoal != newCalorieGoal) {
        viewModel.addGoalHistory(
            goalType = "CALORIE",
            previousValue = currentProfile.dailyCalorieGoal,
            newValue = newCalorieGoal
        )
    }
    
    val updatedProfile = currentProfile.copy(
        name = name,
        age = age.toIntOrNull() ?: 0,
        height = height.toFloatOrNull() ?: 0f,
        weight = weight.toFloatOrNull() ?: 0f,
        dailyCalorieGoal = newCalorieGoal
    )
    viewModel.updateUserProfile(updatedProfile)
} 