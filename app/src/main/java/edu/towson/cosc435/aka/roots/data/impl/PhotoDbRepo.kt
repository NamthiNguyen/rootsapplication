package edu.towson.cosc435.aka.roots.data.impl

import android.app.Application
import androidx.room.Room
import edu.towson.cosc435.aka.roots.data.PhotosDatabase
import edu.towson.cosc435.aka.roots.data.repositories.IPhotoRepo
import edu.towson.cosc435.aka.roots.ui.objects.Photos

class PhotoDbRepo(app : Application) : IPhotoRepo
{

    private val database : PhotosDatabase = Room.databaseBuilder(
        app,
        PhotosDatabase::class.java,
        "Gallery.db"
    ).fallbackToDestructiveMigration().build()
    private var _photos : List<Photos> = listOf()

    override suspend fun getPhotos() : List<Photos>
    {
        return database.photoDao().getPhotos()
    }

    suspend fun addPhotos(photos: Photos) {
        return database.photoDao().addPhotos(photos)
    }
}