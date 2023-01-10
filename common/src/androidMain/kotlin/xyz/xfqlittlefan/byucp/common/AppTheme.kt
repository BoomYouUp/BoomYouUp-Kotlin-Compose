package xyz.xfqlittlefan.byucp.common

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
actual fun AppTheme(content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = !darkTheme)
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        CommonTheme(
            darkTheme,
            colorScheme = if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context),
            content
        )
    } else {
        CommonTheme(content = content)
    }
}