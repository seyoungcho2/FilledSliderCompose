package io.github.seyoungcho2.slider.model

sealed class SliderType {
    data class Discrete(val steps: Int) : SliderType()
    object Continuous : SliderType()
}
