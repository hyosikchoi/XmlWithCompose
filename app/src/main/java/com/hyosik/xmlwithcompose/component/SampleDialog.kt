package com.hyosik.xmlwithcompose.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SampleDialog(
    openDialog: Boolean,
    onCloseDialog: () -> Unit,
) {

    if(openDialog) {
        AlertDialog(
            onDismissRequest = {
                onCloseDialog()
            },
            confirmButton = {
                Button(
                    onClick = {
                        onCloseDialog()
                    }
                ) {
                    Text(text = "확인")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        onCloseDialog()
                    }
                ) {
                    Text(text = "취소")
                }
            },
            title = {
                Text(text = "더하기")
            },
            text = {
                Text(text = "더하기 버튼")
            }
        )
    }

}