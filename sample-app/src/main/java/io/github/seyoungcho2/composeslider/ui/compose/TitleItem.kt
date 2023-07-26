package io.github.seyoungcho2.composeslider.ui.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TitleItem(title: String) {
    Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
}