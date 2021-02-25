package com.ijays.composeit.image

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ijays.composeit.R

class ImageDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()).fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "本地图片显示")
                ImageDisplay()

                Text(text = "设置图片圆角为12dp")
                ImageDisplay(roundedCorner = 12.dp)
            }
        }
    }

    @Composable
    fun ImageDisplay(roundedCorner: Dp? = 0.dp) {
        val image = painterResource(id = R.drawable.ic_header)
        val imageModifier =
            // 指定图片高度
            Modifier.requiredHeight(180.dp)
                // 指定图片宽度应足以填充所属布局
                .fillMaxWidth()
                // attention: modifier 设置的顺序可能会影响显示。这里如果 clip 先于 padding 设置，则无法显示圆角
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(roundedCorner ?: 0.dp))
                .clickable(onClick = {
                    Toast.makeText(this@ImageDisplayActivity, "click image", Toast.LENGTH_SHORT)
                        .show()
                })

        Image(
            painter = image, contentDescription = "desc",
            // 设置缩放模式，相当于CenterCrop
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
    }
}