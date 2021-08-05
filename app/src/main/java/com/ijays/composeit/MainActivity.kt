package com.ijays.composeit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ijays.composeit.anim.AnimActivity
import com.ijays.composeit.button.MaterialButtonActivity
import com.ijays.composeit.dialog.DialogTestActivity
import com.ijays.composeit.image.ImageDisplayActivity
import com.ijays.composeit.state.livedata.LiveDataActivity
import com.ijays.composeit.text.TextDisplayActivity
import com.ijays.composeit.text.TextFieldActivity
import com.ijays.composeit.text.TextStyleActivity
import com.ijays.composeit.ui.typography

class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ScrollableColumn 在新版本中被废弃，官方推荐试用 LazyColumn，因为后者只会 compose/measure/draw 可见的元素，
            // 如果仍需使用 ScrollableColumn，可以在 modifier 中添加 verticalScroll()
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
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

                AddSpacer()
                ButtonComponent(
                    context = context,
                    intent = Intent(context, LiveDataActivity::class.java),
                    text = "Live Data Activity"
                )

                AddSpacer()
                ButtonComponent(
                    context = context,
                    intent = Intent(context, AnimActivity::class.java),
                    text = "Anim Test Activity"
                )
            }
        }
    }

    @Composable
    fun NewStory() {
        val image = painterResource(id = R.drawable.ic_header)
        // 垂直摆放子控件
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifier =
                // 指定图片高度
                Modifier
                    .requiredHeight(180.dp)
                    // 指定图片的宽度应足以填充所属布局
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp))
                    .clickable(onClick = {
                        Toast
                            .makeText(this@MainActivity, "Click Test", Toast.LENGTH_LONG)
                            .show()
                    })
            Image(
                painter = image,
                contentDescription = "desc",
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.requiredHeight(16.dp))

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
//        ConstraintLayout(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 16.dp)
//        ) {
//            // Create references for the composables to constrain
//            val (button, text) = createRefs()
//
//            Button(onClick = {
//                Toast.makeText(this@MainActivity, "Button click", Toast.LENGTH_LONG).show()
//            },
//                // Assign reference "button" to the Button composable
//                // and constrain it to the top of the ConstraintLayout
//                modifier = Modifier.constrainAs(button) {
//                    top.linkTo(parent.top, margin = 10.dp)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end, margin = 16.dp)
//                    width = Dimension.fillToConstraints
//                }) {
//                Text(text = "Button")
//            }
//
//            Text(text = "Text", modifier = Modifier.constrainAs(text) {
//                top.linkTo(button.bottom, margin = 16.dp)
//            })
//
//
//        }
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
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

