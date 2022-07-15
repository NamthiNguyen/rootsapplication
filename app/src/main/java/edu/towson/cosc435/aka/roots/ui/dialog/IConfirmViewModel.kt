package edu.towson.cosc435.aka.roots.ui.dialog

import androidx.compose.runtime.State

interface IConfirmViewModel {

    val showConfirmDialog: State<Boolean>
    fun showConfirm(onConfirm: () -> Unit)
    fun onConfirm()
    fun dismissDialog()

}