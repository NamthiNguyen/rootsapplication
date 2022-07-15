package edu.towson.cosc435.aka.roots.ui.screens

import TopBar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.towson.cosc435.aka.roots.ui.screens.nav.DrawerScreens
import edu.towson.cosc435.aka.roots.ui.theme.Green
import edu.towson.cosc435.aka.roots.ui.theme.Orange

@Composable
    fun Home(openDrawer: () -> Unit, vm:PhotosViewModel, navController: NavController) {
    val scrollState = rememberScrollState()
    val photos by vm.photos
        Column( /** Entire Home container*/
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp, 5.dp, 5.dp, 5.dp)
                .border(1.dp, color = Color.Black)

        ){
            TopBar(
                title = "Home",
                buttonIcon = Icons.Filled.Menu,
                onButtonClicked = { openDrawer() }
            )
            Column( /** This column holds everything displayed on the Home screen*/
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp, 5.dp, 5.dp, 5.dp)
                    .verticalScroll(scrollState)
            )
            {

                GalleryScroll(photo = photos, vm = vm)

                Column(
                    modifier = Modifier
                        .fillMaxSize()

                ){

                    Card (
                        shape = MaterialTheme.shapes.small,
                        backgroundColor = Color.LightGray,
                        modifier = Modifier
                            .padding(5.dp, 5.dp, 5.dp, 5.dp)
                            .fillMaxWidth(),
                        elevation = 8.dp
                    ) {
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Box(modifier = Modifier
                                .height(200.dp)
                                .width(220.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .padding(5.dp, 5.dp, 5.dp, 5.dp)
                                .background(Color.Gray)

                            ){
                                Text(
                                    text = "ROOTS Africa’s mission is to combat hunger and poverty by engaging students and connecting expertise to farming communities in Africa.",
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                        .padding(15.dp) ,
                                    color = MaterialTheme.colors.onSecondary,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Button(onClick = { navController.navigate(DrawerScreens.Join.route)},
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(120.dp)
                                    .padding(end = 5.dp)
                            ) {
                                Text(text = "Join")
                            }

                        }
                    }

                    Card (
                        shape = MaterialTheme.shapes.small,
                        backgroundColor = Color.LightGray,
                        modifier = Modifier
                            .padding(5.dp, 5.dp, 5.dp, 5.dp)
                            .fillMaxWidth(),
                        elevation = 8.dp
                            ) {
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                                ){
                            Button(onClick = { navController.navigate(DrawerScreens.Donate.route)},
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(120.dp)
                                    .padding(start = 7.dp)) {
                                Text(text = "Donate")
                            }

                            Box(modifier = Modifier
                                .height(200.dp)
                                .width(220.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .padding(5.dp, 5.dp, 5.dp, 5.dp)
                                .background(color = Color.Gray)
                            ){
                                Text(
                                    text = "A gift to ROOTs Africa can change the life of an African family forever by providing them with a meal not just for a day but for life.",
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                        .padding(15.dp) ,
                                    color = MaterialTheme.colors.onSecondary,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                    Card (
                        shape = MaterialTheme.shapes.small,
                        backgroundColor = Color.LightGray,
                        modifier = Modifier
                            .padding(5.dp, 5.dp, 5.dp, 5.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        elevation = 8.dp,
                    ) {
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Box(modifier = Modifier
                                .height(340.dp)
                                .fillMaxWidth()
                                .padding(5.dp, 5.dp, 5.dp, 5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.Gray)
                            ){
                                Column(
                                    modifier = Modifier,
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "ABOUT",
                                        modifier = Modifier
                                            .padding(top = 8.dp)
                                            .align(Alignment.CenterHorizontally),
                                            //.padding(15.dp),
                                        color = MaterialTheme.colors.onSecondary,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        //textAlign = TextAlign.Center
                                    )

                                    Divider()

                                    Text(
                                        text = "With the guidance of various faculty and staff at the Department of Agriculture and Natural Resources (AGNR) at the University of Maryland College Park, co-founders, Cedric Nwafor and Mandella Jones started ROOTS Africa as a student club. The Club launched in September 2017 and began communicating in real time weekly with eight students enrolled at the Liberian International Christian College (LICC). The students collaborated to address agricultural issues of sustainability and markets.",
                                        modifier = Modifier
                                            .padding(top = 8.dp)
                                            .align(Alignment.CenterHorizontally)
                                            .padding(horizontal = 15.dp),
                                        color = MaterialTheme.colors.onSecondary,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Column(modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .background(Green)) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp)
                                //.background(Green)
                        ){
                            Text(text = "7878 Diamondback Dr, College Park, MD 20742", color = Color.Black, fontWeight = FontWeight.Medium)
                            Text(text = "info@roots-africa.org", color = Color.Black, fontWeight = FontWeight.Medium)
                            Text(text = "+1 (240) 350-2325", color = Color.Black, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }
    }