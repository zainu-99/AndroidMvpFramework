package com.project.framework.mvp.view.main
import android.util.Log
import com.project.framework.mvp.R
import com.project.framework.mvp.view.baseview.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(),IMainView {
    override fun SetError() {
        Log.d("Data","Error")
    }

    override fun SetData(list: List<String>) {
        for ( i in list)
        {
            Log.d("Data",i)
        }
    }

    @Inject
    lateinit var mPresenter: IMainPresenter<IMainView>
    override fun setLayout(): Int = R.layout.activity_main

    override fun initCreateView() {
        viewComponent().inject(this)
        mPresenter.onAttach(this)
       // mPresenter.getData()
       // mPresenter.postData("AndroidMvpFrameWork")
    }

    override fun initDestroyView() {
    }

}
