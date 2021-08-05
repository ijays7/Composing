package com.ijays.composeit.text

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

/**
 * Created by ijays on 2020/12/13.
 */
class TextFieldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
//                showSimpleText(text = "TextField 输入")
//                SimpleTextField()
//
//                addSpacer()
//                showSimpleText(text = "TextField 添加placeHolder")
//                SimpleTextField(hasPlaceHolder = true)
//
//                addSpacer()
//                showSimpleText(text = "TextField 添加键盘类型")
//                SimpleTextField(hasPlaceHolder = true, keyboardType = KeyboardType.Number)
//
//                addSpacer()
//                showSimpleText(text = "TextField 设置背景")
//                SimpleTextField(
//                    backgroundColor = Color.Cyan,
//                    hasPlaceHolder = true,
//                    keyboardType = KeyboardType.Number
//                )

                addSpacer()
                HelloContent()
            }
        }
    }

    @Composable
    fun HelloContent() {
        var name by rememberSaveable { mutableStateOf("") }

        Hello(name = name) {
            name = it
        }
    }

    @Composable
    fun Hello(name: String, onNameChange: (String) -> Unit) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (name.isNotEmpty()) {
                Text(
                    text = "Hello, $name",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.h5
                )
            }
            OutlinedTextField(value = name,
                onValueChange = onNameChange,
                label = { Text(text = "Name") })
        }
    }


    @Composable
    fun showSimpleText(text: String) {
        Text(text = text)
    }

    @Composable
    fun addSpacer() {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }

    @Composable
    fun SimpleTextField(
        hasLabel: Boolean = false,
        hasPlaceHolder: Boolean = false,
        keyboardType: KeyboardType? = KeyboardType.Text,
        backgroundColor: Color? = Color.White
    ) {

        // rememberSaveable 与 remember 类似，但是会在 Activity 或者进程重启时保存数据，比如屏幕发生旋转时候
        var text by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("placeholder") },
//            leadingIcon = {
//                Icon(
//                    Icons.Filled.Favorite,
//                    contentDescription = "Localized description"
//                )
//            },
//            trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Localized description") }
        )

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            placeholder = { Text(text = "PlaceHolder") },
            label = { Text(text = "Label") }
        )

//        TextField(
//            value = text.toString(),
//            modifier = Modifier.fillMaxWidth(),
////            onValueChange = {
////                Log.e("SONGJIE", "input is $it")
////            },
//
//            keyboardOptions = KeyboardOptions(keyboardType = keyboardType ?: KeyboardType.Text),
//            label = if (hasLabel) {
//                Text(text = "label")
//            } else null,
//            palceholder = if (hasPlaceHolder) {
//                Text(text = "PlaceHolder")
//            },
//            backgroundColor = backgroundColor ?: Color.White,
//        )
    }

    private fun TextField(value: String, onValueChange: (String) -> Unit, label: (() -> Unit)?) {

    }
}