package com.ijays.composeit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.ijays.composeit.ui.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewStory()
        }
    }

    @Composable
    fun NewStory() {
        val image = imageResource(id = R.drawable.ic_header)
        // 垂直摆放子控件
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifier =
                    // 指定图片高度
                    Modifier.preferredHeight(180.dp)
                            // 指定图片的宽度应足以填充所属布局
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(12.dp))
                            .clickable(onClick = {
                                Toast.makeText(this@MainActivity, "Click Test", Toast.LENGTH_LONG).show()
                            })
            Image(asset = image, imageModifier, contentScale = ContentScale.Crop)

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            Text(text = "A day wandering through the sandHills in Shark Fin Cove, and a few of the sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis)
            Text(text = "Davenport, California", style = typography.body2)
            Text(text = "December 2018", style = typography.body2)

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name")
    }

}

