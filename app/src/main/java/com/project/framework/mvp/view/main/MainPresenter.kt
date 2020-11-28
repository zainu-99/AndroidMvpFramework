package com.project.framework.mvp.view.main
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.google.gson.reflect.TypeToken
import com.project.framework.mvp.data.DataManager
import com.project.framework.mvp.utils.constant.ApiEndPoint
import com.project.framework.mvp.utils.constant.StringConstant
import com.project.framework.mvp.utils.reactive.SchedulerProvider
import com.project.framework.mvp.view.baseview.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import org.json.JSONObject
import javax.inject.Inject

class MainPresenter<bv : IMainView> @Inject constructor (
    dm: DataManager,
    sp: SchedulerProvider,
    cd: CompositeDisposable
) : BasePresenter<bv>(dm, sp, cd),IMainPresenter<bv> {
    override fun postData(str: String) {
        AndroidNetworking.upload(ApiEndPoint.ENDPOINT_POSTDATA)
            .addMultipartParameter("data",str)
            .setPriority(Priority.HIGH)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(jsonObject: JSONObject) {
                    if (jsonObject.getString("message") == "success") {
                        appView!!.msgToast("Success").Success()
                        appView!!.hideLoading()
                        var jsonData = jsonObject.getJSONObject("data")
                        sessionManager.SetString(StringConstant.LOGIN_SESSION_NAME, jsonData.getString("NAME"))

                    } else {
                        appView!!.hideLoading()
                        appView!!.msgToast(jsonObject.getString("message"))
                    }
                }

                override fun onError(error: ANError) {
                    Log.e("error_upload", error.message)
                    appView!!.hideLoading()
                    appView!!.msgToast(error.message!!).Error()
                }
            })
    }

    override fun getData() {
        compositeDisposable.add(dataManager.getData(ApiEndPoint.ENDPOINT_GETDATA)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(Consumer {
                val mJsonArray = it.getJSONArray("data")
                val listType = object : TypeToken<List<String>>() {}.type
                val items = jsonParser.fromJson<List<String>>(mJsonArray.toString(), listType)
                appView!!.SetData(items)
                appView!!.hideLoading()
                appView!!.msgToast(it.getString("message"))

            }, Consumer {
                appView!!.hideLoading()
                appView!!.msgToast(it.message!!).Error()
                appView!!.SetError()
            })
        )
    }



}