package com.xu.kotapp

import android.app.Service
import android.graphics.Color
import android.os.Bundle
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.xu.kotapp.adapter.DragAdapter
import com.xu.kotapp.base.BaseViewModel
import com.xu.kotapp.databinding.ActivityDragBinding
import com.xu.kotapp.view.dragitemview.DragItemViewModel
import java.util.*

class DragActivity : AppCompatActivity() {

    private val binding: ActivityDragBinding by lazy {
        ActivityDragBinding.inflate(layoutInflater)
    }

    private var generateItems = generateItems()

    private val dragAdapter = DragAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val binding = ActivityDragBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()

    }

    private fun initData() {


        dragAdapter.setData(generateItems)

        binding.rvDrag.adapter = dragAdapter
        binding.rvDrag.layoutManager = LinearLayoutManager(this)

        ItemTouchHelper(DragCallback()).attachToRecyclerView(binding.rvDrag)

        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                TODO("Not yet implemented")
            }

            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                TODO("Not yet implemented")
            }
        })


    }


    private fun generateItems(): MutableList<BaseViewModel> {
        val items = mutableListOf<BaseViewModel>()
        for (i in 1..10) {
            items.add(DragItemViewModel(false, "清科创业", "HK2039482--${i}"))
        }
        return items
    }

    inner class DragCallback : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return if (recyclerView.layoutManager is GridLayoutManager || recyclerView.layoutManager is StaggeredGridLayoutManager) {

                // 此处不需要进行滑动操作，可设置为除4和8之外的整数，这里设为0
                // 不支持滑动
                makeMovementFlags(
                    ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
                    0
                )
            } else {
                // 如果是LinearLayoutManager则只能上下拖动
                // 第二个参数设置 支持向右滑动
                makeMovementFlags(
                    ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                    ItemTouchHelper.RIGHT
                )
            }
        }

        /**
         * 当 ItemTouchHelper 拖动一个Item时该方法将会被回调，Item将从旧的位置移动到新的位置
         * 如果不拖动这个方法将从来不会调用,返回true表示已经被移动到新的位置
         * @param recyclerView
         * @param viewHolder
         * @param target
         * @return
         */
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val fromPosition = viewHolder.adapterPosition
            val toPosition = target.adapterPosition

            if (fromPosition < toPosition) {
                for (i in fromPosition until toPosition) {
                    Collections.swap(generateItems, i, i + 1)
                }
            } else {
                for (i in fromPosition downTo toPosition + 1) {
                    Collections.swap(generateItems, i, i - 1)
                }
            }
            dragAdapter.notifyItemMoved(fromPosition, toPosition)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            // 侧滑删除的逻辑
            generateItems.removeAt(viewHolder.adapterPosition)
            dragAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            dragAdapter.notifyItemRangeChanged(viewHolder.adapterPosition, generateItems.size)

        }

        override fun isLongPressDragEnabled(): Boolean {
            return true
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return true
        }

        /**
         * 长按选中时，开始调用
         */
        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
            if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                viewHolder?.itemView?.setBackgroundColor(Color.GRAY)
                (getSystemService(Service.VIBRATOR_SERVICE) as Vibrator).vibrate(70)
            }
            super.onSelectedChanged(viewHolder, actionState)
        }

        override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
            super.clearView(recyclerView, viewHolder)
            viewHolder.itemView.setBackgroundColor(0)
            dragAdapter.notifyDataSetChanged()
        }

    }

}