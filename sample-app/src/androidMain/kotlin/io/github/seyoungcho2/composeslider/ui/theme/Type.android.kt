package io.github.seyoungcho2.composeslider.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import io.github.seyoungcho2.composeslider.R


val robotoFontFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal, FontStyle.Normal)
)

actual fun getAppFontFamily(): FontFamily = robotoFontFamily
