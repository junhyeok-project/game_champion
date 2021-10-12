package com.jjm.gamechampion.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jjm.gamechampion.ui.ItemViewInfo
import com.jjm.gamechampion.BR

class BindableRecyclerViewAdapter : RecyclerView.Adapter<BindableViewHolder>() {

    var ItemViewInfoList: List<ItemViewInfo> = emptyList()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?: 0,
            parent,
            false)
        return BindableViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val item = ItemViewInfoList[position]
        if (!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        return item.viewType
    }

    override fun getItemCount(): Int = ItemViewInfoList.size

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        holder.bind(ItemViewInfoList[position])
    }

    fun updateItems(items: List<ItemViewInfo>?) {
        ItemViewInfoList = items ?: emptyList()
        notifyDataSetChanged()
    }
}

class BindableViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemViewModel: ItemViewInfo) {
        binding.setVariable(BR.itemViewInfo, itemViewModel)
    }
}