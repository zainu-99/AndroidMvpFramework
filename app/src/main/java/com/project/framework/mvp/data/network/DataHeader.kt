package com.project.framework.mvp.data.network

import android.content.Context
import com.project.framework.mvp.utils.constant.StringConstant
import com.project.framework.mvp.utils.sessions.SessionManager
import javax.inject.Inject

/*

Jay Application

*/
class DataHeader @Inject constructor(val mContext: Context) {
    fun getPrivateDataHeader(): HashMap<String, String> {
        val map = HashMap<String, String>()
        map["Token"] = SessionManager(mContext).GetString(StringConstant.LOGIN_SESSION_TOKEN)
        map["username"] = SessionManager(mContext).GetString(StringConstant.USERNAME)
        map["Autorization"] = SessionManager(mContext).GetString(StringConstant.AUTORIZATION)
        map["Content-Type"] = SessionManager(mContext).GetString(StringConstant.CONTENT_TYPE)
        return map
    }
}