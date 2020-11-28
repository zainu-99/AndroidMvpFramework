package com.project.framework.mvp.service

import android.app.IntentService
import android.content.Intent
import android.os.Handler
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.project.framework.mvp.utils.constant.ApiEndPoint
import com.project.framework.mvp.utils.constant.StringConstant
import org.json.JSONObject
import androidx.core.os.HandlerCompat.postDelayed
import com.project.framework.mvp.utils.UtilGpsTracker


class BackgroundService : IntentService("Firebase Makeup") {
    override fun onHandleIntent(intent: Intent?) {
        val idPenyewa = intent?.getStringExtra("id_penyewa")
        val idPerias = intent?.getStringExtra("id_perias")
        val handler = Handler()
        val r = Runnable {
            sendCurLocPerias(idPenyewa!!, idPerias!!)
        }
        handler.postDelayed(r, 3000)
        r.run()
    }

    fun sendCurLocPerias(id_Penyewa: String, id_Perias: String) {
        val header = HashMap<String, String>()
        header["Authorization"] = StringConstant.AUTORIZATION
        header["Content-Type"] = StringConstant.CONTENT_TYPE

        val lat = UtilGpsTracker(this).latitude
        val long = UtilGpsTracker(this).longitude

        val post =JSONObject("{\"id_penyewa\":\"$id_Penyewa\",\"id_perias\":\"$id_Perias\",\"lat\":\"$lat\",\"long\":\"$long\",\"status\":1}")
        AndroidNetworking.initialize(this)
        AndroidNetworking.post("")
            .addHeaders(header)
            .addJSONObjectBody(post)
            .setPriority(Priority.HIGH)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(jsonObject: JSONObject) {
                    Log.e("error_upload", "success")
                }

                override fun onError(error: ANError) {
                    Log.e("error_upload", error.message)
                }
            })
    }

}