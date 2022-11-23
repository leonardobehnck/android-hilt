package me.dio.urlshortener.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.room.Room
import me.dio.urlshortener.data.AppDatabase
import me.dio.urlshortener.data.datasource.impl.UrlShortenerLocalDataSource
import me.dio.urlshortener.data.datasource.impl.UrlShortenerRemoteDataSource
import me.dio.urlshortener.data.net.HideUriService
import me.dio.urlshortener.data.net.RetrofitServiceProvider
import me.dio.urlshortener.data.repository.UrlsRepositoryImpl

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val context = extras[APPLICATION_KEY]!!

        val db = Room.databaseBuilder(context, AppDatabase::class.java, "app.db").build()
        val service = RetrofitServiceProvider.create<HideUriService>()

        val repository = UrlsRepositoryImpl(
            localDataSource = UrlShortenerLocalDataSource(dao = db.shortenedUrlDao()),
            remoteDataSource = UrlShortenerRemoteDataSource(service),
        )

        return UrlsViewModel(repository = repository) as T
    }
}