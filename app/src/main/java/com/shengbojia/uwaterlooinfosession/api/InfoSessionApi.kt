package com.shengbojia.uwaterlooinfosession.api

import android.util.Log
import com.shengbojia.uwaterlooinfosession.model.InfoSession
import com.shengbojia.uwaterlooinfosession.util.API_KEY
import com.shengbojia.uwaterlooinfosession.util.BASE_URL
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface InfoSessionApi {

    @GET("/resources/infosessions.json")
    fun getInfoSessions(
        @Query("key") key: String = API_KEY
    ): Call<InfoSessionResponse>

    data class InfoSessionResponse(val data: List<InfoSession>)

    companion object {
        private const val TAG = "API"

        // Should be a safe call unless I wrote the url down wrong
        fun create(): InfoSessionApi = create(HttpUrl.parse(BASE_URL)!!)

        private fun create(httpUrl: HttpUrl): InfoSessionApi {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.d(TAG, it)
            })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(InfoSessionApi::class.java)

        }
    }
}