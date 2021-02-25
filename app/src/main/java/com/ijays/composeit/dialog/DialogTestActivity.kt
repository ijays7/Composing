package com.ijays.composeit.dialog

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by ijays on 2021/1/7.
 */
class DialogTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ShowDialog()
            }
        }
    }

    @Composable
    fun ShowDialog() {
        // remember 可以赋予可组合函数记忆能力
        // 1. 在可组合项中创建 MutableState<T> (或其他有状态对象)时，务必使用 remember 记住它们。否则每次重组时，它们
        //    都会重新初始化
        // 2. 状态应该由可组合项中的事件来修改
        // 3. 在组合中被 remember 记住的值在配置更改（如旋转）起见会被忘记并重新加载。如 showDialog，在屏幕旋转后，会被重置为 false，
        //    我们可以改用保存的实例状态，在配置更改时自动保存和恢复状态，从而解决此问题，即 savedInstanceState<T>，
        //    因此开发者应该评估在向可组合项添加内部状态时，是否应该在配置更改或中断（如来电）起见保持该状态。
        var showDialog: Boolean by remember { mutableStateOf(false) }

//        var showDialog: Boolean by savedInstanceState { false }

        Button(
            onClick = {
                showDialog = true

            }, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "click me to display dialog")
        }

        if (showDialog) {
            AlertDialog(onDismissRequest = {
                Toast.makeText(this@DialogTestActivity, "onDismiss", Toast.LENGTH_SHORT)
                    .show()
            }, title = { Text(text = "Alert Dialog") },
                text = { Text(text = "Yes, This is text content!") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(text = "OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(text = "Cancel")
                    }
                })
        }
    }


}