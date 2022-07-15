package edu.towson.cosc435.aka.roots

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import edu.towson.cosc435.aka.roots.ui.theme.ROOTSTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.towson.cosc435.aka.roots.ui.screens.*
import kotlinx.coroutines.launch
import edu.towson.cosc435.aka.roots.ui.screens.nav.DrawerScreens
import edu.towson.cosc435.aka.roots.ui.screens.nav.Drawer
import edu.towson.cosc435.aka.roots.ui.viewmodel.DonateViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ROOTSTheme {
                AppMainScreen()
                }
            }
        }
}

    @Composable
    fun AppMainScreen() {
        val navController = rememberNavController()
        val donateViewModel: DonateViewModel = viewModel()
        val homeGalleryVM: PhotosViewModel = viewModel()
        val joinScreenViewModel: JoinViewModel = viewModel()
        Surface(color = MaterialTheme.colors.background) {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val openDrawer = {
                scope.launch {
                    drawerState.open()
                }
            }
            ModalDrawer(
                drawerState = drawerState,
                gesturesEnabled = drawerState.isOpen,
                drawerContent = {
                    Drawer(
                        onDestinationClicked = { route ->
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(route) {
                                popUpTo = navController.graph.startDestinationId
                                launchSingleTop = true
                            }
                        }
                    )
                }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = DrawerScreens.Splash.route
                ) {
                    composable(DrawerScreens.Splash.route) {
                        SplashScreen(
                            navController
                        )
                    }
                    composable(DrawerScreens.Home.route) {
                         Home(
                            openDrawer = {
                                openDrawer()
                            },
                             homeGalleryVM,
                             navController
                        )
                    }
                    composable(DrawerScreens.Donate.route) {
                        Donate(
                            openDrawer = {
                                openDrawer()
                            },
                            donateViewModel
                        )
                    }
                    composable(DrawerScreens.Join.route) {
                        Join(
                            JoinViewModel = joinScreenViewModel,
                            navController = navController,
                            openDrawer = {
                                openDrawer()
                            }

                        )
                    }
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun SplashScreen() {
    ROOTSTheme {
        AppMainScreen()
    }
}