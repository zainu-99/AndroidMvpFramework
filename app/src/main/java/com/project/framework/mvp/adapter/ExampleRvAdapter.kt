package com.project.framework.mvp.adapter

import android.view.View
import com.project.framework.mvp.adapter.baseadapter.BaseAdapterRecycleView

/*

Jay Application

*/
class ExampleRvAdapter(list: ArrayList<Any>) : BaseAdapterRecycleView(list) {

    override fun initItemView(itemView: View, item: Any, position: Int) {

    }
    override fun setItemLayout(): Int = 0
}