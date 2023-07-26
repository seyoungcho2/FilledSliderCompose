package io.github.seyoungcho2.composeslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.seyoungcho2.composeslider.sample.DragSensitivitySample
import io.github.seyoungcho2.composeslider.sample.SliderOrientationSample
import io.github.seyoungcho2.composeslider.sample.SliderShapeSample
import io.github.seyoungcho2.composeslider.sample.SliderTypeSample
import io.github.seyoungcho2.composeslider.ui.compose.CardRow
import io.github.seyoungcho2.composeslider.ui.compose.ItemWithTitle
import io.github.seyoungcho2.composeslider.ui.theme.ComposeSliderTheme
import io.github.seyoungcho2.slider.model.SliderColor
import io.github.seyoungcho2.slider.FilledSlider
import io.github.seyoungcho2.slider.model.SliderType

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


