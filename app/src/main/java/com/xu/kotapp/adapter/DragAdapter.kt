package com.xu.kotapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xu.kotapp.base.BaseViewHolder
import com.xu.kotapp.base.BaseViewModel
import com.xu.kotapp.base.ICustomView
import com.xu.kotapp.view.dragitemview.DragItemView

/**
 *  author : xujianbo
 *  date : 2021/4/14 2:41 下午
 *  description :
 */
class DragAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    lateinit var items: MutableList<BaseViewModel>

    fun setData(items: MutableList<BaseViewModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(DragItemView(parent.context) as ICustomView<BaseViewModel>)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}