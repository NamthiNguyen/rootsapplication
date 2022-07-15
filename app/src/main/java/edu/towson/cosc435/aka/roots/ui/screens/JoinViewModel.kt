package edu.towson.cosc435.aka.roots.ui.screens

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class JoinViewModel: ViewModel(){
    private val _name: MutableState<String> = mutableStateOf("")
    val name: State<String> = _name

    private val _selected: MutableState<String> = mutableStateOf("Male")
    val selected: State<String> = _selected

    private val _checked: MutableState<Boolean> = mutableStateOf( false)
    val checkedit: State<Boolean> = _checked

    private val _checked2: MutableState<Boolean> = mutableStateOf( false)
    val checkedit2: State<Boolean> = _checked2

    private val _checked3: MutableState<Boolean> = mutableStateOf( false)
    val checkedit3: State<Boolean> = _checked3

    private val _checked4: MutableState<Boolean> = mutableStateOf( false)
    val checkedit4: State<Boolean> = _checked4

    private val _checked5: MutableState<Boolean> = mutableStateOf( false)
    val checkedit5: State<Boolean> = _checked5

    private val _selecttype: MutableState<String> = mutableStateOf("volunteer")
    val selecttype: State<String> = _selecttype

    private val _titletype: MutableState<String> = mutableStateOf("Take Action")
    val titletype: State<String> = _titletype

    private val _lastname: MutableState<String> = mutableStateOf("")
    val lastname: State<String> = _lastname

    private val _email: MutableState<String> = mutableStateOf("")
    val email: State<String> = _email


    //event

    fun onNameChange(newString:String){
        _name.value=newString
    }
    fun onEmailChange(newString:String){
        _email.value=newString
    }
    fun onLastNameChange(newString:String){
        _lastname.value =newString
    }
    fun onselected(newString:String){
        _selected.value=newString
    }
    fun ontitlechange(newString:String){
        _titletype.value=newString
    }
    fun onselectedType(newString:String){
        _selecttype.value=newString
    }

    fun Icheckedit(accpet : Boolean){
        _checked.value = accpet

    }
    fun Icheckedit2(accpet2 : Boolean){
        _checked2.value = accpet2

    }
    fun Icheckedit3(accpet3 : Boolean){
        _checked3.value = accpet3

    }
    fun Icheckedit4(accpet4 : Boolean){
        _checked4.value = accpet4

    }
    fun Icheckedit5(accpet5 : Boolean){
        _checked5.value = accpet5

    }
}