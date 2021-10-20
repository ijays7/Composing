package com.ijays.composeit.layout

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ijays.composeit.ui.ComposeItTheme

/**
 * ConstraintLayout in Compose works with a DSL
 *
 * - References are created using [createRefs] or [createRef] and each composable in ConstraintLayout
 *   needs to have a reference associated
 *
 * - Constraints are provided using the [constrainAs] modifier which take the reference as a parameter
 *   and lets you specify its constraints in the body lambda
 *
 * - Constraints are specified using [linkTo] or or other helpful methods.
 *
 * - parent is an existing reference that can be used to specify constraints towards the ConstraintLayout
 *  compose itself
 **/
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text(text = "Button")
        }

        Text(text = "Text", modifier = Modifier.constrainAs(text) {
            start.linkTo(button.end, margin = 16.dp)
            top.linkTo(button.top)
            bottom.linkTo(button.bottom)
        })
    }
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    ComposeItTheme {
        ConstraintLayoutContent()
    }
}