package com.project.framework.mvp.data.network

import io.reactivex.Single
import org.json.JSONObject
import java.io.File
import java.util.HashMap
/*

Jay Application

*/
interface IApiManager {
    abstract fun getData(api: String): Single<JSONObject>
    abstract fun postData(api: String, post: HashMap<String, String>): Single<JSONObject>
    abstract fun putData(api: String, post: HashMap<String, String>): Single<JSONObject>
    abstract fun deleteData(api: String, post: HashMap<String, String>): Single<JSONObject>
    abstract fun uploadData(api: String, post: HashMap<String, String>, foto: File): Single<JSONObject>
    abstract fun postJsonData(api: String, json:JSONObject): Single<JSONObject>
    abstract fun checkVersion(api: String): Single<JSONObject>
}