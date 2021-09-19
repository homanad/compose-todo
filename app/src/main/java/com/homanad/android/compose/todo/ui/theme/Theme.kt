package com.homanad.android.compose.todo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = MyColors(
    primary = Purple200,
    secondary = Teal200,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onSurface = Color.Black,
    error = Color.Red,
    isDark = false
)

private val LightColorPalette = MyColors(
    primary = Purple500,
    secondary = Teal200,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onSurface = Color.Black,
    error = Color.Red,
    isDark = true
)

@Composable
fun TodoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    ProvideMyColors(colors = colors) {
        MaterialTheme(
            colors = debugColors(darkTheme = darkTheme),
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

@Stable
class MyColors(
    primary: Color,
    secondary: Color,
    surface: Color,
    onPrimary: Color,
    onSecondary: Color,
    onSurface: Color,
    error: Color,
    isDark: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var error by mutableStateOf(error)
        private set
    var isDark by mutableStateOf(isDark)

    fun update(colors: MyColors) {
        primary = colors.primary
        secondary = colors.onSecondary
        surface = colors.surface
        onPrimary = colors.onPrimary
        onSecondary = colors.onSecondary
        onSurface = colors.onSurface
        error = colors.error
        isDark = colors.isDark
    }

    fun copy(): MyColors = MyColors(
        primary = primary,
        secondary = secondary,
        surface = surface,
        onPrimary = onPrimary,
        onSecondary = onSecondary,
        onSurface = onSurface,
        error = error,
        isDark = isDark
    )
}

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)

object MyTheme {
    val colors: MyColors
        @Composable
        get() = LocalColors.current
}

private val LocalColors = staticCompositionLocalOf<MyColors> {
    error("Not provided yet")
}

@Composable
fun ProvideMyColors(colors: MyColors, content: @Composable () -> Unit) {
    val myColors = remember { colors.copy() }

    myColors.update(colors)

    CompositionLocalProvider(LocalColors provides myColors, content = content)
}