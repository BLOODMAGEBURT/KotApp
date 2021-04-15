package com.xu.kotapp.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *  author : xujianbo
 *  date : 2021/4/14 2:08 下午
 *  description :
 */
class BaseViewHolder(itemView: ICustomView<BaseViewModel>) :
    RecyclerView.ViewHolder((itemView as View)) {

    fun bind(viewModel: BaseViewModel) {
        (itemView as ICustomView<BaseViewModel>).setData(viewModel)
    }

}