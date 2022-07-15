package edu.towson.cosc435.aka.roots.ui.screens

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.cosc435.aka.roots.data.impl.PhotoDbRepo
import edu.towson.cosc435.aka.roots.data.repositories.IPhotoRepo
import edu.towson.cosc435.aka.roots.services.PhotoApi
import edu.towson.cosc435.aka.roots.services.PhotosFetcher
import edu.towson.cosc435.aka.roots.ui.objects.Photos
import kotlinx.coroutines.launch

class PhotosViewModel(app:Application): AndroidViewModel(app)
{

    private val _photos : MutableState<List<Photos>> = mutableStateOf(listOf())
    val photos: State<List<Photos>> = _photos
    private val _repository : IPhotoRepo = PhotoApi(PhotoDbRepo(app), PhotosFetcher(app))

    init{
        Log.d("TAG", "View Model Initialized check passed")
        viewModelScope.launch {
            _photos.value= _repository.getPhotos()
        }
    }
}