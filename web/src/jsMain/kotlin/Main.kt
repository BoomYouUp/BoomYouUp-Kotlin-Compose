import composables.renderComposableIntoBrowserViewport
import org.jetbrains.skiko.wasm.onWasmReady
import xyz.xfqlittlefan.byucp.common.App

fun main() {
    onWasmReady {
        renderComposableIntoBrowserViewport("BoomYouUpX") {
            App()
        }
    }
}