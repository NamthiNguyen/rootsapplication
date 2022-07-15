package edu.towson.cosc435.aka.roots.ui.screens

import TopBar
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.cosc435.aka.roots.ui.dialog.ConfirmDialog
import edu.towson.cosc435.aka.roots.ui.dialog.ConfirmViewModel
import edu.towson.cosc435.aka.roots.ui.dialog.InsufficientDialog
import edu.towson.cosc435.aka.roots.ui.viewmodel.DonateViewModel

@Composable
    fun Donate(
    openDrawer: () -> Unit,
    donateViewModel: DonateViewModel
) {
    val confirmViewModel: ConfirmViewModel = viewModel()
    val insufficientFunds: ConfirmViewModel = viewModel()
    var don by remember {mutableStateOf(0.00)}
    var name by remember {mutableStateOf("")}
    var state by remember {mutableStateOf(false)}
    val scrollState = rememberScrollState()
    Column( /** Entire Donate container*/
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp, 5.dp, 5.dp, 5.dp)
            .border(1.dp, color = Color.Black)
    ){
        Column( /** This column holds everything displayed on the Donate screen*/
            modifier = Modifier
                .fillMaxSize())
        {
            TopBar(
                title = "Donate",
                buttonIcon = Icons.Filled.Menu,
                onButtonClicked = { openDrawer() }
            )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Spacer(modifier = Modifier.width(50.dp))

                    Text(text = "Donate", style = MaterialTheme.typography.h4)

                    if(state) {
                        ConfirmDialog(
                            title = "Confirm",
                            text = "Are you sure you want to donate $$don $name",
                            confirmViewModel = confirmViewModel
                        )
                    }else{
                        InsufficientDialog(
                            title = "Confirm",
                            text = "Insufficient Funds!",
                            confirmViewModel = insufficientFunds
                        )
                    }

                    if(state) {
                        Text(text = "Thank you for the $${donateViewModel.donation.value} $name")
                    }

                    Text(text = "You have $${donateViewModel.money.value}")

                    OutlinedTextField(
                        value = name,
                        onValueChange = {name = it},
                        label = { Text("Name") }
                    )

                    Button(onClick = {
                        if(name != ""){
                            donateViewModel.addName(name)
                        }
                        name = donateViewModel.name.value
                        don = 100.00

                        if(donateViewModel.money.value > don || donateViewModel.money.value == don){
                            state = true
                            confirmViewModel.showConfirm(onConfirm={donateViewModel.giveMoney(100.00)})
                        }else{
                            state = false
                            insufficientFunds.showConfirm {
                            }
                        }
                    },
                        modifier = Modifier.padding(top = 8.dp)) {
                        Text("Donate $100")
                    }

                    Button(onClick = {
                        if(name != ""){
                            donateViewModel.addName(name)
                        }
                        name = donateViewModel.name.value
                        don = 50.00
                        if(donateViewModel.money.value > don || donateViewModel.money.value == don){
                            state = true
                            confirmViewModel.showConfirm(onConfirm={donateViewModel.giveMoney(50.00)})
                        }else{
                            state = false
                            insufficientFunds.showConfirm {
                            }
                        }
                    },
                        modifier = Modifier.padding(top = 5.dp)) {
                        Text("Donate $50")
                    }

                    Button(onClick = {
                        if(name != ""){
                            donateViewModel.addName(name)
                        }
                        name = donateViewModel.name.value
                        don = 10.00
                        if(donateViewModel.money.value > don || donateViewModel.money.value == don){
                            state = true
                            confirmViewModel.showConfirm(onConfirm={donateViewModel.giveMoney(10.00)})
                        }else{
                            state = false
                            insufficientFunds.showConfirm {
                            }
                        }

                    },
                        modifier = Modifier.padding(top = 5.dp)) {
                        Text("Donate $10")
                    }

                    Button(onClick = {
                        donateViewModel.addMoney(100.00)
                    },
                        modifier = Modifier.padding(top = 5.dp)) {
                        Text("Get $100")
                    }

                }
            }
        }
    }