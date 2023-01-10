package xyz.xfqlittlefan.byucp.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val topAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    var count by remember { mutableStateOf(0) }

    AppTheme {
        Scaffold(modifier = Modifier.nestedScroll(topAppBarScrollBehavior.nestedScrollConnection), topBar = {
            TopAppBar(
                title = {
                    Text("BoomYouUpCompose")
                }, scrollBehavior = topAppBarScrollBehavior
            )
        }) { padding ->
            LazyColumn(Modifier.padding(padding)) {
                item {
                    Item({ count++ }, { count-- })
                }

                items(count) {
                    Item({ count++ }, { count-- })
                }
            }
        }
    }
}

@Composable
fun Item(onPlus: () -> Unit, onMinus: () -> Unit) {
    Row {
        Button(onClick = {
            onPlus()
        }) {
            Text("+")
        }
        Button(onClick = {
            onMinus()
        }) {
            Text("-")
        }
    }
}
