package com.project.framework.mvp.utils.sessions

import android.content.Context

/*

Jay Application

*/
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
open
class SessionManager(private val c: Context) {
    fun GetString(key: String): String {
        return c.getSharedPreferences("SessionManager", 0).getString(key, "")
    }

    fun SetString(key: String, value: String) {
        c.getSharedPreferences("SessionManager", 0).edit().putString(key, value).commit()
    }

    fun GetBoolean(key: String): Boolean {
        return c.getSharedPreferences("SessionManager", 0).getBoolean(key, false)
    }

    fun SetBoolean(key: String, value: Boolean?) {
        c.getSharedPreferences("SessionManager", 0).edit().putBoolean(key, value!!).commit()
    }

    fun GetInteger(key: String): Int {
        return c.getSharedPreferences("SessionManager", 0).getInt(key, 0)
    }

    fun SetInteger(key: String, value: Int) {
        c.getSharedPreferences("SessionManager", 0).edit().putInt(key, value).commit()
    }

    fun GetFloat(key: String): Float {
        return c.getSharedPreferences("SessionManager", 0).getFloat(key, 0f)
    }

    fun SetFloat(key: String, value: Float) {
        c.getSharedPreferences("SessionManager", 0).edit().putFloat(key, value).commit()
    }

}
