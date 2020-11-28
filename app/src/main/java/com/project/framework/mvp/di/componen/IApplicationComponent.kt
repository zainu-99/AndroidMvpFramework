package com.project.framework.mvp.di.componen

import android.content.Context
import com.project.framework.mvp.MvpApplication
import com.project.framework.mvp.di.ApplicationContext
import com.project.framework.mvp.di.module.ApplicationModule
import dagger.Component

/*

Jay Application

*/

@Component(modules = arrayOf(ApplicationModule::class))
interface IApplicationComponent {
    fun inject(app: MvpApplication)

    @ApplicationContext
    fun context(): Context
}