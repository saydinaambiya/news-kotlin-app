package com.enigmacamp.mynews.di

import com.enigmacamp.mynews.data.repository.newsSource.NewsSourceRemoteDataSource
import com.enigmacamp.mynews.data.repository.newsSource.NewsSourceRemoteDataSourceImpl
import com.enigmacamp.mynews.data.repository.newsSource.NewsSourceRepository
import com.enigmacamp.mynews.data.repository.newsSource.NewsSourceRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class NewsSourceModule {
    @Binds
    abstract fun bindsNewsSourceRemoteDataSource(newsSourceRemoteDataSourceImpl: NewsSourceRemoteDataSourceImpl): NewsSourceRemoteDataSource

    @Binds
    abstract fun bindsNewsSourceRepository(newsSourceRepositoryImpl: NewsSourceRepositoryImpl): NewsSourceRepository
}