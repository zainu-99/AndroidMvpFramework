package com.project.framework.mvp.view.main

import com.project.framework.mvp.view.baseview.IBasePresenter

interface IMainPresenter<bv : IMainView> : IBasePresenter<bv> {
    fun getData()
    fun postData(str : String)
}