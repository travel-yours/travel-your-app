package com.example.travelyour.external.widget


import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType


import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.travelyour.R
import androidx.compose.material3.IconButton
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.travelyour.external.theme.primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    labelValue:String,painterResources: Painter,
    onPasswordChange: (String) -> Unit,
    placeholder: String,
    errorStatus: Boolean = false,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current

) {
  val localFocusManager = LocalFocusManager.current
    val password = remember { mutableStateOf("") }
    val passwordVisible = remember{ mutableStateOf(false) }
   Column {
       OutlinedTextField(
           modifier = modifier.fillMaxWidth(),
           label ={ Text(text = labelValue)},
           value = password.value,
           onValueChange = {
                 password.value = it
               onPasswordChange(it)
           },

           placeholder = { Text(text = placeholder, style = textStyle)},


            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
           singleLine = true,
           keyboardActions = KeyboardActions {
               localFocusManager.clearFocus()
           },
           maxLines= 1,
           shape = RoundedCornerShape(10.dp),
            leadingIcon = { Icon(painter = painterResources, contentDescription = "")},
           trailingIcon = {
               val iconImage = if (passwordVisible.value){
                   ImageVector.vectorResource(id = R.drawable.visibility)
               }else{
                   ImageVector.vectorResource(id = R.drawable.visibilityof)
               }

               val description = if (passwordVisible.value){
                   stringResource(id = R.string.hide_password)
               }else{
                   stringResource(id = R.string.show_password)
               }
               IconButton(onClick = { passwordVisible.value = !passwordVisible.value}) {
                   Icon(imageVector = iconImage, contentDescription =description )

               }
           },
           visualTransformation = if (passwordVisible.value) VisualTransformation.None
                   else PasswordVisualTransformation(),
            isError = !errorStatus,
           colors = TextFieldDefaults.outlinedTextFieldColors(
               focusedLabelColor = primary,
               errorBorderColor = Color.Red,
               errorPrefixColor = Color.Black,
               focusedPlaceholderColor = Color.Black,
               unfocusedPlaceholderColor = Color.Black

           ),
       )

   }
}



