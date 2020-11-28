package com.project.framework.mvp.di.module

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.framework.mvp.utils.reactive.AppSchedulerProvider
import com.project.framework.mvp.utils.reactive.SchedulerProvider
import com.project.framework.mvp.view.main.IMainPresenter
import com.project.framework.mvp.view.main.IMainView
import com.project.framework.mvp.view.main.MainPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/*

Jay Application

*/
@Module
class ViewModule constructor(private val context: Activity) {


    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    internal fun provideActivity(): Activity {
        return context
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    internal fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }
    //----------------------Activity-----------------------------
    @Provides
    internal fun provideMainActivity(presenter: MainPresenter<IMainView>): IMainPresenter<IMainView> {
        return presenter
    }

}
