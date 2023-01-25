package com.enigmacamp.mynews

import com.enigmacamp.mynews.di.DaggerNewsComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerNewsComponent.builder().build()
    }
}