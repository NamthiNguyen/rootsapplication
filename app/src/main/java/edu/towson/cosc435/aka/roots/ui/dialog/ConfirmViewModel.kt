package edu.towson.cosc435.aka.roots.ui.dialog

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ConfirmViewModel : ViewModel(), IConfirmViewModel {

    private val _showConfirmDialog: MutableState<Boolean> = mutableStateOf(false)
    override val showConfirmDialog: State<Boolean> = _showConfirmDialog
    private var _onConfirm: (() -> Unit)? = null

    override fun showConfirm(onConfirm: () -> Unit) {
        _showConfirmDialog.value = true
        _onConfirm = onConfirm
    }

    override fun onConfirm() {
        _onConfirm?.invoke()
        dismissDialog()
    }

    override fun dismissDialog() {
        _showConfirmDialog.value = false
    }

}