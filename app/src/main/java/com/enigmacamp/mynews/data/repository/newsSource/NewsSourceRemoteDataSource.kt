package com.enigmacamp.mynews.data.repository.newsSource

import com.enigmacamp.mynews.data.model.Source

interface NewsSourceRemoteDataSource {
    suspend fun getNewsSourcesByCategory(category: String): List<Source>
    suspend fun findNewsSourcesByCategoryAndTitle(category: String, title: String): List<Source>
}