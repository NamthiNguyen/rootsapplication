package edu.towson.cosc435.aka.roots.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import TopBar
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import edu.towson.cosc435.aka.roots.R
import androidx.navigation.NavController
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import edu.towson.cosc435.aka.roots.ui.screens.nav.DrawerScreens

import edu.towson.cosc435.aka.roots.ui.viewmodel.JoinWorker


private lateinit var worker: WorkManager
@Composable
    fun Join(openDrawer: () -> Unit, JoinViewModel: JoinViewModel, navController:NavController) {
    worker= WorkManager.getInstance()
    val request = OneTimeWorkRequest.Builder(JoinWorker::class.java).build()
    var title = JoinViewModel.titletype.value
    val scrollState = rememberScrollState()
    Column( /** Entire Join container*/
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp, 5.dp, 5.dp, 5.dp)
            .border(1.dp, color = Color.Black)
    ){

        Column( /** This column holds everything displayed on the Join screen*/
            modifier = Modifier
                .fillMaxSize()
                )
        {
            TopBar(
                title = "Join",
                buttonIcon = Icons.Filled.Menu,
                onButtonClicked = { openDrawer() }
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(top=20.dp))

                Text(text = title, fontSize = (40.sp))

                Row(horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Row(modifier = Modifier.width(149.dp).padding(10.dp)) {  OutlinedTextField(
                            value = JoinViewModel.name.value,
                            onValueChange = {JoinViewModel.onNameChange(it)},
                            label = { Text("Name") })
                        }
                    }
                    Column {
                        Row(Modifier.width(149.dp).padding(10.dp)) {
                        OutlinedTextField(
                            value = JoinViewModel.lastname.value,
                            onValueChange = {JoinViewModel.onLastNameChange(it)},
                            label = { Text(" LastName") })
                    }  }
                    }

                Row {
                    OutlinedTextField(
                        value = JoinViewModel.email.value,
                        onValueChange = {JoinViewModel.onEmailChange(it)},
                        label = { Text("Email") })
                }

               pickGender(JoinViewModel = JoinViewModel)

                Row(
                    modifier = Modifier
                        .padding(10.dp),

                    ) {
                    Text("Type: ")
                    Row {
                        RadioButton(selected = JoinViewModel.selecttype.value == "volunteer" , onClick = {
                            JoinViewModel.onselectedType("volunteer")
                            JoinViewModel.ontitlechange("Volunteer Sigh up")} )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(stringResource(id = R.string.Volunteer))
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Row {
                        RadioButton(selected = JoinViewModel.selecttype.value == "team_member" , onClick = {
                            JoinViewModel.onselectedType("team_member")
                            JoinViewModel.ontitlechange("Team Member Sigh up")})
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(stringResource(id = R.string.Team_Memeber))
                        Spacer(modifier = Modifier.width(4.dp))
                    }

                }
                Row(modifier =Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically){
                    Text(text ="Branch", fontSize = (25.sp))
                    Spacer(modifier = Modifier.width(10.dp).height(10.dp))
                }
                Column() {

                    volunteerListAppear(JoinViewModel = JoinViewModel )
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 50.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Button(onClick = { navController.navigate(DrawerScreens.Home.route)
                        worker.enqueue(request)
                        JoinViewModel.onselectedType("")
                        JoinViewModel.onNameChange("")
                        JoinViewModel.onLastNameChange("")
                        JoinViewModel.onselected("")
                        JoinViewModel.Icheckedit5(false)
                        JoinViewModel.Icheckedit4(false)
                        JoinViewModel.Icheckedit3(false)
                        JoinViewModel.Icheckedit2(false)
                        JoinViewModel.Icheckedit(false)}, ) {
                        Text(text = "Signup")

                    }

                }


            }

        }
    }
}



@Composable
fun pickGender(JoinViewModel : JoinViewModel){

    Row(
        modifier = Modifier
            .padding(30.dp),

        ) {
        Text("Gender: ")
        Row {
            RadioButton(selected = JoinViewModel.selected.value == "Male"   , onClick = {JoinViewModel.onselected("Male")} )
            Spacer(modifier = Modifier.width(4.dp))
            Text(stringResource(id = R.string.Male))
            Spacer(modifier = Modifier.width(4.dp))
        }
        Spacer(modifier = Modifier.width(4.dp))
        Row {
            RadioButton(selected = JoinViewModel.selected.value == "Female" , onClick = { JoinViewModel.onselected("Female")} )
            Spacer(modifier = Modifier.width(4.dp))
            Text(stringResource(id = R.string.Female))
            Spacer(modifier = Modifier.width(4.dp))
        }
        Spacer(modifier = Modifier.width(4.dp))
        Row {
            RadioButton(JoinViewModel.selected.value == "Other"  , onClick = { JoinViewModel.onselected("Other")  } )
            Spacer(modifier = Modifier.width(4.dp))
            Text(stringResource(id = R.string.other))
            Spacer(modifier = Modifier.width(4.dp))
        }


    }

}


@Composable
fun volunteerListAppear(JoinViewModel : JoinViewModel){

    Row {
        Checkbox(checked =   JoinViewModel.checkedit5.value, onCheckedChange = {  JoinViewModel.Icheckedit5(it) }, modifier = Modifier.semantics { contentDescription = "College Park"  },)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "University of Maryland, College Park")
    }
    Row {
        Checkbox(checked =   JoinViewModel.checkedit4.value, onCheckedChange = {  JoinViewModel.Icheckedit4(it) },)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Liberian International Christian College")
    }
    Row {
        Checkbox(checked =   JoinViewModel.checkedit3.value, onCheckedChange = {  JoinViewModel.Icheckedit3(it) },)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "University of Liberia")
    }
    Row {

        Checkbox(checked =   JoinViewModel.checkedit2.value, onCheckedChange = {  JoinViewModel.Icheckedit2(it) },)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Uganda Martyrs University")
    }
    Row {
        Checkbox(checked = JoinViewModel.checkedit.value, onCheckedChange = {  JoinViewModel.Icheckedit(it) },)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Bukalasa University")
    }
}