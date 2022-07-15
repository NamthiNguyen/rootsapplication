package edu.towson.cosc435.aka.roots.ui.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Photos(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "url")
    val url: String
    //val thumbnailUrl: String
)
