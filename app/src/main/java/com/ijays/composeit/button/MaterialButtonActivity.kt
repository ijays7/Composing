package com.ijays.composeit.button

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ijays.composeit.text.AddSimpleSpaceDivider
import com.ijays.composeit.text.SimpleHintText

class MaterialButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                // 简单 Button 显示
                SimpleHintText(text = "Simple Button")
                SimpleButtonComponent()
                AddSimpleSpaceDivider()

                // 带圆角的 Button
                SimpleHintText(text = "带圆角的Button")
                SimpleButtonComponent(corners = 12.dp)
                AddSimpleSpaceDivider()

                // 带边框的 Button
                SimpleHintText(text = "带边框的Button")
                SimpleButtonComponent(12.dp, borderStroke = BorderStroke(1.5.dp, brush = SolidColor(Color.Cyan)))
                AddSimpleSpaceDivider()
            }
        }
    }

    @Composable
    fun SimpleButtonComponent(corners: Dp? = null, borderStroke: BorderStroke? = null) {
        val padding = 16.dp
        Button(
                onClick = {
                    Toast.makeText(this@MaterialButtonActivity, "Button Click", Toast.LENGTH_LONG)
                            .show()
                },
                modifier = Modifier.padding(padding, 0.dp, padding, 0.dp).fillMaxWidth(),
                shape = RoundedCornerShape(corners ?: 0.dp),
                border = borderStroke) {
            Text(text = "Simple Button")
        }
    }


}