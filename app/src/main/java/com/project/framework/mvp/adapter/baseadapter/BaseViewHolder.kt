package com.project.framework.mvp.adapter.baseadapter

import android.view.View

abstract /*

Jay Application

*/
class BaseViewHolder(viewHolder: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(viewHolder) {
    var mCurrentPosition = 0
    fun Bind(position: Int) {
        mCurrentPosition = position
        setItem(position)
    }
    abstract fun setItem(position: Int)
}