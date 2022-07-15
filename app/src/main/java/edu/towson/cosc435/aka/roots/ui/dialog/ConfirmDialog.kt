package edu.towson.cosc435.aka.roots.ui.dialog

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import edu.towson.cosc435.aka.roots.ui.viewmodel.NotificationWorker

private lateinit var worker: WorkManager

@Composable
fun ConfirmDialog(
    title: String,
    text: String,
    confirmViewModel: IConfirmViewModel,
) {
    worker = WorkManager.getInstance()
    val request = OneTimeWorkRequest.Builder(NotificationWorker::class.java).build()
    val show by confirmViewModel.showConfirmDialog
    if(show) {
        AlertDialog(
            onDismissRequest = { confirmViewModel.dismissDialog() },
            title = {Text(title)},
            text = {Text(text)},
            confirmButton = {
                Button({
                    worker.enqueue(request)
                    confirmViewModel.onConfirm()
                }) {
                    Text("Ok")
                }
            }
        )
    }
}

@Composable
fun InsufficientDialog(
    title: String,
    text: String,
    confirmViewModel: IConfirmViewModel,
) {
    val show by confirmViewModel.showConfirmDialog
    if(show) {
        AlertDialog(
            onDismissRequest = { confirmViewModel.dismissDialog() },
            title = {Text(title)},
            text = {Text(text)},
            confirmButton = {
                Button({
                    confirmViewModel.onConfirm()
                }) {
                    Text("Ok")
                }
            }
        )
    }
}