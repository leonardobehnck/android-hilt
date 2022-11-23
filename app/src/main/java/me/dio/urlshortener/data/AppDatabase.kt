package me.dio.urlshortener.data

import androidx.room.Database
import androidx.room.RoomDatabase
import me.dio.urlshortener.data.dao.ShortenedUrlDao
import me.dio.urlshortener.data.model.ShortenedUrlModel

@Database(entities = [ShortenedUrlModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shortenedUrlDao(): ShortenedUrlDao
}