package com.example.travelyour.external.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelyour.external.theme.primary

@Composable
fun ButtonPage(
    onClick: () -> Unit,
    text:String,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
         shape = RoundedCornerShape(50.dp),
         colors = ButtonDefaults.buttonColors(
            containerColor = primary,
            contentColor = Color.White,
        )
    ) {
Text(
    text = text,
style = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
)
)
    }
}