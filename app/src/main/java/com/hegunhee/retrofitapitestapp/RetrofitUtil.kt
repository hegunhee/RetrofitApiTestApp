package com.hegunhee.retrofitapitestapp

import com.google.gson.internal.GsonBuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitUtil {
    val getApi by lazy { getApiRetrofit().create(ApiService::class.java) }

    fun getApiRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://swopenapi.seoul.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildOkHttpClient())
            .build()


    private fun buildOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }
}