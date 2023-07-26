package io.github.seyoungcho2.slider

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import io.github.seyoungcho2.slider.model.SliderOrientation

internal class SliderLengthCalculator(
    maxValue: Float,
    private val minValue: Float
) {
    private val valueLength = maxValue - minValue

    fun getCurrentRatio(currentValue: Float): Float {
        if(valueLength == 0f) return 1f
        val currentValueLength: Float = if (currentValue > minValue)
            currentValue - minValue
        else
            0f

        return currentValueLength / valueLength
    }

    fun calculateDragLength(ratio: Float): Float {
        return -valueLength * ratio
    }

    fun getTopLeft(sliderOrientation: SliderOrientation, canvasSize: Size, indicatorLength: Float) : Offset {
        return when(sliderOrientation) {
            is SliderOrientation.Vertical -> {
                Offset(x = 0f, y = canvasSize.height - indicatorLength * canvasSize.height)
            }
            is SliderOrientation.Horizontal -> {
                Offset(x = 0f, y = 0f)
            }
        }
    }

    fun getSize(sliderOrientation: SliderOrientation, canvasSize: Size, indicatorLength: Float) : Size {
        return when (sliderOrientation) {
            is SliderOrientation.Vertical   -> {
                Size(canvasSize.width, indicatorLength * canvasSize.height)
            }

            is SliderOrientation.Horizontal -> {
                Size(indicatorLength * canvasSize.width, canvasSize.height)
            }
        }
    }
}