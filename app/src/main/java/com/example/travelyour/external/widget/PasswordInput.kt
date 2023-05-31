package com.example.travelyour.external.widget


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle


import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordInput(
    value:String,
    onPasswordChange: (String) -> Unit,
    placeholder: String,
    errorMessage: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current

) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }
   Column {
       OutlinedTextField(
           value = value,
           onValueChange = {
                   newValue -> onPasswordChange(newValue)
               isError = newValue.isEmpty()
           },

           placeholder = { Text(text = placeholder, style = textStyle)},
           singleLine = true,
           isError = isError,
           modifier = modifier.fillMaxWidth(),
           shape = RoundedCornerShape(10.dp),

           visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

           textStyle = textStyle,
           colors = TextFieldDefaults.colors(
               focusedIndicatorColor = Color.Transparent,
               unfocusedIndicatorColor = Color.Transparent
           ),
       )
       if (isError){
           Text(text = errorMessage,
           color = Color.Red,
           modifier = Modifier.padding(top = 4.dp))
       }
   }
}