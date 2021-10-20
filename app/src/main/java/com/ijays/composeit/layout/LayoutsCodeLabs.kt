package com.ijays.composeit.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ijays.composeit.ui.ComposeItTheme

@Composable
fun LayoutsCodeLab(customContent: @Composable () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "LayoutsCodeLab")
        }, actions = {
            IconButton(onClick = { /* do something() */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        })
    }) { innerPadding ->
        BodyContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp),
            customContent = customContent
        )
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier, customContent: @Composable () -> Unit) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codeLad")

        customContent()
    }
}

@Preview
@Composable
fun LayoutsCodeLabPreview() {
    ComposeItTheme { LayoutsCodeLab {} }
}