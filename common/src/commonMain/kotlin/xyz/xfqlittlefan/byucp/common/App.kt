package xyz.xfqlittlefan.byucp.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val topAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    AppTheme {
        Scaffold(modifier = Modifier.nestedScroll(topAppBarScrollBehavior.nestedScrollConnection), topBar = {
            TopAppBar(
                title = {
                    Text("BoomYouUpCompose")
                }, scrollBehavior = topAppBarScrollBehavior
            )
        }) { padding ->
            Column(Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState())) {
                Text(TEXT)
            }
        }
    }
}

private const val TEXT = """
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Faucibus a pellentesque sit amet porttitor eget dolor morbi non. Ultricies tristique nulla aliquet enim tortor at auctor. Cum sociis natoque penatibus et. Ac tincidunt vitae semper quis lectus. Vestibulum lorem sed risus ultricies tristique nulla. Sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. In egestas erat imperdiet sed euismod nisi porta lorem. Nulla posuere sollicitudin aliquam ultrices sagittis orci. Nunc congue nisi vitae suscipit. Sodales ut etiam sit amet nisl purus in.

Hendrerit gravida rutrum quisque non. Mattis rhoncus urna neque viverra justo nec ultrices. Pellentesque habitant morbi tristique senectus et. Ac felis donec et odio pellentesque diam volutpat. Aenean euismod elementum nisi quis eleifend. Donec ultrices tincidunt arcu non sodales neque. Aliquet eget sit amet tellus. Nunc sed blandit libero volutpat sed cras. Viverra orci sagittis eu volutpat odio facilisis mauris. Elit pellentesque habitant morbi tristique senectus et. Morbi tristique senectus et netus. Ultrices tincidunt arcu non sodales neque sodales. Ligula ullamcorper malesuada proin libero nunc consequat.

Sed felis eget velit aliquet sagittis id. Ut enim blandit volutpat maecenas volutpat. Placerat in egestas erat imperdiet sed euismod. Tempor nec feugiat nisl pretium fusce id velit. Dictum at tempor commodo ullamcorper. Pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae. Convallis a cras semper auctor neque. Laoreet sit amet cursus sit amet dictum sit amet justo. Commodo ullamcorper a lacus vestibulum sed arcu non odio. Justo donec enim diam vulputate ut pharetra sit amet aliquam.

Iaculis at erat pellentesque adipiscing commodo elit at imperdiet dui. Ultricies leo integer malesuada nunc vel risus. Sit amet risus nullam eget felis eget nunc. Nisi lacus sed viverra tellus in hac habitasse. Senectus et netus et malesuada fames ac turpis egestas. Nulla facilisi nullam vehicula ipsum a arcu cursus. A erat nam at lectus urna duis convallis convallis. Consectetur purus ut faucibus pulvinar elementum integer enim neque. Nec feugiat in fermentum posuere urna. In tellus integer feugiat scelerisque varius. Mattis vulputate enim nulla aliquet porttitor lacus. Facilisi nullam vehicula ipsum a arcu. Volutpat diam ut venenatis tellus in metus.

Vitae semper quis lectus nulla at volutpat diam ut venenatis. Imperdiet dui accumsan sit amet nulla facilisi. Adipiscing vitae proin sagittis nisl rhoncus. Egestas quis ipsum suspendisse ultrices gravida dictum fusce ut. Rhoncus urna neque viverra justo. Faucibus interdum posuere lorem ipsum dolor sit. Morbi non arcu risus quis varius quam quisque. In ante metus dictum at tempor commodo ullamcorper a. Enim nunc faucibus a pellentesque sit amet porttitor eget dolor. Felis donec et odio pellentesque diam volutpat commodo. Malesuada fames ac turpis egestas integer. At consectetur lorem donec massa sapien faucibus.
"""
