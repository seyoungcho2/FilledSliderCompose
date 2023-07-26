![Filled Slider Compose Banner](https://github.com/seyoungcho2/FilledSliderCompose/assets/59521473/95ea009b-4275-4d18-ac33-4c671fbc5b4c)

<br>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
</p>

# What's Filled Slider Compose
FilledSlider is a customizable slider component built with Jetpack Compose, featuring a visually appealing filled track. It offers smooth and precise control over various settings and can be easily integrated into your Android app or project. With options for different colors, orientations, and progression types, FilledSlider enhances the user experience and adds a touch of elegance to your user interface.
<br><br>
# Preview
<br><br>
<p align="center">
    <img src="https://github.com/seyoungcho2/FilledSliderCompose/assets/59521473/467eace9-c776-419d-a9ae-f3494c4d04ca" alt="animated" />
</p>


<br><br>
# Downloads
## Maven Central
[![Maven Central](https://img.shields.io/maven-central/v/io.github.seyoungcho2/filled-slider-compose.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.seyoungcho2/filled-slider-compose)<br>

<br>

# Getting Started
Add the mavenCentral() on project level(root level) build.gradle file:
```gradle
allprojects {
    repositories {
        mavenCentral()
    }
}
```

Add dependency on module level build.gradle file:
### build.gradle
```gradle
dependencies {
    implementation "io.github.seyoungcho2:filled-slider-compose:1.0.0"
}
```
If using build.gradle.kts
### build.gradle.kts
```kotlin
dependencies {
    implementation("io.github.seyoungcho2:filled-slider-compose:1.0.0")
}
```


# How to use
FilledSlider provides various parameters to customize.

```kotlin
@Composable
fun FilledSlider(
    modifier: Modifier,
    sliderShape: Shape = RoundedCornerShape(50),
    isEnabled: Boolean = true,
    sliderColor: SliderColor = SliderColor(),
    sliderOrientation: SliderOrientation = SliderOrientation.Vertical,
    sliderType: SliderType = SliderType.Continuous,
    dragSensitivity: Float = 1f,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    currentValue: Float,
    setCurrentValue: (Float) -> Unit
)
```

 * modifier: The [Modifier] to be applied to this Slider.
 * sliderShape: [Shape] applied to the Slider.
 * isEnabled: Change slider enabled state. If disabled color is set to
 * sliderColor: Colors applied to the Slider.
 * sliderOrientation: Orientation for Slider. Vertical or Horizontal.
 * sliderType: Continuous and Discrete types are supported.
 * dragSensitivity: Drag sensitivity for slider. If the value is 1, the slider moves only as much as it is dragged.
 * valueRange: Value range for slider
 * currentValue: Current value for the Slider. It's forced to be in the range of [maxValue] and [minValue].
 * setCurrentValue: Callback in which value should be updated

<br>

## sliderShape
<p align="center">
    <img src="https://github.com/seyoungcho2/FilledSliderCompose/assets/59521473/af064146-e7dc-41bf-b473-faa40cbb6b4c" alt="animated" />
</p>

<br>

#### Pass class which implements [Shape](https://foso.github.io/Jetpack-Compose-Playground/foundation/shape/) on Compose.

<br>

* RectangleShape
```kotlin
@Composable
fun RectangleShapeSlider() {
    var currentValue by remember { mutableStateOf(20f) }
    FilledSlider(
        modifier = Modifier.size(50.dp, 150.dp),
        sliderShape= RectangleShape,
        sliderColor = SliderColor(
            enabledTrackColor = Color(0xFFC6B8FF),
            enabledIndicationColor = Color(0xFF7D5FFF)
        ),
        currentValue = currentValue,
        sliderType = SliderType.Continuous,
        valueRange = 0f..100f,
        setCurrentValue = {
            currentValue = it
        }
    )
}
```

* RoundedCornerShape(50)
```kotlin
@Composable
fun RoundedCornerShapeSlider() {
    var currentValue by remember { mutableStateOf(20f) }
    FilledSlider(
        modifier = Modifier.size(50.dp, 150.dp),
        sliderShape= RoundedCornerShape(0),
        sliderColor = SliderColor(
            enabledTrackColor = Color(0xFFC6B8FF),
            enabledIndicationColor = Color(0xFF7D5FFF)
        ),
        currentValue = currentValue,
        sliderType = SliderType.Continuous,
        valueRange = 0f..100f,
        setCurrentValue = {
            currentValue = it
        }
    )
}
```

<br><br>

## sliderType
<p align="center">
    <img src="https://github.com/seyoungcho2/FilledSliderCompose/assets/59521473/13561959-d385-43c7-9a02-a5b5c9c72ffc" alt="animated" />
</p>

<br>
#### SliderType makes slider progression to be Discrete or Continuous.
<br>

* SliderType.Continuous : SliderType.Continuous makes slider progression changes continuously.
```kotlin
@Composable
fun ContinuousSlider() {
    var currentValue by remember { mutableStateOf(20f) }
    FilledSlider(
        modifier = Modifier.size(50.dp, 150.dp),
        sliderColor = SliderColor(
            enabledTrackColor = Color(0xFFC6B8FF),
            enabledIndicationColor = Color(0xFF7D5FFF)
        ),
        currentValue = currentValue,
        sliderType = SliderType.Continuous,
        valueRange = 0f..100f,
        setCurrentValue = {
            currentValue = it
        }
    )
}
```

* SliderType.Discrete : SliderType.Discrete makes slider progression changes discretely.
```kotlin
@Composable
fun DiscreteSlider() {
    var currentValue by remember { mutableStateOf(20f) }
    FilledSlider(
        modifier = Modifier.size(50.dp, 150.dp),
        sliderColor = SliderColor(
            enabledTrackColor = Color(0xFFC6B8FF),
            enabledIndicationColor = Color(0xFF7D5FFF)
        ),
        currentValue = currentValue,
        sliderType = SliderType.Discrete(5),
        valueRange = 0f..100f,
        setCurrentValue = {
            currentValue = it
        }
    )
}
```
<br><br>
  
## sliderOrientation
<p align="center">
    <img src="https://github.com/seyoungcho2/FilledSliderCompose/assets/59521473/a198f1e3-1377-4434-8370-1ad649569556" alt="animated" />
</p>

<br>
#### SliderOrientation is responsible for controlling the dragging behavior of the slider component.
<br>

* SliderOrientation.Horizontal: SliderOrientation.Horizontal makes slider progression to be changed by dragging right or left along the x-axis.

```kotlin
@Composable
fun HorizontalSlider() {
    var currentValue by remember { mutableStateOf(20f) }
    FilledSlider(
        modifier = Modifier.size(150.dp, 50.dp).align(Alignment.Center),
        sliderColor = SliderColor(
            enabledTrackColor = Color(0xFFC6B8FF),
            enabledIndicationColor = Color(0xFF7D5FFF)
        ),
        sliderOrientation = SliderOrientation.Horizontal,
        currentValue = currentValue,
        valueRange = 0f..100f,
        setCurrentValue = {
            currentValue = it
        }
    )
}
```

* SliderOrientation.Vertical: SliderOrientation.Vertical makes slider progression to be changed by dragging up or down along the y-axis.
```kotlin
@Composable
fun VerticalSlider() {
    var currentValue by remember { mutableStateOf(20f) }
    FilledSlider(
        modifier = Modifier.size(50.dp, 150.dp),
        sliderShape= RoundedCornerShape(50),
        sliderColor = SliderColor(
            enabledTrackColor = Color(0xFFC6B8FF),
            enabledIndicationColor = Color(0xFF7D5FFF)
        ),
        sliderOrientation = SliderOrientation.Vertical,
        currentValue = currentValue,
        valueRange = 0f..100f,
        setCurrentValue = {
            currentValue = it
        }
    )
}
```

## dragSensitivity
<p align="center">
    <img src="https://github.com/seyoungcho2/FilledSliderCompose/assets/59521473/551e529a-79bc-458a-8d88-95145f07a8e5" alt="animated" />
</p>

#### Sensitivity for drag. Default is set to 1 which means indication changes as dragged amount.

```kotlin
@Composable
fun DragSensitivity2Slider() {
    var currentValue by remember { mutableStateOf(20f) }
    FilledSlider(
        modifier = Modifier.size(50.dp, 150.dp),
        sliderColor = SliderColor(
            enabledTrackColor = Color(0xFFC6B8FF),
            enabledIndicationColor = Color(0xFF7D5FFF)
        ),
        currentValue = currentValue,
        dragSensitivity = 1f,
        valueRange = 0f..100f,
        setCurrentValue = {
            currentValue = it
        }
    )
}
```


