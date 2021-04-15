package com.xu.kotapp.view.dragitemview

import com.xu.kotapp.base.BaseViewModel

/**
 *  author : xujianbo
 *  date : 2021/4/14 4:12 下午
 *  description :
 */
data class DragItemViewModel(
    var isChecked: Boolean = false,
    var companyName: String,
    var companyCode: String
) : BaseViewModel() {


}