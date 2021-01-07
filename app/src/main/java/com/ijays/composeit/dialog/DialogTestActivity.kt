package com.ijays.composeit.dialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

/**
 * Created by ijays on 2021/1/7.
 */
class DialogTestActivity : AppCompatActivity() {

    var showDialog = mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ScrollableColumn {


                Button(onClick = {
                    showDialog.value = true

                }, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Text(text = "click me to display dialog")
                }

                if (showDialog.value) {
                    AlertDialog(onDismissRequest = { /*TODO*/ },
                        title = { Text(text = "Alert Dialog") },
                        text = { Text(text = "Yes, This is text content!") },
                        confirmButton = {
                            TextButton(onClick = { showDialog.value = false }) {
                                Text(text = "OK")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDialog.value = false }) {
                                Text(text = "Cancel")
                            }
                        })
                }
            }
        }
    }
}