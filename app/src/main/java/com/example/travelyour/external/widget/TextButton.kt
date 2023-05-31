package com.example.travelyour.external.widget

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.travelyour.external.theme.primary

@Composable
fun TextButtonCustome(
    onClick:() -> Unit,
    text:String,
    modifier: Modifier = Modifier,

) {
    TextButton(
        onClick = onClick,
    ) {
Text(
    text = text,
   style = TextStyle(
       fontSize = 16.sp,
       color = primary,
       fontWeight = FontWeight.SemiBold,
   )
)
    }
}