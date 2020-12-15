package com.ijays.composeit.text

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ijays.composeit.ui.typography

/**
 * Created by ijays on 2020/12/15.
 */
@Composable
fun SimpleHintText(text: String) {
    Text(text = text,
            style = typography.body1,
            modifier = Modifier.padding(16.dp).fillMaxWidth())
}

@Composable
fun AddSimpleSpaceDivider() {
    Spacer(modifier = Modifier.padding(16.dp).fillMaxWidth())
}