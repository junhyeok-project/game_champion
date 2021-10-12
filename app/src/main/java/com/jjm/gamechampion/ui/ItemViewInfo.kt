package com.jjm.gamechampion.ui

import androidx.annotation.LayoutRes
import com.jjm.gamechampion.R

interface ItemViewInfo {
    @get:LayoutRes
    val layoutId: Int
    val viewType: Int
        get() = 0
}

enum class ItemInfoType(val value: Int) {
    Summoner(1)
}

class SummonerViewInfo(val key: String,val value: String) : ItemViewInfo {
    override val layoutId: Int = R.layout.item_summoner
    override val viewType: Int = ItemInfoType.Summoner.value
}
