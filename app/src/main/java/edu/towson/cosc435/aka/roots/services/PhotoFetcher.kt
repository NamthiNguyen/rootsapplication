package edu.towson.cosc435.aka.roots.services

import android.app.Application
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.towson.cosc435.aka.roots.ui.objects.Photos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

interface IPhotosFetcher {
    suspend fun fetchPhotos(): List<Photos>
}

class PhotosFetcher(private val app: Application) : IPhotosFetcher {
    private val URL = "https://my-json-server.typicode.com/namthi267/rootsphoto/photo"
    //private val URL = "https://jsonplaceholder.typicode.com/photos/"
    override suspend fun fetchPhotos() : List<Photos>
    {
        Log.d("TAG", "Fetching")
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(URL)
                .get()
                .build()
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            if (json != null) {
                val gson = Gson()
                val listTypeToken = object : TypeToken<List<Photos>>() {}
                val listType = listTypeToken.type
                val photos = gson.fromJson <List<Photos>>(json, listType)
                photos
            } else {
                listOf()
            }
        }
    }
}