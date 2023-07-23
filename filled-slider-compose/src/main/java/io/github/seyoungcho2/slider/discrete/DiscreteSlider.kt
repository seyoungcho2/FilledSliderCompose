package io.github.seyoungcho2.slider.discrete

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.input.pointer.pointerInput
import io.github.seyoungcho2.slider.SliderLengthCalculator
import io.github.seyoungcho2.slider.model.SliderColor
import io.github.seyoungcho2.slider.model.SliderOrientation

@Composable
internal fun DiscreteSlider(
    modifier: Modifier,
    sliderShape: Shape,
    sliderColor: SliderColor,
    sliderOrientation: SliderOrientation,
    dragSensitivity: Float,
    sliderLengthCalculator: SliderLengthCalculator,
    discreteSliderCalculator: DiscreteSliderCalculator,
    maxValue: Float,
    minValue: Float,
    currentValue: Float,
    setCurrentValue: (Float) -> Unit
) {
    val currentValueUpdated by rememberUpdatedState(
        newValue = when {
            currentValue < minValue -> minValue
            currentValue > maxValue -> maxValue
            else                    -> currentValue
        }
    )
    var tmpDraggedValue by remember { mutableStateOf(0f) }
    Canvas(
        modifier = modifier
            .clip(sliderShape)
            .pointerInput(true) {
                detectDragGestures(
                    onDragStart = {
                        tmpDraggedValue = 0f
                    },
                    onDragEnd = {
                        tmpDraggedValue = 0f
                    }
                ) { _, dragAmount ->
                    val draggedValue = when (sliderOrientation) {
                        is SliderOrientation.Vertical -> sliderLengthCalculator.calculateDragLength(dragAmount.y / size.height)
                        is SliderOrientation.Horizontal -> sliderLengthCalculator.calculateDragLength(-dragAmount.x / size.width)
                    }
                    tmpDraggedValue += draggedValue * dragSensitivity
                    val sectionCount = discreteSliderCalculator.getSectionCount(tmpDraggedValue)
                    if (sectionCount != 0) {
                        val addLength = discreteSliderCalculator.getSectionLength(sectionCount)
                        setCurrentValue(currentValueUpdated + addLength)
                        tmpDraggedValue -= addLength
                    }
                }
            },
        onDraw = {
            drawRect(
                color = sliderColor.trackColor,
                topLeft = Offset.Zero,
                size = size,
                style = Fill
            )

            val indicatorRatio = sliderLengthCalculator.getCurrentRatio(currentValue)

            drawRect(
                color = Color.Blue,
                topLeft = sliderLengthCalculator.getTopLeft(sliderOrientation, size, indicatorRatio),
                size = sliderLengthCalculator.getSize(sliderOrientation, size, indicatorRatio),
                style = Fill
            )
        }
    )
}