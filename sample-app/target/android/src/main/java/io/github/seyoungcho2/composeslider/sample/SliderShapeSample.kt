package io.github.seyoungcho2.composeslider.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import io.github.seyoungcho2.composeslider.ui.compose.CardRow
import io.github.seyoungcho2.composeslider.ui.compose.ItemWithTitle
import io.github.seyoungcho2.composeslider.ui.compose.TitleItem
import io.github.seyoungcho2.slider.FilledSlider
import io.github.seyoungcho2.slider.model.SliderColor
import io.github.seyoungcho2.slider.model.SliderType

@Composable
fun SliderShapeSample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        TitleItem(title = "sliderShape")
        Spacer(modifier = Modifier.height(8.dp))
        CardRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            var currentValue by remember { mutableStateOf(20f) }
            ItemWithTitle(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp), title = "RectangleShape"
            ) {
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
            Spacer(modifier = Modifier.width(4.dp))
            ItemWithTitle(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp), title = "RoundedCornerShape(50)"
            ) {
                FilledSlider(
                    modifier = Modifier.size(50.dp, 150.dp),
                    sliderShape= RoundedCornerShape(50),
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
        }
    }
}

@Composable
fun RoundedCornerShapeSlider() {
    var currentValue by remember { mutableStateOf(20f) }
    FilledSlider(
        modifier = Modifier.size(50.dp, 150.dp),
        sliderShape= RoundedCornerShape(50),
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