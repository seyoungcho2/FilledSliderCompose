package io.github.seyoungcho2.slider.continuous

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.input.pointer.pointerInput
import io.github.seyoungcho2.slider.model.SliderColor
import io.github.seyoungcho2.slider.SliderLengthCalculator
import io.github.seyoungcho2.slider.model.SliderOrientation

@Composable
internal fun ContinuousSlider(
    modifier: Modifier,
    sliderShape: Shape,
    isEnabled: Boolean,
    sliderColor: SliderColor,
    sliderOrientation: SliderOrientation,
    dragSensitivity: Float,
    sliderLengthCalculator: SliderLengthCalculator,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    currentValue: Float,
    setCurrentValue: (Float) -> Unit
) {
    val currentValueUpdated by rememberUpdatedState(
        newValue = when {
            currentValue < valueRange.start        -> valueRange.start
            currentValue > valueRange.endInclusive -> valueRange.endInclusive
            else                                   -> currentValue
        }
    )
    Canvas(
        modifier = modifier
            .clip(sliderShape)
            .pointerInput(isEnabled) {
                if (!isEnabled) return@pointerInput
                detectDragGestures { _, dragAmount ->
                    val draggedValue = when (sliderOrientation) {
                        is SliderOrientation.Vertical   -> sliderLengthCalculator.calculateDragLength(dragAmount.y / size.height)
                        is SliderOrientation.Horizontal -> sliderLengthCalculator.calculateDragLength(-dragAmount.x / size.width)
                    }
                    val newValue = currentValueUpdated + draggedValue * dragSensitivity
                    setCurrentValue(newValue)
                }
            },
        onDraw = {
            drawRect(
                color = sliderColor.getTrackColor(isEnabled),
                topLeft = Offset.Zero,
                size = size,
                style = Fill
            )

            val indicatorRatio = sliderLengthCalculator.getCurrentRatio(currentValue)

            drawRect(
                color = sliderColor.getIndicationColor(isEnabled),
                topLeft = sliderLengthCalculator.getTopLeft(sliderOrientation, size, indicatorRatio),
                size = sliderLengthCalculator.getSize(sliderOrientation, size, indicatorRatio),
                style = Fill
            )
        }
    )
}