package io.github.seyoungcho2.slider.model

sealed class SliderOrientation {
    object Vertical : SliderOrientation()
    object Horizontal: SliderOrientation()
}
