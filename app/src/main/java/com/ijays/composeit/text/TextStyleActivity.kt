package com.ijays.composeit.text

import android.os.Bundle
import android.widget.Space
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Demonstrate different text style
 */
class TextStyleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScrollableColumn {
                // 简单文字显示
                TextStylingTest(text = "纯文本显示")

                // 设置字体大小
                TextStylingTest(text = "将字体设置为24sp显示",
                        style = TextStyle(fontSize = 24.sp))

                // 设置字体加粗
                TextStylingTest(text = "设置字体加粗",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp))

                // 设置字体为斜体
                TextStylingTest(text = "设置字体为斜体",
                        style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 16.sp))

                // 设置字体颜色
                TextStylingTest(text = "设置字体颜色为红色",
                        style = TextStyle(color = Color.Red))

                // 设置不同字体
                TextStylingTest(text = "设置字体为MonoSpace",
                        style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 16.sp))

                TextStylingTest(text = "设置字体为MonoSpace，同时加粗等",
                        style = TextStyle(
                                color = Color.Red,
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                fontSize = 16.sp))

                // 添加字体下划线
                TextStylingTest(text = "添加字体下划线",
                        style = TextStyle(textDecoration = TextDecoration.Underline))

                // 添加删除线
                TextStylingTest(text = "添加删除线",
                        style = TextStyle(textDecoration = TextDecoration.LineThrough))

                // 添加文字阴影
                TextStylingTest(text = "添加文字阴影",
                        style = TextStyle(fontSize = 16.sp,
                                shadow = Shadow(
                                        color = Color.Red,
                                        blurRadius = 8f,
                                        offset = Offset(2f, 2f))))

                // 添加文字背景
                TextStylingTest(text = "添加文字背景",
                        style = TextStyle(
                                fontSize = 16.sp,
                                background = Color.Cyan))

                // 设置首行缩进30sp
                TextStylingTest(text = "设置首行缩进30dp。锦书送罢蓦回首，无余岁可偷",
                        style = TextStyle(
                                fontSize = 16.sp,
                                textIndent = TextIndent(firstLine = 30.sp)

                        ))

                // 添加Span
                val span = annotatedString {
                    append("添加Span以设置不同的字体样式")
                    addStyle(style = SpanStyle(color = Color.Red), start = 0, 2)
                    addStyle(style = SpanStyle(color = Color.Magenta), start = 2, 6)
                    addStyle(style = SpanStyle(color = Color.Cyan), start = 6, 16)
                }
                Text(span, modifier = Modifier.padding(16.dp, 8.dp, 8.dp, 16.dp))

                // 设置字体间距
                TextStylingTest(text = "设置字体间距为4sp",
                        style = TextStyle(letterSpacing = 4.sp))

                // 设置最大行数
                TextStylingTest(text = "设置最大行距为1行。天青色等烟雨，而我在等你，炊烟袅袅升起，隔江千万里。在瓶底书刻隶防前朝的飘逸。",
                        style = TextStyle(fontSize = 16.sp),
                        maxLines = 2)

                // 设置行高为24p
                TextStylingTest(text = "设置行高为24sp。天青色等烟雨，而我在等你，炊烟袅袅升起，隔江千万里。在瓶底书刻隶防前朝的飘逸。",
                        style = TextStyle(fontSize = 16.sp,
                                lineHeight = 24.sp))

                // 设置居中对齐
                TextStylingTest(text = "设置居中对齐。天青色等烟雨，而我在等你，炊烟袅袅升起，隔江千万里。在瓶底书刻隶防前朝的飘逸。",
                        style = TextStyle(fontSize = 16.sp,
                                textAlign = TextAlign.Center))

                Spacer(modifier = Modifier.fillMaxWidth().padding(50.dp))
            }
        }
    }

    @Composable
    fun TextStylingTest(text: String, style: TextStyle? = null, maxLines: Int? = null) {
        val verticalPadding = 8.dp
        val horizontalPadding = 16.dp
        Text(text = text,
                modifier = Modifier.padding(horizontalPadding, verticalPadding, verticalPadding, horizontalPadding),
                // 指定字体样式
                style = style ?: TextStyle.Default,
                // 指定当字数超过最大限制时显示方式，这里设置为显示省略号
                overflow = TextOverflow.Ellipsis,
                // 指定最大行数
                maxLines = maxLines ?: Int.MAX_VALUE)
    }
}