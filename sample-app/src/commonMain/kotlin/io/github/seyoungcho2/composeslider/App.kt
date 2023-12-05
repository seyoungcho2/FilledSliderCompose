package io.github.seyoungcho2.composeslider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.seyoungcho2.composeslider.sample.DragSensitivitySample
import io.github.seyoungcho2.composeslider.sample.SliderOrientationSample
import io.github.seyoungcho2.composeslider.sample.SliderShapeSample
import io.github.seyoungcho2.composeslider.sample.SliderTypeSample
import io.github.seyoungcho2.composeslider.ui.theme.ComposeSliderTheme


@Composable
fun App() {
    ComposeSliderTheme {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SliderShapeSample()
            SliderOrientationSample()
            SliderTypeSample()
            DragSensitivitySample()
        }
    }
}
