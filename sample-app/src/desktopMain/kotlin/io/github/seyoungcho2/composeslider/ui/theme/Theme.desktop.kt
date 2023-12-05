package io.github.seyoungcho2.composeslider.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable


@Composable
actual fun getAppThemeColor(
    darkTheme: Boolean,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean
): ColorScheme = when {
    darkTheme                                                      -> DarkColorScheme
    else                                                           -> LightColorScheme
}
