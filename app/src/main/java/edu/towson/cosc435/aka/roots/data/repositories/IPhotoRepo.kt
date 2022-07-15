package edu.towson.cosc435.aka.roots.data.repositories

import edu.towson.cosc435.aka.roots.ui.objects.Photos

interface IPhotoRepo {
    suspend fun getPhotos(): List<Photos>
}