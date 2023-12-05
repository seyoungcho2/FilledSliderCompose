package io.github.seyoungcho2.slider.model

/**
 * The [SliderOrientation] class is responsible for controlling the dragging behavior of the slider component.
 */
sealed class SliderOrientation {
    /**
     * [Vertical] makes slider progression to be changed by dragging up or down along the y-axis.
     */
    object Vertical : SliderOrientation()
    /**
     * [Horizontal] makes slider progression to be changed by dragging right or left along the x-axis.
     */
    object Horizontal: SliderOrientation()
}
