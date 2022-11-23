package me.dio.urlshortener.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import me.dio.urlshortener.data.model.ShortenedUrlModel

@Dao
interface ShortenedUrlDao {
    @Insert
    fun insert(url: ShortenedUrlModel)

    @Query("SELECT * FROM url")
    fun getAll(): Flow<List<ShortenedUrlModel>>
}