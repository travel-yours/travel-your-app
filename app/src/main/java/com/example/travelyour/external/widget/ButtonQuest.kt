package com.example.travelyour.external.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelyour.external.theme.primary

@Composable
fun ButtonQuest(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    defaultBackground: Color = Color.White,
    defaultTextColor: Color = primary,
    clickedBackground: Color = primary,
    clickedText: Color = Color.White,

) {
    var isButtonClicked by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isButtonClicked = !isButtonClicked
            onClick.invoke()
        },
         modifier
        .padding(top = 20.dp, bottom = 20.dp)
        .fillMaxWidth()
        .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isButtonClicked) clickedBackground else defaultBackground,
             contentColor = if (isButtonClicked) clickedText else defaultTextColor
        ),
        border = BorderStroke(1.dp, primary)

        ) {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null,
        modifier = Modifier
            .padding(start = 5.dp))
        Text(
            text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold)
    }
}