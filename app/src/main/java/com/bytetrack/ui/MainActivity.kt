package com.bytetrack.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bytetrack.R
import com.bytetrack.ui.model.BottomNavItem
import com.bytetrack.ui.screens.home.HomeScreen
import com.bytetrack.ui.screens.profile.ProfileScreen
import com.bytetrack.ui.screens.stats.StatsScreen
import com.bytetrack.ui.screens.logfood.LogFoodScreen
import com.bytetrack.ui.theme.ByteTrackTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            ByteTrackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent(
                        onLogMealClick = { 
                            navToLogFood()
                        },
                        onLogDrinkClick = {
                            startActivity(Intent(this, DrinkLogActivity::class.java))
                        }
                    )
                }
            }
        }
    }
    
    private fun navToLogFood() {
        val intent = Intent(this, LogFoodActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun AppContent(
    onLogMealClick: () -> Unit = {},
    onLogDrinkClick: () -> Unit = {}
) {
    val navController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavItem(icon = Icons.Default.Home, text = stringResource(R.string.nav_home)),
        BottomNavItem(icon = Icons.Default.Add, text = stringResource(R.string.nav_log)),
        BottomNavItem(icon = Icons.Default.BarChart, text = stringResource(R.string.nav_stats)),
        BottomNavItem(icon = Icons.Default.Person, text = stringResource(R.string.nav_profile))
    )
    
    var selectedItemIndex by remember { mutableIntStateOf(0) }
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = { 
                            selectedItemIndex = index 
                            when (index) {
                                0 -> navController.navigate("home") { popUpTo("home") { inclusive = true } }
                                1 -> {
                                    if (selectedItemIndex != 1) {
                                        onLogMealClick() 
                                    }
                                    selectedItemIndex = 0
                                }
                                2 -> navController.navigate("stats") { popUpTo("home") }
                                3 -> navController.navigate("profile") { popUpTo("home") }
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.text) },
                        label = { Text(item.text) }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                HomeScreen(
                    onLogMealClick = onLogMealClick,
                    onLogDrinkClick = onLogDrinkClick
                )
            }
            composable("stats") {
                StatsScreen()
            }
            composable("profile") {
                ProfileScreen()
            }
        }
    }
}

sealed class Screen(val route: String, val resourceId: Int, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    object Home : Screen("home", R.string.nav_home, Icons.Filled.Home)
    object LogFood : Screen("log_food", R.string.nav_log, Icons.Filled.Add)
    object Stats : Screen("stats", R.string.nav_stats, Icons.Filled.BarChart)
    object Profile : Screen("profile", R.string.nav_profile, Icons.Filled.AccountCircle)
} 