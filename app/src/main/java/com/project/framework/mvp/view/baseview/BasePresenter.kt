package com.project.framework.mvp.view.baseview

import com.androidnetworking.AndroidNetworking
import com.google.gson.Gson
import com.project.framework.mvp.MvpApplication
import com.project.framework.mvp.data.DataManager
import com.project.framework.mvp.utils.UtilToast
import com.project.framework.mvp.utils.reactive.SchedulerProvider
import com.project.framework.mvp.utils.sessions.SessionManager
import io.reactivex.disposables.CompositeDisposable
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

open /*

Jay Application

*/
class BasePresenter<bv : IBaseView> @Inject constructor(
    dm: DataManager,
    sp: SchedulerProvider,
    cd: CompositeDisposable
) : IBasePresenter<bv> {

    var dataManager = dm
    var schedulerProvider = sp
    var compositeDisposable = cd

    var appView: bv? = null
    var isAttachingView = true
    private var postMap = HashMap<String, String>()
    lateinit var sessionManager: SessionManager
    val jsonParser = Gson()

    override fun onAttach(appView: bv) {
        this.appView = appView
        sessionManager = SessionManager(MvpApplication.context)
        AndroidNetworking.initialize(MvpApplication.context)
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        this.isAttachingView = false
    }


    //--------------------------------------------------
    fun setBodyPostMap(key: String, value: String) {
        postMap[key] = value
    }

    fun getBodyPostMap(): HashMap<String, String> {
        return postMap
    }

    fun resetBodyPostMap() {
        postMap = HashMap()
    }

    fun msgToast(message: String): UtilToast {
        return UtilToast(dataManager.getContext(), message)
    }

    fun OnSuccessResponse(obj: IOnSuccessResponse) {
        try {
            obj.doThis()
        } catch (e: Exception) {
            obj.getError(e)
        }
    }

    interface IOnSuccessResponse {
        @Throws(IOException::class)
        fun doThis()
        fun getError(exception: Exception)
    }
}