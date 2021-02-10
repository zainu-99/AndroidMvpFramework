package com.project.framework.mvp.view.main
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.google.gson.reflect.TypeToken
import com.project.framework.mvp.data.DataManager
import com.project.framework.mvp.model.api.LoginResponse
import com.project.framework.mvp.utils.constant.ApiEndPoint
import com.project.framework.mvp.utils.constant.StringConstant
import com.project.framework.mvp.utils.reactive.SchedulerProvider
import com.project.framework.mvp.view.baseview.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import org.json.JSONObject
import java.lang.Exception
import javax.inject.Inject

class MainPresenter<bv : IMainView> @Inject constructor (
    dm: DataManager,
    sp: SchedulerProvider,
    cd: CompositeDisposable
) : BasePresenter<bv>(dm, sp, cd),IMainPresenter<bv> {
    override fun ReqData(p0: String) {
        AndroidNetworking.upload(ApiEndPoint.ENDPOINT_POSTDATA)
            .addMultipartParameter("data",p0)
            .setPriority(Priority.HIGH)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(jsonObject: JSONObject) {

                }

                override fun onError(error: ANError) {
                    Log.e("error_upload", error.message)
                    appView!!.hideLoading()
                    appView!!.msgToast(error.message!!).Error()
                }
            })
    }

    override fun ReqData() {
        compositeDisposable.add(dataManager.getData(ApiEndPoint.ENDPOINT_GETDATA)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(Consumer {
                OnSuccessResponse(object : IOnSuccessResponse {
                    override fun doThis() {
                        var resModel = jsonParser.fromJson(it.toString(), LoginResponse::class.java)
                        appView?.ResData(resModel)
                    }
                    override fun getError(exception: Exception) {
                        Log.d("ERR:", exception.toString())
                    }
                })

            }, Consumer {
                msgToast("Tidak dapat terhubung keserver").Info()
            })
        )
    }



}