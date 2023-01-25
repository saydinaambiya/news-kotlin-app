package com.enigmacamp.mynews.di

import com.enigmacamp.mynews.presentation.article.ArticleActivity
import com.enigmacamp.mynews.presentation.category.MainActivity
import com.enigmacamp.mynews.presentation.newssource.NewsSourceActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeArticleActivity(): ArticleActivity

    @ContributesAndroidInjector
    abstract fun contributeNewsSourceActivity(): NewsSourceActivity
}