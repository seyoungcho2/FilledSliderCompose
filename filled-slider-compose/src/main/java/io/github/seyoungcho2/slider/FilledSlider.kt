package io.github.seyoungcho2.slider

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import io.github.seyoungcho2.slider.continuous.ContinuousSlider
import io.github.seyoungcho2.slider.discrete.DiscreteSlider
import io.github.seyoungcho2.slider.discrete.DiscreteSliderCalculator
import io.github.seyoungcho2.slider.model.SliderColor
import io.github.seyoungcho2.slider.model.SliderOrientation
import io.github.seyoungcho2.slider.model.SliderType

/**
 * [modifier]: The [Modifier] to be applied to this Slider.
 * [sliderShape]: [Shape] applied to the Slider.
 * [sliderColor]: Colors applied to the Slider.
 * [sliderOrientation]: Orientation for Slider. Vertical or Horizontal.
 * [sliderType]: Continuous and Discrete types are supported.
 * [dragSensitivity]: Drag sensitivity for slider. If the value is 1, the slider moves only as much as it is dragged.
 * [maxValue]: Max value for the Slider.
 * [minValue]: Min value for the Slider.
 * [currentValue]: Current value for the Slider. It's forced to be in the range of [maxValue] and [minValue].
 * [setCurrentValue]: Callback in which value should be updated
 */
@Composable
fun FilledSlider(
    modifier: Modifier,
    sliderShape: Shape = RoundedCornerShape(50),
    sliderColor: SliderColor = SliderColor(),
    sliderOrientation: SliderOrientation = SliderOrientation.Vertical,
    sliderType: SliderType = SliderType.Continuous,
    dragSensitivity: Float = 1f,
    maxValue: Float = 100f,
    minValue: Float = 0f,
    currentValue: Float,
    setCurrentValue: (Float) -> Unit
) {
    val sliderLengthCalculator by rememberUpdatedState(newValue = SliderLengthCalculator(maxValue, minValue))

    when (sliderType) {
        is SliderType.Continuous -> {
            ContinuousSlider(
                modifier = modifier,
                sliderShape = sliderShape,
                sliderColor = sliderColor,
                sliderOrientation = sliderOrientation,
                dragSensitivity = dragSensitivity,
                sliderLengthCalculator = sliderLengthCalculator,
                maxValue = maxValue,
                minValue = minValue,
                currentValue = currentValue,
                setCurrentValue = setCurrentValue
            )
        }

        is SliderType.Discrete   -> {
            val discreteSliderCalculator by rememberUpdatedState(
                newValue = DiscreteSliderCalculator(
                    maxValue,
                    minValue,
                    sliderType.steps
                )
            )
            DiscreteSlider(
                modifier = modifier,
                sliderShape = sliderShape,
                sliderColor = sliderColor,
                sliderOrientation = sliderOrientation,
                dragSensitivity = dragSensitivity,
                sliderLengthCalculator = sliderLengthCalculator,
                discreteSliderCalculator = discreteSliderCalculator,
                currentValue = discreteSliderCalculator.calculateCurrentSectionLength(currentValue),
                maxValue = maxValue,
                minValue = minValue,
                setCurrentValue = setCurrentValue
            )
        }
    }
}
