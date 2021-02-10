package com.project.framework.mvp.view.main

import com.project.framework.mvp.view.baseview.IBasePresenter

interface IMainPresenter<bv : IMainView> : IBasePresenter<bv> {
    fun ReqData()
    fun ReqData(p0:String)
}