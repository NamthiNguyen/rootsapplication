package edu.towson.cosc435.aka.roots.services

import edu.towson.cosc435.aka.roots.data.impl.PhotoDbRepo
import edu.towson.cosc435.aka.roots.data.repositories.IPhotoRepo
import edu.towson.cosc435.aka.roots.ui.objects.Photos

class PhotoApi(
    private val database: PhotoDbRepo,
    private val fetcher: IPhotosFetcher): IPhotoRepo{
    override suspend fun getPhotos() : List<Photos>
    {
        if(database.getPhotos().isEmpty()){
            val photos = fetcher.fetchPhotos()
            for(photo in photos){
                database.addPhotos(photo)
            }
        }
        return database.getPhotos()
    }

    suspend fun addPhotos(photos: Photos) {
        database.addPhotos(photos )
    }

}
