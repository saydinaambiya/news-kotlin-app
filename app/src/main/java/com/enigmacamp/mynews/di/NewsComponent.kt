package com.enigmacamp.mynews.di

import com.enigmacamp.mynews.BaseApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivitiesModule::class, CoreModule::class, NewsSourceModule::class])
interface NewsComponent : AndroidInjector<BaseApplication> {
}