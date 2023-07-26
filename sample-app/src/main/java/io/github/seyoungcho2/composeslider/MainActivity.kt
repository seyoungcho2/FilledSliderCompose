package io.github.seyoungcho2.composeslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.seyoungcho2.composeslider.ui.theme.ComposeSliderTheme
import io.github.seyoungcho2.slider.model.SliderColor
import io.github.seyoungcho2.slider.FilledSlider
import io.github.seyoungcho2.slider.model.SliderType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSliderTheme {
                Row(modifier = Modifier.fillMaxSize()) {
                    var currentValue by remember { mutableStateOf(0.2f) }
                    FilledSlider(
                        modifier = Modifier.size(100.dp, 300.dp),
                        sliderColor = SliderColor(),
                        currentValue = currentValue,
                        sliderType = SliderType.Discrete(10),
                        valueRange = 0f..100f,
                        setCurrentValue = {
                            currentValue = it
                            println("currentValue >> ${currentValue}")
                        }
                    )
                }
            }
        }
    }
}

