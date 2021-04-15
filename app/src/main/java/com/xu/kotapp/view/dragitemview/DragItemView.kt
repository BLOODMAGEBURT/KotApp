package com.xu.kotapp.view.dragitemview

import android.content.Context
import android.view.View
import android.widget.Toast
import com.xu.kotapp.R
import com.xu.kotapp.base.BaseCustomView
import com.xu.kotapp.databinding.DragItemBinding

/**
 *  author : xujianbo
 *  date : 2021/4/14 3:01 下午
 *  description :
 */
class DragItemView(context: Context) :
    BaseCustomView<DragItemBinding, DragItemViewModel>(context) {


    override fun setDataToView(data: DragItemViewModel) {
        getDataBinding().vm = data
    }

    override fun setLayout(): Int {
        return R.layout.drag_item
    }

    override fun onRootClicked(v: View) {
        Toast.makeText(this.context, "被点击了", Toast.LENGTH_SHORT).show()
    }

    override fun onDataUpdated() {

    }
}