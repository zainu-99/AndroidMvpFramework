package com.project.framework.mvp.adapter

import android.view.View
import com.project.framework.mvp.adapter.baseadapter.BaseAdapterRecycleView

/*
Jay Application
*/
class FastRvAdapter(list: ArrayList<*>, var itemLayout: Int) : BaseAdapterRecycleView(list) {

    private lateinit var itemview: InitViewInterface

    override fun initItemView(itemView: View, item: Any, position: Int) {
        itemview.initItemView(itemView, item, position)
    }

    override fun setItemLayout(): Int = itemLayout

    fun setItemView(itemview: InitViewInterface) {
        this.itemview = itemview
    }

    interface InitViewInterface {
        fun initItemView(itemView: View, item: Any, position: Int)
    }
}