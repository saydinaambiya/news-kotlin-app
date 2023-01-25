package com.enigmacamp.mynews.data.repository.newsSource

import com.enigmacamp.mynews.data.api.NewsSourceApi
import com.enigmacamp.mynews.data.model.Source
import javax.inject.Inject


class NewsSourceRemoteDataSourceImpl @Inject constructor(private val newsSourceApi: NewsSourceApi) :
    NewsSourceRemoteDataSource {
    override suspend fun getNewsSourcesByCategory(category: String): List<Source> {
        try {
            val response = newsSourceApi.getSource(category)
            if (response.isSuccessful) {
                return response.body()!!
            } else {
                throw Exception("Failed to get response")
            }
        } catch (e: java.net.ConnectException) {
            throw Exception("Server down")
        }
    }

    override suspend fun findNewsSourcesByCategoryAndTitle(
        category: String,
        title: String
    ): List<Source> {
        try {
            val response = newsSourceApi.getSourceByTitle(category, title)
            if (response.isSuccessful) {
                return response.body()!!
            } else {
                throw Exception("Failed to get response")
            }
        } catch (e: java.net.ConnectException) {
            throw Exception("Server down")
        }
    }

}