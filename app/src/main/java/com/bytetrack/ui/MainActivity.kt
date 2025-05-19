package com.bytetrack.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bytetrack.ByteTrackApplication
import com.bytetrack.R
import com.bytetrack.ui.components.ErrorBanner
import com.bytetrack.ui.components.NetworkStatusIndicator
import com.bytetrack.ui.model.BottomNavItem
import com.bytetrack.ui.navigation.AppNavigation
import com.bytetrack.ui.navigation.AppRoute
import com.bytetrack.ui.screens.home.HomeScreen
import com.bytetrack.ui.screens.profile.ProfileScreen
import com.bytetrack.ui.screens.stats.StatsScreen
import com.bytetrack.ui.screens.logfood.LogFoodScreen
import com.bytetrack.ui.theme.AnimationDuration
import com.bytetrack.ui.theme.ByteTrackTheme
import com.bytetrack.ui.theme.StandardEasing
import com.bytetrack.utils.NetworkStatus
import com.bytetrack.utils.connectivityState

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            val networkStatus by connectivityState()
            var errorMessage by remember { mutableStateOf<String?>(null) }
            
            ByteTrackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        // Network status indicator with higher z-index to stay on top
                        Box(
                            modifier = Modifier.zIndex(10f)
                        ) {
                            NetworkStatusIndicator(networkStatus = networkStatus)
                        }
                        
                        // Error banner shown when error message is not null
                        if (!errorMessage.isNullOrEmpty()) {
                            ErrorBanner(
                                errorMessage = errorMessage!!,
                                onDismiss = { errorMessage = null }
                            )
                        }
                        
                        // Main app content
                        AppContent(
                            modifier = Modifier.weight(1f),
                            onLogMealClick = { 
                                startActivity(Intent(this@MainActivity, LogFoodActivity::class.java))
                            },
                            onLogDrinkClick = {
                                startActivity(Intent(this@MainActivity, DrinkLogActivity::class.java))
                            },
                            onError = { message ->
                                errorMessage = message
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AppContent(
    modifier: Modifier = Modifier,
    onLogMealClick: () -> Unit = {},
    onLogDrinkClick: () -> Unit = {},
    onError: (String) -> Unit = {}
) {
    val navController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavItem(icon = Icons.Default.Home, text = stringResource(R.string.nav_home)),
        BottomNavItem(icon = Icons.Default.Add, text = stringResource(R.string.nav_log)),
        BottomNavItem(icon = Icons.Default.BarChart, text = stringResource(R.string.nav_stats)),
        BottomNavItem(icon = Icons.Default.Person, text = stringResource(R.string.nav_profile))
    )
    
    // Get current backstack entry to determine current destination
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    // Map destination routes to tab indices
    val currentTabIndex = when (currentDestination?.route) {
        AppRoute.Home.route -> 0
        AppRoute.Stats.route -> 2
        AppRoute.Profile.route -> 3
        else -> 0
    }
    
    // State for bottom bar animation
    var bottomBarVisible by remember { mutableIntStateOf(1) }
    
    // Store the previous tab index for comparison
    var previousTabIndex by remember { mutableIntStateOf(currentTabIndex) }
    
    // Update bottom bar animation based on current destination
    LaunchedEffect(currentDestination?.route) {
        // Always show bottom bar for main tabs
        bottomBarVisible = 1
    }
    
    Scaffold(
        modifier = modifier,
        bottomBar = {
            AnimatedVisibility(
                visible = bottomBarVisible == 1,
                enter = fadeIn(
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
                )
            ) {
                NavigationBar(
                    modifier = Modifier.navigationBarsPadding(),
                    tonalElevation = 8.dp
                ) {
                    bottomNavItems.forEachIndexed { index, item ->
                        val selected = index == currentTabIndex
                        
                        // For Add button (+) in the middle, always highlight when selected
                        val isAddButton = index == 1
                        
                        NavigationBarItem(
                            selected = selected,
                            onClick = { 
                                if (index == currentTabIndex) {
                                    // Already on this tab - do nothing
                                    return@NavigationBarItem
                                }
                                
                                previousTabIndex = currentTabIndex
                                
                                when (index) {
                                    0 -> navController.navigate(AppRoute.Home.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                    1 -> {
                                        // Add button - launch food logging
                                        onLogMealClick()
                                    }
                                    2 -> navController.navigate(AppRoute.Stats.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                    3 -> navController.navigate(AppRoute.Profile.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            icon = { 
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.text,
                                    modifier = Modifier.graphicsLayer {
                                        // Apply scale animation to icons for better feedback
                                        val scale = if (selected) 1.2f else 1.0f
                                        scaleX = scale
                                        scaleY = scale
                                    }
                                )
                            },
                            label = { 
                                Text(
                                    text = item.text,
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        // Use our new navigation component with animations
        AppNavigation(
            navController = navController,
            modifier = Modifier.padding(paddingValues),
            onLogMealClick = onLogMealClick,
            onLogDrinkClick = onLogDrinkClick,
            onError = onError
        )
    }
}

sealed class Screen(val route: String, val resourceId: Int, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    object Home : Screen("home", R.string.nav_home, Icons.Filled.Home)
    object LogFood : Screen("log_food", R.string.nav_log, Icons.Filled.Add)
    object Stats : Screen("stats", R.string.nav_stats, Icons.Filled.BarChart)
    object Profile : Screen("profile", R.string.nav_profile, Icons.Filled.AccountCircle)
} 