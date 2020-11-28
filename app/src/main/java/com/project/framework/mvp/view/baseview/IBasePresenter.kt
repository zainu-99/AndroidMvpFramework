package com.project.framework.mvp.view.baseview

/*

Jay Application

*/
interface IBasePresenter<bv:IBaseView> {
    fun onAttach(appView : bv)
    fun onDetach()
}