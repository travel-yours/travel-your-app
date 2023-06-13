package com.example.travelyour.external.widget




import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeDatePicker(
    startDate: LocalDate,
    endDate: LocalDate,
    onStartDateSelected: (LocalDate) -> Unit,
    onEndDateSelected: (LocalDate) -> Unit
){
    val datePickerState = rememberMaterialDialogState()
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Tanggal Mulai: ${startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}",
        style = MaterialTheme.typography.bodySmall
            )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {datePickerState.show()} ) {
            Text(text = "Pilih Tanggal Mulai")
            
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tanggal Selesai: ${endDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}",
            style = MaterialTheme.typography.bodySmall
            )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { datePickerState.show() }) {
            Text(text = "Pilih Tanggal selesai")
            
        }
    }
    
    MaterialDialog(
        dialogState = datePickerState,
        buttons = {
            positiveButton(text = "Ok")

            negativeButton(text = "Cancel")
        }
    ) {
        datepicker(
            initialDate = startDate,
            title = "Pilih Tanggal",
            onDateChange = {selectedDate ->
                if (selectedDate < startDate){
                    onStartDateSelected(selectedDate)
                }else{
                    onEndDateSelected(selectedDate)
                }
            },
            
        )
    }

}

@Preview
@Composable
fun ComposeDatePickerPrev() {
    val startDate = LocalDate.of(2023,6,1)
    val endDate = LocalDate.of(2023,6,30)

    ComposeDatePicker(
        startDate = startDate ,
        endDate =endDate ,
        onStartDateSelected ={} , onEndDateSelected ={} )
    
}