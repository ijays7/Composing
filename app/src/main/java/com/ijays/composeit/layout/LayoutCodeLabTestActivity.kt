package com.ijays.composeit.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import com.ijays.composeit.ui.ComposeItTheme

/**
 * Created by ijays on 2021/10/17.
 */
class LayoutCodeLabTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeItTheme {
                Column {
                    LayoutsCodeLab {
                        ScrollingList()
                    }
                }
            }
        }
    }
}