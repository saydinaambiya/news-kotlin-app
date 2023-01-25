package com.enigmacamp.mynews.data.api.interceptor

import com.enigmacamp.mynews.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NewsApiKeyInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()
        val newHttpUrl =
            originalHttpUrl.newBuilder().addQueryParameter("apiKey", BuildConfig.API_KEY).build()
        val newRequest = originalRequest.newBuilder().url(newHttpUrl).build()
        return chain.proceed(newRequest)
    }
}