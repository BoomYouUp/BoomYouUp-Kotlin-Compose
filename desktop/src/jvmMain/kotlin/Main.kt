import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import xyz.xfqlittlefan.byucp.common.App


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "BoomYouUpCompose") {
        App()
    }
}
