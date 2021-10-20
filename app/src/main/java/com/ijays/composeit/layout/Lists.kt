package com.ijays.composeit.layout

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

@Composable
fun SimpleColumn() {
    Column {
        repeat(100) {
            Text(text = "Item $$it")
        }
    }
}

@Preview
@Composable
fun SimpleColumnPreview() {
    SimpleColumn()
}

@Composable
fun SimpleList() {
    // We save the scrolling position with this state
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        repeat(100) {
            Text(text = "Item #$it", style = MaterialTheme.typography.subtitle1)
        }
    }
}

@Preview
@Composable
fun SimpleListPreview() {
    SimpleList()
}

@Composable
fun LazyList() {
    // We save the scrolling position with this state that can also be used to programmatically scroll the list
    val scrollState = rememberLazyListState()

    LazyColumn(modifier = Modifier.fillMaxWidth(), state = scrollState, content = {
        items(100) {
            Text(text = "Item #$it", style = MaterialTheme.typography.subtitle1)
        }
    })
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LazyListPreview() {
    LazyList()
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(data = "https://developer.android.com/images/brand/Android_Robot.png"),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "ImageList Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ImageList() {
    val scrollState = rememberLazyListState()

    LazyColumn(modifier = Modifier.fillMaxWidth(), state = scrollState) {
        items(100) {
            ImageListItem(index = it)
        }
    }
}

@Preview
@Composable
fun ImageListPreview() {
    ImageList()
}


@Composable
fun ScrollingList() {
    val listSize = 100
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text(text = "Scroll to the top")
            }

            Button(modifier = Modifier.padding(start = 10.dp),onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text(text = "Scroll to the end")
            }
        }
        LazyColumn(modifier = Modifier.fillMaxWidth(), state = scrollState) {
            items(listSize) {
                ImageListItem(index = it)
            }
        }
    }
}

@Preview
@Composable
fun ScrollingListPreview() {
    ScrollingList()
}