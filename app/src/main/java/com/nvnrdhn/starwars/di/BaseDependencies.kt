package com.nvnrdhn.starwars.di

import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseDependencies {
    private const val BASE_URL = "https://swapi.dev/api/"

    val networkModule = module {
        single { Gson() }

        single { GsonConverterFactory.create(get()) }

        single { OkHttpClient.Builder().build() }

        single { providesRetrofit(get(), get()) }
    }

    private fun providesRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
}