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
fun SampleDialog() {
    var openDialog by remember { mutableStateOf(true) }

    if(openDialog) {
        AlertDialog(
            onDismissRequest = {
                openDialog = false
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog = false
                    }
                ) {
                    Text(text = "확인")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        openDialog = false
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