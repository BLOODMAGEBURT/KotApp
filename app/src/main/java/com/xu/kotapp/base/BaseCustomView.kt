package com.xu.kotapp.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 *  author : xujianbo
 *  date : 2021/4/14 2:51 下午
 *  description :
 */
abstract class BaseCustomView<T : ViewDataBinding, S : BaseViewModel> @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr),
    ICustomView<S> {

    private var dataBinding: T
    private lateinit var viewModel: S

    init {

        val inflater = LayoutInflater.from(getContext())
        dataBinding = DataBindingUtil.inflate(inflater, setLayout(), this, false)
        dataBinding.root.setOnClickListener { v -> onRootClicked(v) }
        addView(dataBinding.root)

    }


    override fun setData(data: S) {
        viewModel = data
        setDataToView(data)
        dataBinding.executePendingBindings()
        onDataUpdated()
    }

    fun getDataBinding(): T = dataBinding


    abstract fun setDataToView(data: S)

    abstract fun setLayout(): Int

    abstract fun onRootClicked(v: View);

    abstract fun onDataUpdated()

}