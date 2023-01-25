package com.enigmacamp.mynews.data.api

import com.enigmacamp.mynews.data.model.Source
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsSourceApi {

    @GET("sources")
    suspend fun getSource(
        @Query("category") category: String
    ): Response<List<Source>>


    @GET("sources")
    suspend fun getSourceByTitle(
        @Query("category") category: String,
        @Query("title") title: String
    ): Response<List<Source>>
}