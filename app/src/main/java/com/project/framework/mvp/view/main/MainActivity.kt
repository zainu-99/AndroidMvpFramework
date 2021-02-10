package com.project.framework.mvp.view.main
import android.util.Log
import com.project.framework.mvp.R
import com.project.framework.mvp.model.api.LoginResponse
import com.project.framework.mvp.utils.constant.StringConstant.Companion.SUCCESS
import com.project.framework.mvp.view.baseview.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(),IMainView {

    @Inject
    lateinit var mPresenter: IMainPresenter<IMainView>
    override fun setLayout(): Int = R.layout.activity_main

    override fun initCreateView() {
        viewComponent().inject(this)
        mPresenter.onAttach(this)
        mPresenter.ReqData()
        mPresenter.ReqData("AndroidMvpFrameWork")
    }

    override fun initDestroyView() {
    }

    override fun ResData(loginResponse: LoginResponse) {
        if (loginResponse.status == SUCCESS) {
        } else {
        }
    }

}
