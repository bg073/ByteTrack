package com.bytetrack.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.bytetrack.ui.screens.home.HomeScreen
import com.bytetrack.ui.screens.logfood.LogFoodScreen
import com.bytetrack.ui.screens.profile.ProfileScreen
import com.bytetrack.ui.screens.stats.StatsScreen
import com.bytetrack.ui.theme.AnimationDuration
import com.bytetrack.ui.theme.StandardEasing
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

/**
 * Main navigation routes for the app
 */
sealed class AppRoute(val route: String) {
    object Home : AppRoute("home")
    object Stats : AppRoute("stats")
    object Profile : AppRoute("profile")
}

/**
 * Main navigation component for the app with animated transitions between screens
 */
@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onLogMealClick: () -> Unit,
    onLogDrinkClick: () -> Unit,
    onError: (String) -> Unit = {}
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.Home.route,
        modifier = modifier
    ) {
        composable(
            route = AppRoute.Home.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            }
        ) {
            HomeScreen(
                onLogMealClick = onLogMealClick,
                onLogDrinkClick = onLogDrinkClick,
                onError = onError
            )
        }
        
        composable(
            route = AppRoute.Stats.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            }
        ) {
            StatsScreen(
                onError = onError
            )
        }
        
        composable(
            route = AppRoute.Profile.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(
                        durationMillis = AnimationDuration.MEDIUM,
                        easing = StandardEasing
                    )
                )
            }
        ) {
            ProfileScreen(
                onError = onError
            )
        }
    }
} 