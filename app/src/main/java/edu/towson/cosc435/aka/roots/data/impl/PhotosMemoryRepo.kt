package edu.towson.cosc435.aka.roots.data.impl

import edu.towson.cosc435.aka.roots.data.repositories.IPhotoRepo
import edu.towson.cosc435.aka.roots.ui.objects.Photos

class PhotosMemoryRepo: IPhotoRepo
{
    private var _photos = listOf<Photos>()

    init
    {
        _photos = (0..4).map { i ->
            Photos(i, "url")
        }
    }
    override suspend fun getPhotos() : List<Photos>
    {
        return _photos
    }
}