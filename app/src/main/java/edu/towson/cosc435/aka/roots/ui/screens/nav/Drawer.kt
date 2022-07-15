package edu.towson.cosc435.aka.roots.ui.screens.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.towson.cosc435.aka.roots.ui.theme.ROOTSTheme
import edu.towson.cosc435.aka.roots.R

sealed class DrawerScreens(val title: String, val route: String) {
    object Home : DrawerScreens("Home", "home")
    object Donate : DrawerScreens("Donate", "donate")
    object Join : DrawerScreens( "Join", "join")
    object Splash : DrawerScreens("Splash", "splash")
}

private val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.Donate,
    DrawerScreens.Join,
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier
        .width(160.dp)
        .height(400.dp),
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.rootslogo),
            contentDescription = "App icon"
        )
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.clickable {
                    onDestinationClicked(screen.route)
                }
            )
        }
    }
}

@Preview
@Composable
fun DrawerPreview() {
    ROOTSTheme {
        Drawer{}
    }
}