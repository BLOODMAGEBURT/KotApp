package com.xu.kotapp.base

/**
 *  author : xujianbo
 *  date : 2021/4/14 2:05 下午
 *  description :
 */
interface ICustomView<VM : BaseViewModel> {
    fun setData(data: VM)
}