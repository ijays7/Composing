package com.ijays.composeit.anim

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

/**
 * Created by ijays on 2021/3/3.
 */
class AnimActivity : AppCompatActivity() {

    private val viewModel by viewModels<AnimViewModel>()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisibilityAnim()

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(16.dp)
            )

            val totalCountdownTime = 15
            viewModel.setCountdownTime(totalCountdownTime)

            doCircle(totalCountdownTime)
            ShowTimerText(totalCountdownTime)

        }
    }

    @Composable
    fun doCircle(totalCountdownTime: Int) {
        val angle = viewModel.currentAnimTime / totalCountdownTime.toFloat() * 360
        Log.e("SONGJIE", "current===>${viewModel.currentAnimTime}====angle==>$angle")
        CircleView(sweepAngle = angle)
    }

    @Composable
    fun ShowTimerText(totalCountdownTime: Int) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            val leftTime = totalCountdownTime - viewModel.currentAnimTime
            val minute = leftTime / 60
            val seconds = leftTime % 60
            Text(text = String.format("%02d:%02d",minute,seconds))
        }
    }


    @Composable
    fun CircleView(sweepAngle: Float) {
        val animateAngle: Float by animateFloatAsState(
            targetValue = sweepAngle, animationSpec = tween(
                1000, 0,
                LinearEasing
            )
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val radius = 80.dp.toPx()
            drawCircle(
                color = Color.Blue,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                style = Stroke(width = 10f),
                radius = radius
            )
            drawArc(
                color = Color.Red,
                startAngle = -90f,
                sweepAngle = animateAngle,
                useCenter = false,
                topLeft = Offset(
                    x = (canvasWidth / 2) - radius,
                    y = canvasHeight / 2 - radius
                ),
                size = Size(radius * 2, radius * 2),
                style = Stroke(width = 12f)
            )
        }
    }

    @Preview
    @Composable
    fun PreviewDraw() {
        CircleView(0f)
    }


    @ExperimentalAnimationApi
    @Composable
    fun VisibilityAnim() {
        var visible by rememberSaveable { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { visible = !visible }) {
                Text(text = if (visible) "HIDE" else "SHOW")
            }

            Spacer(modifier = Modifier.requiredHeight(16.dp))

//            if (!visible) {
//                val value = remember {
//                    Animatable(initialValue = 0f)
//                }
//                LaunchedEffect(key1 = 100f) {
//                    value.animateTo(100f,animationSpec = tween(durationMillis =3000))
//                }
//                Log.e("SONGJIE","value is==>${value.value}")
//                CircleView(sweepAngle = value.value)
//            }

//            AnimatedVisibility(visible = visible) {
//                Box(
//                    modifier = Modifier
//                        .requiredSize(128.dp)
//                        .background(Color.Blue),
//
//                    )
//            }
        }
    }
}