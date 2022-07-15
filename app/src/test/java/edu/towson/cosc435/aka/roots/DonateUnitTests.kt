package edu.towson.cosc435.aka.roots

import edu.towson.cosc435.aka.roots.ui.screens.JoinViewModel
import edu.towson.cosc435.aka.roots.ui.viewmodel.DonateViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Test

class DonateUnitTests
{
    @ExperimentalCoroutinesApi
    @Test
    fun checkAddName()
    {
        val vm = DonateViewModel()
        vm.addName("Jacob")
        Assert.assertEquals("Jacob", vm.name.value)

    }
    @ExperimentalCoroutinesApi
    @Test
    fun checkAddMoney()
    {
        val vm = DonateViewModel()
        vm.addMoney(100.00)
        val what = (100.00 == vm.money.value)
        Assert.assertEquals(true, what)

    }
    @ExperimentalCoroutinesApi
    @Test
    fun checkGiveMoney()
    {
        val vm = DonateViewModel()
        vm.addMoney(100.00)
        vm.giveMoney(100.00)
        val what = (100.00 == vm.donation.value)
        Assert.assertEquals(true, what)

    }
}