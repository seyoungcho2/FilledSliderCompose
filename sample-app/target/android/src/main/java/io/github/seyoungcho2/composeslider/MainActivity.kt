package io.github.seyoungcho2.composeslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import io.github.seyoungcho2.composeslider.sample.DragSensitivitySample
import io.github.seyoungcho2.composeslider.sample.SliderOrientationSample
import io.github.seyoungcho2.composeslider.sample.SliderShapeSample
import io.github.seyoungcho2.composeslider.sample.SliderTypeSample
import io.github.seyoungcho2.composeslider.ui.theme.ComposeSliderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSliderTheme {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    SliderShapeSample()
                    SliderOrientationSample()
                    SliderTypeSample()
                    DragSensitivitySample()
                }
            }
        }
    }
}


