package com.bytetrack.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bytetrack.R
import com.bytetrack.data.model.UserProfile
import com.bytetrack.ui.viewmodels.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel()
) {
    val userProfile by viewModel.userProfile.observeAsState(UserProfile())
    
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var calorieGoal by remember { mutableStateOf("") }
    var isDarkTheme by remember { mutableStateOf(false) }
    
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
        Text(
            text = stringResource(id = R.string.nav_profile),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
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
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { /* TODO: Implement connecting to fitness apps */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.connect_apps))
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        ThemeToggle(
            isDarkTheme = isDarkTheme,
            onThemeChange = { isChecked ->
                isDarkTheme = isChecked
                val theme = if (isChecked) "dark" else "light"
                viewModel.updateTheme(theme)
            }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { /* TODO: Implement premium subscription */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.premium))
        }
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun ThemeToggle(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.dark_mode),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        
        Switch(
            checked = isDarkTheme,
            onCheckedChange = onThemeChange
        )
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
    val updatedProfile = currentProfile.copy(
        name = name,
        age = age.toIntOrNull() ?: 0,
        height = height.toFloatOrNull() ?: 0f,
        weight = weight.toFloatOrNull() ?: 0f,
        dailyCalorieGoal = calorieGoal.toIntOrNull() ?: 2000
    )
    viewModel.updateUserProfile(updatedProfile)
} 