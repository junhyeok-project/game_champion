package com.jjm.gamechampion.utill

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jjm.gamechampion.ui.ItemViewInfo
import com.jjm.gamechampion.ui.adapter.BindableRecyclerViewAdapter

@BindingAdapter("itemViewInfos")
fun bindItemViewInfos(recyclerView: RecyclerView, itemViewInfos: ArrayList<ItemViewInfo>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(itemViewInfos)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): BindableRecyclerViewAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is BindableRecyclerViewAdapter) {
        recyclerView.adapter as BindableRecyclerViewAdapter
    } else {
        val bindableRecyclerAdapter = BindableRecyclerViewAdapter()
        recyclerView.adapter = bindableRecyclerAdapter
        bindableRecyclerAdapter
    }
}
