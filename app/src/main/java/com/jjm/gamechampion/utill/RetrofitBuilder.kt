package com.jjm.gamechampion.utill

import android.util.Log
import com.jjm.gamechampion.BuildConfig
import com.jjm.gamechampion.network.RiotAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Interceptor
import okhttp3.Request


object RetrofitBuilder {
    var api: RiotAPI

    init {
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("X-Riot-Token", BuildConfig.API_KEY)
                .build()
            chain.proceed(newRequest)
        }.build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://kr.api.riotgames.com/") //https://developer.riotgames.com/docs/lol#_getting-started
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(RiotAPI::class.java)
    }


}
