package edu.towson.cosc435.aka.roots.data

import androidx.room.*
import edu.towson.cosc435.aka.roots.ui.objects.Photos

@Dao
interface PhotosDao{
    @Insert
    suspend fun addPhotos(photo: Photos)

    @Query("SELECT id, url FROM Photos")
    suspend fun getPhotos(): List<Photos>
}

@Database(entities = [Photos::class], version = 1, exportSchema = false)
abstract class PhotosDatabase: RoomDatabase() {
    abstract fun photoDao(): PhotosDao
}