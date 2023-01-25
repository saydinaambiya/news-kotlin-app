package com.enigmacamp.mynews.data.repository.newsSource

import com.enigmacamp.mynews.data.model.Source
import javax.inject.Inject

class NewsSourceRepositoryImpl @Inject constructor(private val newsSourceRemoteDataSource: NewsSourceRemoteDataSource) :
    NewsSourceRepository {

    override suspend fun getNewsSourceByCategory(category: String): Result<List<Source>> {
        return try {
            val sources = newsSourceRemoteDataSource.getNewsSourcesByCategory(category)
            Result.success(sources)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun findNewsSourceByCategoryAndTitle(
        category: String,
        title: String
    ): Result<List<Source>> {
        return try {
            val sources =
                newsSourceRemoteDataSource.findNewsSourcesByCategoryAndTitle(category, title)
            Result.success(sources)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}