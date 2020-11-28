package com.project.framework.mvp.di.module

import android.app.Application
import android.content.Context
import com.project.framework.mvp.data.network.ApiManager
import com.project.framework.mvp.data.network.IApiManager
import com.project.framework.mvp.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/*

Jay Application

*/

@Module
class ApplicationModule constructor(private val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideApiManager(param: ApiManager): IApiManager {
        return param
    }
}
