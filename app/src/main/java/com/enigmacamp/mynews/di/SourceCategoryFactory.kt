package com.enigmacamp.mynews.di

import com.enigmacamp.mynews.presentation.newssource.NewsSourceViewModel
import dagger.assisted.AssistedFactory

@AssistedFactory
interface SourceCategoryFactory {
    fun create(category: String): NewsSourceViewModel
}