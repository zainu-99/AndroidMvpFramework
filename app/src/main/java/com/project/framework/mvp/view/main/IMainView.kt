package com.project.framework.mvp.view.main

import com.project.framework.mvp.view.baseview.IBaseView

interface IMainView :IBaseView {
    fun SetData(list: List<String>)
    fun SetError()
}