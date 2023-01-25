package com.enigmacamp.mynews.di

import com.enigmacamp.mynews.BuildConfig
import com.enigmacamp.mynews.data.api.NewsSourceApi
import com.enigmacamp.mynews.data.api.interceptor.NewsApiKeyInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class CoreModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(newsApiKeyInterceptor: NewsApiKeyInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(newsApiKeyInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsSourceApi(retrofit: Retrofit): NewsSourceApi {
        return retrofit.create(NewsSourceApi::class.java)
    }
}