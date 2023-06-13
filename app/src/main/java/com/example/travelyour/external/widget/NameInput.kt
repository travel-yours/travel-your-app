package com.example.travelyour.external.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.travelyour.external.theme.primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameInput(
    labelValue: String, painterResources: Painter,
    onValueChange: (String) -> Unit,
    placeholder: String,
    errorStatus: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current
) {
    val textValue = remember { mutableStateOf("") }

    var isError by remember { mutableStateOf(false) }

    Column() {
        OutlinedTextField(
            value = textValue.value,
            onValueChange = {
                textValue.value = it
                onValueChange(it)
            },
            label = {Text(text = labelValue)},
            placeholder = { Text(text = placeholder) },
            isError = !errorStatus,
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(10.dp),

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = primary,
                focusedLabelColor = primary,
                errorBorderColor = Color.Red

                ),
            leadingIcon = { Icon(painter = painterResources, contentDescription = "")},
            singleLine = true,
            textStyle = textStyle,
            maxLines = 1

        )

    }
   }