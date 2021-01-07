package com.ijays.composeit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
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
import com.ijays.composeit.button.MaterialButtonActivity
import com.ijays.composeit.dialog.DialogTestActivity
import com.ijays.composeit.image.ImageDisplayActivity
import com.ijays.composeit.text.TextDisplayActivity
import com.ijays.composeit.text.TextFieldActivity
import com.ijays.composeit.text.TextStyleActivity
import com.ijays.composeit.ui.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 使用支持垂直滚动的Composable，指定宽度填充屏幕，
            ScrollableColumn(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                val context = this@MainActivity

                ButtonComponent(
                    context = context,
                    intent = Intent(context, TextDisplayActivity::class.java),
                    text = "Simple text display"
                )

                AddSpacer()
                ButtonComponent(
                    context = context,
                    intent = Intent(context, TextStyleActivity::class.java),
                    text = "Text style test"
                )

                AddSpacer()
                ButtonComponent(
                    context = context,
                    intent = Intent(context, TextFieldActivity::class.java),
                    text = "Text input test"
                )

                AddSpacer()
                ButtonComponent(
                    context = context,
                    intent = Intent(context, ImageDisplayActivity::class.java),
                    text = "Image Display test"
                )

                AddSpacer()
                ButtonComponent(
                    context = context,
                    intent = Intent(context, MaterialButtonActivity::class.java),
                    text = "Material Button"
                )

                AddSpacer()
                ButtonComponent(
                    context = context,
                    intent = Intent(context, DialogTestActivity::class.java),
                    text = "Show Dialog"
                )
            }
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
            Image(bitmap = image, imageModifier, contentScale = ContentScale.Crop)

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            Text(
                text = "A day wandering through the sandHills in Shark Fin Cove, and a few of the sights I saw",
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(text = "Davenport, California", style = typography.body2)
            Text(text = "December 2018", style = typography.body2)

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }
        }
    }

    @Composable
    fun ConstraintLayoutContent() {
        ConstraintLayout(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
            // Create references for the composables to constrain
            val (button, text) = createRefs()

            Button(onClick = {
                Toast.makeText(this@MainActivity, "Button click", Toast.LENGTH_LONG).show()
            },
                // Assign reference "button" to the Button composable
                // and constrain it to the top of the ConstraintLayout
                modifier = Modifier.constrainAs(button) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }) {
                Text(text = "Button")
            }

            Text(text = "Text", modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            })


        }
    }

    @Composable
    fun ButtonComponent(context: Context, intent: Intent, text: String) {
        Button(onClick = {
            context.startActivity(intent)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = text)
        }
    }

    @Composable()
    fun AddSpacer() {
        Spacer(modifier = Modifier.fillMaxWidth().padding(8.dp))
    }
}

