package com.ijays.composeit.state.livedata

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ijays.composeit.R
import com.ijays.composeit.data.Person

/**
 * Created by ijays on 2021/1/25.
 */
@ExperimentalMaterialApi
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
            LiveDataComponentList(personList)
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

    @Composable
    fun LiveDataComponentList(personList: List<Person>) {
        // LazyColumn 是一个垂直滚动的列表，并且只会 compose 当前可见的 item，类似于 View 体系中的 RecyclerView
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(items = personList, itemContent = { person ->
                Card(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    ListItem(text = {
                        Text(
                            text = person.name,
                            style = TextStyle(
                                fontFamily = FontFamily.Serif,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }, secondaryText = {
                        Text(
                            text = "Age: ${person.age}",
                            style = TextStyle(
                                fontFamily = FontFamily.Serif, fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }, icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_header),
                            contentDescription = "desc",
                            modifier = Modifier
                                .requiredWidth(60.dp)
                                .requiredHeight(60.dp),
                            contentScale = ContentScale.Crop
                        )
                    })
                }
            })
        }

    }

}