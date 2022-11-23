package me.dio.urlshortener.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.dio.urlshortener.data.datasource.UrlShortenerDataSource
import me.dio.urlshortener.data.datasource.impl.UrlShortenerLocalDataSource
import me.dio.urlshortener.data.datasource.impl.UrlShortenerRemoteDataSource
import me.dio.urlshortener.data.repository.UrlsRepositoryImpl
import me.dio.urlshortener.domain.UrlsRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun provideUrlsRepository(repository: UrlsRepositoryImpl): UrlsRepository

    @Binds
    fun provideUrlShortenerLocalDataSource(
        dataSource: UrlShortenerLocalDataSource
    ): UrlShortenerDataSource.Local

    @Binds
    fun provideUrlShortenerRemoteDataSource(
        dataSource: UrlShortenerRemoteDataSource
    ): UrlShortenerDataSource.Remote
}