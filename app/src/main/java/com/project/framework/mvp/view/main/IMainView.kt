package com.project.framework.mvp.view.main
import com.project.framework.mvp.model.api.LoginResponse
import com.project.framework.mvp.view.baseview.IBaseView

interface IMainView :IBaseView {
    fun ResData(loginResponse: LoginResponse)
}