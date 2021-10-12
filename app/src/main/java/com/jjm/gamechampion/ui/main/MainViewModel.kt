package com.jjm.gamechampion.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjm.gamechampion.ui.ItemViewInfo
import com.jjm.gamechampion.ui.SummonerViewInfo
import com.jjm.gamechampion.utill.RetrofitBuilder
import com.jjm.gamechampion.vo.SummonerInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {


    var liveItems = MutableLiveData<ArrayList<ItemViewInfo>>()
    var items: ArrayList<ItemViewInfo> = ArrayList()

    init{
        add(SummonerViewInfo("test", "testValue"))
    }
    fun add(item: ItemViewInfo) {
        items.add(item)
        liveItems.postValue(items)
    }

    fun remove(item: ItemViewInfo) {
        items.remove(item)
        liveItems.value = items
    }

    fun callApi(summonerName: String) {
        RetrofitBuilder.api.getSummoner(summonerName).enqueue(object : Callback<SummonerInfo> {
            override fun onResponse(call: Call<SummonerInfo>, response: Response<SummonerInfo>) {
                val body = response.body()
                Log.e("response1", call.request().toString())
                Log.e("response1", call.request().headers().toString())
                Log.e("response2", response.toString())
                Log.d("response", "$body ")
                body?.let { summonerInfo ->
                    add(SummonerViewInfo("id", summonerInfo.id))
                    add(SummonerViewInfo("accountId", summonerInfo.accountId))
                    add(SummonerViewInfo("puuid", summonerInfo.puuid))
                    add(SummonerViewInfo("name", summonerInfo.name))
                    add(SummonerViewInfo("profileIconId",summonerInfo.profileIconId.toString()))
                    add(SummonerViewInfo("revisionDate", summonerInfo.revisionDate.toString()))
                    add(SummonerViewInfo("summonerLevel", summonerInfo.summonerLevel.toString()))
                }
            }

            override fun onFailure(call: Call<SummonerInfo>, t: Throwable) {
                Log.d("error", t.message.toString())
            }
        })
    }
}