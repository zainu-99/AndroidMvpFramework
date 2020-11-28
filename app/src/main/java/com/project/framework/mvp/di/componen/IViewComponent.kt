package com.project.framework.mvp.di.componen

import com.project.framework.mvp.di.module.ViewModule
import com.project.framework.mvp.view.main.MainActivity
import com.project.framework.mvp.view.splash_screen.SplashActivity
import dagger.Component

@Component(dependencies = [IApplicationComponent::class], modules = [ViewModule::class])
interface IViewComponent {
    fun inject(activity: SplashActivity)
    fun inject(activity: MainActivity)
}