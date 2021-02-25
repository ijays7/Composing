package com.ijays.composeit.state.livedata

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ijays.composeit.data.Person

/**
 * Created by ijays on 2021/1/25.
 */
class LiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LiveDataComponent()
        }
    }

    @Composable
    fun LiveDataComponent() {
        val viewModel by viewModels<SuperheroesViewModel>()
        val personList: List<Person> =
            viewModel.superheroes.observeAsState(initial = emptyList()).value
        if (personList.isEmpty()) {
            LiveDataLoadingComponent()
        } else {

        }
    }

    @Composable
    fun LiveDataLoadingComponent() {
        // Column 用于垂直摆放子控件
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally))
        }
    }

}