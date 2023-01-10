package xyz.xfqlittlefan.byucp.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalDarkTheme = staticCompositionLocalOf { false }

@Composable
fun CommonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorScheme: ColorScheme = if (darkTheme) {
        darkColorScheme()
    } else {
        lightColorScheme()
    },
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalDarkTheme provides darkTheme) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}

@Composable
expect fun AppTheme(content: @Composable () -> Unit)