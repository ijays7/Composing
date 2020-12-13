package com.ijays.composeit.text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMap
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

/**
 * Created by ijays on 2020/12/13.
 */
class TextFieldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                showSimpleText(text = "TextField 输入")
                SimpleTextField()

                addSpacer()
                showSimpleText(text = "TextField 添加placeHolder")
                SimpleTextField(hasPlaceHolder = true)

                addSpacer()
                showSimpleText(text = "TextField 添加键盘类型")
                SimpleTextField(hasPlaceHolder = true, keyboardType = KeyboardType.Number)

                addSpacer()
                showSimpleText(text = "TextField 设置背景")
                SimpleTextField(backgroundColor = Color.Cyan, hasPlaceHolder = true, keyboardType = KeyboardType.Number)

            }
        }
    }

    @Composable
    fun showSimpleText(text: String) {
        Text(text = text)
    }

    @Composable
    fun addSpacer() {
        Spacer(modifier = Modifier.fillMaxWidth().padding(16.dp))
    }

    @Composable
    fun SimpleTextField(hasLabel: Boolean = false, hasPlaceHolder: Boolean = false, keyboardType: KeyboardType? = KeyboardType.Text,
                        backgroundColor: Color? = Color.White) {

        // savedInstanceState 类似于onSavedInstanceState，在 Activity 重建时保存数据，比如说屏幕发生旋转
        var text by savedInstanceState { "" }
        TextField(value = text,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    text = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType ?: KeyboardType.Text),
                label = if (hasLabel) {
                    { Text(text = "label") }
                } else null,
                placeholder = if (hasPlaceHolder) {
                    {
                        Text(text = "PlaceHolder")
                    }
                } else null,
                backgroundColor = backgroundColor ?: Color.White,
                visualTransformation = object : VisualTransformation {
                    override fun filter(text: AnnotatedString): TransformedText {
                        // 设置对输入进行转换，如转换为信用卡格式
                        return TransformedText(text, OffsetMap.identityOffsetMap)
                    }

                })
    }
}