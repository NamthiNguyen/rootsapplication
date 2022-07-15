package edu.towson.cosc435.aka.roots.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DonateViewModel : ViewModel() {
    private val _donation: MutableState<Double> = mutableStateOf(0.00)
    val donation: State<Double> = _donation
    private val _money: MutableState<Double> = mutableStateOf(0.00)
    val money: State<Double> = _money
    private val _name: MutableState<String> = mutableStateOf("")
    val name: State<String> = _name

    fun addName(name: String) {
        _name.value = name
    }
    fun addMoney(money: Double){
        _money.value = _money.value + money
    }
    fun giveMoney(money: Double){
        if(_money.value >= money){
            _money.value = _money.value - money
            _donation.value = _donation.value + money
        }
    }
}