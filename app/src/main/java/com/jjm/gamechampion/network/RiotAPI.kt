package com.jjm.gamechampion.network

import com.jjm.gamechampion.vo.SummonerInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotAPI {
    @GET("lol/summoner/v4/summoners/by-name/{id}")
    fun getSummoner(@Path("id") id: String): Call<SummonerInfo>
}
