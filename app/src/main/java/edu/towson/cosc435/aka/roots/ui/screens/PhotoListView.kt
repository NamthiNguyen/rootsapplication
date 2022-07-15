package edu.towson.cosc435.aka.roots.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import edu.towson.cosc435.aka.roots.ui.objects.Photos

/** Create scroll function*/
@Composable
fun GalleryScroll(
    photo: List<Photos>,
    vm: PhotosViewModel
){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            //.fillMaxHeight()
            .height(200.dp)
    ){
        itemsIndexed(photo){ index, photo ->
            Column{
                PhotoItem(photo)
            }
        }
    }
}

@Composable
fun PhotoItem(photo:Photos){
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        Log.d("TAG", photo.url)
        if(photo.url!= null) {
            val painter = rememberImagePainter(
                data = photo.url,
                builder = {
                    crossfade(true)
                },
            )
            Image(
                modifier = Modifier
                    .size(width = 250.dp, height = 350.dp)
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 5.dp, 5.dp)
                    .border(3.dp, color = Color.Black)
                    .height(250.dp),
                painter = painter,
                contentDescription = null
            )
        }
    }
}