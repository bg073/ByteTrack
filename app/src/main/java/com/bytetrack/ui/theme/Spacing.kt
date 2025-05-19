package com.bytetrack.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Spacing values for consistent UI spacing throughout the app
 */
@Immutable
data class Spacing(
    val default: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val extraLarge: Dp = 32.dp,
    val huge: Dp = 48.dp,
    val iconSpacing: Dp = 12.dp,
    val contentPadding: Dp = 16.dp,
    val screenPadding: Dp = 16.dp,
    val cardElevation: Dp = 4.dp,
    val cardCornerRadius: Dp = 12.dp,
    val profileImageSize: Dp = 120.dp,
    val dividerThickness: Dp = 1.dp
)

/**
 * CompositionLocal used to pass [Spacing] down the tree
 */
val LocalSpacing = staticCompositionLocalOf { Spacing() } 