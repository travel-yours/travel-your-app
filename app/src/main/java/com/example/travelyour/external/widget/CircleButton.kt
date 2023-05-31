package com.example.travelyour.external.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.travelyour.external.theme.primary2

@Composable
fun CircleButton(
    onClick: () -> Unit,
    size: Dp,
    backgroundColor: Color = Color.Black,
    blurRadius: Dp = 8.dp
) {
    Box(
        modifier = Modifier
            .size(size)
            .background(backgroundColor, shape = CircleShape)
            .graphicsLayer()
    ) {
       IconButton(onClick = onClick) {
           Icon(
               imageVector = Icons.Default.KeyboardArrowLeft,
               contentDescription = "Back",
              tint = MaterialTheme.colorScheme.onSurface,
           modifier = Modifier.size(40.dp).align(Alignment.Center))
       }
    }
}

@Preview
@Composable
fun CircleButtonPrev() {
    CircleButton(onClick = { /*TODO*/ }, size = 48.dp, backgroundColor = primary2, blurRadius = 30.dp )
}