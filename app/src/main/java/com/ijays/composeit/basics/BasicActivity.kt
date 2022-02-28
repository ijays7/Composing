package com.ijays.composeit.basics

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ijays.composeit.ui.ComposeItTheme

/**
 * Created by ijays on 2021/10/20.
 */
class BasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeItTheme {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp() {
        var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }

        if (shouldShowOnBoarding) {
            OnboardScreen {
                shouldShowOnBoarding = false
            }
        } else {
            Greetings()
        }
    }

    @Composable
    fun OnboardScreen(onContinueClicked: () -> Unit) {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Welcome to the Basics CodeLab!")

                Button(
                    modifier = Modifier.padding(vertical = 24.dp),
                    onClick = onContinueClicked
                ) {
                    Text(text = "Continue")
                }
            }
        }

    }

    @Composable
    private fun Greetings(names: List<String> = List(1000) { "$it" }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            items(items = names) { name ->
                Greeting(name = name)
            }
        }
    }


    /**
     * Compose apps transform data into UI by calling composable functions. If your data changes,
     * Compose re-executes theses functions with the new data, creating an update UI---this is called recomposition.
     *
     * Compose also looks at what data is needed by an individual composable so that it only needs to
     * recompose components whose data has changed and skip recomposing those that are not affected.
     */
    @Composable
    private fun Greeting(name: String) {
        val expanded = rememberSaveable { mutableStateOf(false) }

        val extraPadding by animateDpAsState(
            if (expanded.value) 48.dp else 0.dp,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )

        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                ) {
                    Text(text = "Hello, ")
                    Text(text = name)
                }

                OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                    Text(text = if (expanded.value) "Show less" else "Show more")
                }
            }
        }
    }

    @Preview
    @Composable
    fun GreetingPreview() {
        ComposeItTheme {
            Greeting("ijays")
        }
    }
}