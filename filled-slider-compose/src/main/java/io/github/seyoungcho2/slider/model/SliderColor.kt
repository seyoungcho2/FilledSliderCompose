package io.github.seyoungcho2.slider.model

import androidx.compose.ui.graphics.Color

/**
 * [enabledTrackColor]: Track color when the slider is enabled.
 * [disabledTrackColor]: Track color when the slider is disabled.
 * [enabledIndicationColor]: Indication color for progression when the slider is enabled
 * [disabledIndicationColor]: Indication color for progression when the slider is disabled.
 */
data class SliderColor(
    val enabledTrackColor: Color = Color.Gray,
    val disabledTrackColor: Color = enabledTrackColor,
    val enabledIndicationColor: Color = Color.Black,
    val disabledIndicationColor: Color = enabledIndicationColor
)
