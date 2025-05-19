package com.bytetrack.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Professional modern color scheme with fitness theme
private val LightColors = lightColorScheme(
    primary = Color(0xFF4285F4),      // Google Blue
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD7E3FF),
    onPrimaryContainer = Color(0xFF001C3C),
    
    secondary = Color(0xFF66BB6A),    // Fitness Green
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFB7DFBA),
    onSecondaryContainer = Color(0xFF002204),
    
    tertiary = Color(0xFF2196F3),     // Water Blue
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFCBE6FF),
    onTertiaryContainer = Color(0xFF001D31),
    
    background = Color(0xFFF8F9FA),
    onBackground = Color(0xFF1D1B20),
    surface = Color.White,
    onSurface = Color(0xFF1D1B20),
    
    error = Color(0xFFE53935),        // Error Red
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
    
    outline = Color(0xFFBDBDBD),
    outlineVariant = Color(0xFFE0E0E0)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF99C1FF),      // Lighter Google Blue
    onPrimary = Color(0xFF003063),
    primaryContainer = Color(0xFF00468C),
    onPrimaryContainer = Color(0xFFD7E3FF),
    
    secondary = Color(0xFF9CD99E),    // Lighter Fitness Green
    onSecondary = Color(0xFF003911),
    secondaryContainer = Color(0xFF005319),
    onSecondaryContainer = Color(0xFFB7DFBA),
    
    tertiary = Color(0xFF90CAF9),     // Lighter Water Blue
    onTertiary = Color(0xFF00325A),
    tertiaryContainer = Color(0xFF004880),
    onTertiaryContainer = Color(0xFFCBE6FF),
    
    background = Color(0xFF1A1C1E),
    onBackground = Color(0xFFE3E2E6),
    surface = Color(0xFF121212),
    onSurface = Color(0xFFE3E2E6),
    
    error = Color(0xFFFFB4AB),        // Lighter Error Red
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    
    outline = Color(0xFF757575),
    outlineVariant = Color(0xFF424242)
)

@Composable
fun ByteTrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }
    
    val spacing = Spacing()
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // Provide spacing to entire app via CompositionLocalProvider
    CompositionLocalProvider(
        LocalSpacing provides spacing
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

/**
 * Retrieve spacing values from the current theme
 */
object ByteTrackTheme {
    val spacing: Spacing
        @Composable
        get() = LocalSpacing.current
} 