package com.example.sundmadinepal

import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.example.lec07_jetpackcompose.ui.theme.Purple200
import com.example.lec07_jetpackcompose.ui.theme.Purple700
import com.example.lec07_jetpackcompose.ui.theme.Teal200


private val DarkcolorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
)





@Composable
fun RecipeTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit){
val colors = DarkcolorPalette


}