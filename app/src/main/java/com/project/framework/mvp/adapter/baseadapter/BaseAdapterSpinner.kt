package com.project.framework.mvp.adapter.baseadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.project.framework.mvp.R

/*

Jay Application

*/
class BaseAdapterSpinner(context: Context, resource: Int, val items: ArrayList<String>) :
    ArrayAdapter<String>(context, resource, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItem = convertView
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.abc_list_menu_item_layout, parent, false)
        return listItem!!

    }
}