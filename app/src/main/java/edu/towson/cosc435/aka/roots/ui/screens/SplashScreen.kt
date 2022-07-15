package edu.towson.cosc435.aka.roots.ui.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import edu.towson.cosc435.aka.roots.R
import edu.towson.cosc435.aka.roots.ui.theme.Orange
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    val scale = remember{ Animatable(0f)}

    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.6f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        delay(800)
        navController.navigate("home"){
            popUpTo("splash"){
                inclusive = true
            }
        }
    }
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Orange),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(
                id = R.drawable.rootslogo),
                contentDescription = "Splash Logo")
        }
}