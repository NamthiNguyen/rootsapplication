package edu.towson.cosc435.aka.roots

import androidx.compose.ui.ExperimentalComposeUiApi
import edu.towson.cosc435.aka.roots.ui.screens.JoinViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Test


class JoinTextFeilds

{
    @ExperimentalCoroutinesApi
    @Test
    fun checkName(){
        val vm = JoinViewModel()
        vm.onNameChange("Namthi")
        Assert.assertEquals("Namthi", vm.name.value)



    }
    @ExperimentalCoroutinesApi
    @Test
    fun checklast(){
        val vm = JoinViewModel()
        vm.onLastNameChange("Nguyen")
        Assert.assertEquals("Nguyen", vm.lastname.value)



    }
    @ExperimentalCoroutinesApi
    @Test
    fun checkemail()
    {
        val vm = JoinViewModel()
        vm.onEmailChange("somethingRandom@gmail.com")
        Assert.assertEquals("somethingRandom@gmail.com", vm.email.value)


    }
    @ExperimentalCoroutinesApi
    @Test
    fun ontitlechange()
    {
        val vm = JoinViewModel()
        vm.ontitlechange("TeamSignup")
        Assert.assertEquals("TeamSignup", vm.titletype.value)


    }
    @ExperimentalCoroutinesApi
    @Test
    fun ontitlechange2()
    {
        val vm = JoinViewModel()
        vm.ontitlechange("Vounteer")
        Assert.assertEquals("Vounteer", vm.titletype.value)


    }

    }
