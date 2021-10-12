package com.jjm.gamechampion.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jjm.gamechampion.BuildConfig
import com.jjm.gamechampion.utill.RetrofitBuilder
import com.jjm.gamechampion.vo.SummonerInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    fun callApi() {

        RetrofitBuilder.api.getSummoner("트위니 트위치").enqueue(object : Callback<SummonerInfo> {
            override fun onResponse(call: Call<SummonerInfo>, response: Response<SummonerInfo>) {
                val body = response.body()
                Log.e("response1", call.request().toString())
                Log.e("response1", call.request().headers().toString())
                Log.e("response2", response.toString())
                Log.d("response", "$body ")
            }

            override fun onFailure(call: Call<SummonerInfo>, t: Throwable) {
                Log.d("error", t.message.toString())
            }
        })
    }
}