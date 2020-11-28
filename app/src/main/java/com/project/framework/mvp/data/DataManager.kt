package com.project.framework.mvp.data

import android.content.Context
import com.project.framework.mvp.data.local.IRoomManager
import com.project.framework.mvp.data.network.ApiManager
import com.project.framework.mvp.data.network.IApiManager
import io.reactivex.Single
import org.json.JSONObject
import java.util.HashMap
import javax.inject.Inject
import java.io.File


/*
Jay Application
*/

class DataManager @Inject constructor(private val apiManager: ApiManager, private val context: Context) :
    IApiManager,
    IRoomManager, IDataManager {

    override fun getData(api: String): Single<JSONObject> {
        return apiManager.getData(api)
    }

    override fun postData(api: String, post: HashMap<String, String>): Single<JSONObject> {
        return apiManager.postData(api, post)
    }

    override fun putData(api: String, post: HashMap<String, String>): Single<JSONObject> {
        return apiManager.putData(api, post)
    }

    override fun deleteData(api: String, post: HashMap<String, String>): Single<JSONObject> {
        return apiManager.deleteData(api, post)
    }

    override fun uploadData(api: String, post: HashMap<String, String>, foto: File): Single<JSONObject> {
        return apiManager.uploadData(api, post, foto)
    }
    override fun postJsonData(api: String, json: JSONObject): Single<JSONObject> {
        return apiManager.postJsonData(api, json)
    }

    override fun checkVersion(api: String): Single<JSONObject> {
        return apiManager.checkVersion(api)
    }




    //RoomManager



}