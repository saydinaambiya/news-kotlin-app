package com.enigmacamp.mynews.data.repository.newsSource

import com.enigmacamp.mynews.data.model.Source

interface NewsSourceRepository {
    suspend fun getNewsSourceByCategory(category: String): Result<List<Source>>
    suspend fun findNewsSourceByCategoryAndTitle(
        category: String,
        title: String
    ): Result<List<Source>>
}