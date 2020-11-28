package com.project.framework.mvp.adapter.baseadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

 /*

Jay Application

*/
abstract class BaseAdapterRecycleView(val list: ArrayList<*>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(setItemLayout(), parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
        p0.Bind(p1)
    }

    //----------------------SetUp------------------------------------
    abstract fun setItemLayout(): Int

    abstract fun initItemView(itemView: View, item: Any, position: Int)
    //-------------ViewHolder-----------------------
    inner class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun setItem(position: Int) {
            initItemView(itemView, list[position], position)
        }
    }

}
