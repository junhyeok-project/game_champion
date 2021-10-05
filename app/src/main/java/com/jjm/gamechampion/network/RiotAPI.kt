package com.jjm.gamechampion.network

import com.jjm.gamechampion.vo.SummonerInfo
import retrofit2.Call
import retrofit2.http.GET

interface RiotAPI {
    @GET("lol/summoner/v4/summoners/by-name/")
    fun getGithubInfo(): Call<SummonerInfo>
}
