package me.dio.urlshortener.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "url")
data class ShortenedUrlModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "original_url")
    val original: String,
    @ColumnInfo(name = "shortened_url")
    val url: String,
)
