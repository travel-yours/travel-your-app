package com.example.travelyour.external.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelyour.external.theme.primary
import com.example.travelyour.external.theme.primary2
import com.example.travelyour.external.theme.secondaryPrimay

@Composable
fun ButtonPage(
    onClick: () -> Unit,
    text:String,
    isEnabled:Boolean = false
) {
    Button(
        onClick = {onClick.invoke()},
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentPadding = PaddingValues(),
         colors = ButtonDefaults.buttonColors(
            containerColor = primary,
            contentColor = Color.White,
        ),
        enabled = isEnabled
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(primary2, primary2)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center,
        ){
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            )
        }
    }
}