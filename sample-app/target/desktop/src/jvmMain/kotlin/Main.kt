import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.seyoungcho2.composeslider.App


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "FilledSliderCompose"
    ) {
        App()
    }
}

@Preview
@Composable
fun DefaultPreview() {
    App()
}
