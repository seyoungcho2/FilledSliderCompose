package io.github.seyoungcho2.slider.model

/**
 * [SliderType] makes slider progression to be [Discrete] or [Continuous]
 */
sealed class SliderType {
    /**
     * [Discrete] makes slider progression changes discretely.
     */
    data class Discrete(val steps: Int) : SliderType()

    /**
     * [Continuous] makes slider progression changes continuously.
     */
    object Continuous : SliderType()
}
