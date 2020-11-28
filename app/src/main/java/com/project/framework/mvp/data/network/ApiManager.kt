package com.project.framework.mvp.data.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.project.framework.mvp.MvpApplication
import com.rx2androidnetworking.Rx2AndroidNetworking
import com.project.framework.mvp.utils.constant.ApiEndPoint
import io.reactivex.Single
import org.json.JSONObject
import java.io.File
import java.util.HashMap
import javax.inject.Inject


/*

Jay Application

*/
class ApiManager @Inject constructor(private val dataHeader: DataHeader) : IApiManager {

    override fun getData(api: String): Single<JSONObject> {
        return Rx2AndroidNetworking.get(api)
            .addHeaders(dataHeader.getPrivateDataHeader())
            .build()
            .jsonObjectSingle
    }

    override fun postData(api: String, post: HashMap<String, String>): Single<JSONObject> {
        return Rx2AndroidNetworking.post(api)
            .addHeaders(dataHeader.getPrivateDataHeader())
            .addBodyParameter(post)
            .build()
            .jsonObjectSingle
    }

    override fun putData(api: String, post: HashMap<String, String>): Single<JSONObject> {
        return Rx2AndroidNetworking.put(api)
            .addHeaders(dataHeader.getPrivateDataHeader())
            .addBodyParameter(post)
            .build()
            .jsonObjectSingle
    }

    override fun deleteData(api: String, post: HashMap<String, String>): Single<JSONObject> {
        return Rx2AndroidNetworking.delete(api)
            .addHeaders(dataHeader.getPrivateDataHeader())
            .addBodyParameter(post)
            .build()
            .jsonObjectSingle
    }

    override fun uploadData(api: String, post: HashMap<String, String>, foto: File): Single<JSONObject> {
        return Rx2AndroidNetworking.upload(api)
            .addHeaders(dataHeader.getPrivateDataHeader())
            .addMultipartFile("foto", foto)
            .addMultipartParameter(post)
            .setPriority(Priority.HIGH)
            .build()
            .jsonObjectSingle
    }
    override fun postJsonData(api: String, json:JSONObject): Single<JSONObject> {
        return Rx2AndroidNetworking.post(api)
            .addHeaders(dataHeader.getPrivateDataHeader())
            .addJSONObjectBody(json)
            .setPriority(Priority.HIGH)
            .build()
            .jsonObjectSingle
    }

    override fun checkVersion(api: String): Single<JSONObject> {
        return Rx2AndroidNetworking.get(api)
            .addHeaders(dataHeader.getPrivateDataHeader())
            .doNotCacheResponse()
            .build()
            .jsonObjectSingle
    }
}