package com.project.mapgames

import android.app.Application
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.project.mapgames.model.api.DVapi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit.Builder

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        apiDV = Builder()
            .baseUrl("https://mtreload.ru/")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(
                Json
                    .asConverterFactory(MediaType.get("application/json"))
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(DVapi::class.java)
    }

    companion object {
        lateinit var instance: Application
        lateinit var apiDV: DVapi
    }
}
