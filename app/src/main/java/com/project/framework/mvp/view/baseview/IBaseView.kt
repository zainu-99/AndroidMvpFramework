package com.project.framework.mvp.view.baseview

import android.content.Context
import com.google.gson.Gson
import com.project.framework.mvp.utils.UtilToast
import com.project.framework.mvp.utils.sessions.SessionManager

/*

Jay Application

*/
interface IBaseView {
    fun msgToast(message: String): UtilToast
    fun showSnackBar(message: String)
    fun showLoading()
    fun hideLoading()
    fun jsonParser(): Gson
    fun appContext(): Context
}