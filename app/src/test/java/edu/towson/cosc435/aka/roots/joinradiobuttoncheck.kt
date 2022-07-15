package edu.towson.cosc435.aka.roots
import androidx.compose.ui.ExperimentalComposeUiApi
import edu.towson.cosc435.aka.roots.ui.screens.JoinViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Test


class joinradiobuttoncheck
{

    @ExperimentalCoroutinesApi
    @Test
    fun checkgenderbutton()
    {
        val vm = JoinViewModel()
        vm.onselected("Male")
        Assert.assertEquals("Male", vm.selected.value)

    }
    @ExperimentalCoroutinesApi
    @Test
    fun checkgenderbutton2()
    {
        val vm = JoinViewModel()
        vm.onselected("Female")
        Assert.assertEquals("Female", vm.selected.value)

    }
    @ExperimentalCoroutinesApi
    @Test
    fun checkbutton1()
    {
        val vm = JoinViewModel()
        vm.Icheckedit(false)
        Assert.assertEquals(false, vm.checkedit.value)

    }
    @ExperimentalCoroutinesApi
    @Test
    fun checkbutton2()
    {
        val vm = JoinViewModel()
        vm.Icheckedit2(false)
        Assert.assertEquals(false, vm.checkedit2.value)

    }
    @ExperimentalCoroutinesApi
    @Test
    fun checkbutton3()
    {
        val vm = JoinViewModel()
        vm.Icheckedit3(false)
        Assert.assertEquals(false, vm.checkedit3.value)

    }
    @ExperimentalCoroutinesApi
    @Test
    fun checkbutton4()
    {
        val vm = JoinViewModel()
        vm.Icheckedit4(false)
        Assert.assertEquals(false, vm.checkedit4.value)

    }
    @ExperimentalCoroutinesApi
    @Test
    fun checkbutton5()
    {
        val vm = JoinViewModel()
        vm.Icheckedit5(true)
        Assert.assertEquals(true, vm.checkedit5.value)

    }


}
