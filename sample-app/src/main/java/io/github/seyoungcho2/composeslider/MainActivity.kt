package io.github.seyoungcho2.composeslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
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
                // A surface container using the 'background' color from the theme
                Box() {
                    var currentValue by remember { mutableStateOf(-100f) }
                    FilledSlider(
                        modifier = Modifier.size(100.dp, 300.dp),
                        sliderColor = SliderColor(),
                        currentValue = currentValue,
                        sliderType = SliderType.Discrete(10),
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeSliderTheme {
        Greeting("Android")
    }
}