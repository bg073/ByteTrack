package com.bytetrack.ui.theme

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize

/**
 * Standard animations for ByteTrack app
 * These animations provide a consistent look and feel across all screens
 */

// Default animation durations
object AnimationDuration {
    const val SHORT = 150
    const val MEDIUM = 300
    const val LONG = 500
}

// Easing presets
val FastOutSlowInEasing: Easing = androidx.compose.animation.core.FastOutSlowInEasing
val EmphasizedEasing: Easing = CubicBezierEasing(0.2f, 0f, 0f, 1f)
val StandardEasing: Easing = CubicBezierEasing(0.4f, 0f, 0.2f, 1f)

/**
 * Standard entry animation for cards and content areas
 */
@OptIn(ExperimentalAnimationApi::class)
fun contentEnterTransition(
    duration: Int = AnimationDuration.MEDIUM,
    delay: Int = 0
): EnterTransition = fadeIn(
    animationSpec = tween(
        durationMillis = duration,
        delayMillis = delay,
        easing = StandardEasing
    )
) + expandIn(
    animationSpec = tween(
        durationMillis = duration,
        delayMillis = delay,
        easing = StandardEasing
    ),
    expandFrom = Alignment.Center
)

/**
 * Standard exit animation for cards and content areas
 */
@OptIn(ExperimentalAnimationApi::class)
fun contentExitTransition(
    duration: Int = AnimationDuration.MEDIUM
): ExitTransition = fadeOut(
    animationSpec = tween(
        durationMillis = duration,
        easing = StandardEasing
    )
) + shrinkOut(
    animationSpec = tween(
        durationMillis = duration,
        easing = StandardEasing
    ),
    shrinkTowards = Alignment.Center
)

/**
 * Animation for entering from the bottom (e.g. dialogs, bottom sheets)
 */
fun enterFromBottomTransition(
    duration: Int = AnimationDuration.MEDIUM
): EnterTransition = slideInVertically(
    animationSpec = tween(
        durationMillis = duration,
        easing = StandardEasing
    ),
    initialOffsetY = { it }
) + fadeIn(
    animationSpec = tween(
        durationMillis = duration,
        easing = StandardEasing
    )
)

/**
 * Animation for exiting to the bottom (e.g. dialogs, bottom sheets)
 */
fun exitToBottomTransition(
    duration: Int = AnimationDuration.MEDIUM
): ExitTransition = slideOutVertically(
    animationSpec = tween(
        durationMillis = duration,
        easing = StandardEasing
    ),
    targetOffsetY = { it }
) + fadeOut(
    animationSpec = tween(
        durationMillis = duration,
        easing = StandardEasing
    )
)

/**
 * Staggered animation for lists
 */
@Composable
fun staggeredAnimationSpec(
    index: Int,
    duration: Int = AnimationDuration.MEDIUM,
    baseDelay: Int = 50 // Delay between each item
): TweenSpec<Float> {
    return tween(
        durationMillis = duration,
        delayMillis = index * baseDelay,
        easing = StandardEasing
    )
}

/**
 * Button click animation
 */
fun buttonClickAnimationSpec(): SpringSpec<Float> {
    return spring(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessMedium
    )
}

/**
 * Pulse animation spec
 */
fun pulseAnimationSpec(): InfiniteRepeatableSpec<Float> {
    return infiniteRepeatable(
        animation = tween(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        ),
        repeatMode = RepeatMode.Reverse
    )
} 