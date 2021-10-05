package com.jjm.gamechampion.utill

import com.jjm.gamechampion.network.RiotAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    val retrofit = Retrofit.Builder()
        .baseUrl("kr.api.riotgames.com/") //https://developer.riotgames.com/docs/lol#_getting-started
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val githubApi = retrofit.create(RiotAPI::class.java)
}