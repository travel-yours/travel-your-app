package com.example.travelyour.external.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun EmailInput(

    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    errorMessage: String,
    textStyle: TextStyle = LocalTextStyle.current
) {
    var isError by remember { mutableStateOf(false) }

    Column() {
        OutlinedTextField(
            value = value,
            onValueChange = { newValue ->
                onValueChange(newValue)
                isError = newValue.isEmpty() // Contoh validasi, jika input kosong maka tampilkan pesan error
            },

            placeholder = { Text(text = placeholder) },
            isError = isError,
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(10.dp),

            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,

                ),
            singleLine = true,
            textStyle = textStyle,

        )

        if (isError) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}