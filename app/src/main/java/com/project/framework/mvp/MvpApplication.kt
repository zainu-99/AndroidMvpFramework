package com.project.framework.mvp

import android.app.Application
import android.content.Context
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.project.framework.mvp.di.componen.DaggerIApplicationComponent
import com.project.framework.mvp.di.componen.IApplicationComponent
import com.project.framework.mvp.di.module.ApplicationModule
import com.project.framework.mvp.utils.UtilLogger


/*

Jay Application

*/
@Suppress("DEPRECATION")
class MvpApplication : Application() {

    lateinit var applicationComponent: IApplicationComponent

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerIApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        context = applicationContext
        UtilLogger.init()
        AndroidNetworking.initialize(applicationContext)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }
    }

}
