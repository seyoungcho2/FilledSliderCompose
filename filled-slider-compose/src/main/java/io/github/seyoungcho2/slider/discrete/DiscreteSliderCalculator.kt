package io.github.seyoungcho2.slider.discrete

class DiscreteSliderCalculator(
    maxValue: Float,
    minValue: Float,
    steps: Int
) {
    private val valueLength = maxValue - minValue

    private val avoidDecimalMisMatchValue = valueLength / 10000f

    private val numSections = steps - 1
    private val sectionLength = valueLength / numSections

    fun getSectionCount(length: Float): Int {
        return ((length + avoidDecimalMisMatchValue) / sectionLength).toInt()
    }

    fun getSectionLength(sectionCount: Int): Float {
        return sectionLength * sectionCount
    }

    fun calculateCurrentSectionLength(length: Float): Float {
        val sections = getSectionCount(length)
        return getSectionLength(sections)
    }
}