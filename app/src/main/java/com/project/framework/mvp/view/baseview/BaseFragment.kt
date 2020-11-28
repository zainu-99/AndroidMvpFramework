package com.project.framework.mvp.view.baseview

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.project.framework.mvp.di.componen.IViewComponent
import com.project.framework.mvp.utils.UtilLoading
import com.project.framework.mvp.utils.UtilToast
import com.project.framework.mvp.utils.constant.StringConstant
import com.project.framework.mvp.utils.sessions.SessionManager
import org.json.JSONArray

abstract /*

Jay Application

*/
class BaseFragment : androidx.fragment.app.Fragment(), IBaseView {

    lateinit var sessionManager: SessionManager
    private var mProgressDialog: Dialog? = null
    var jsonAkses:JSONArray ?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(setLayout(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        try {
            sessionManager = SessionManager(context!!)
            val jsonString = sessionManager.GetString(StringConstant.LOGIN_SESSION_ACCESS)
            jsonAkses = JSONArray(jsonString)
            initCreateView()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        initDestroyView()
    }

    //----------SetUp------------------------------
    abstract fun setLayout(): Int

    abstract fun initCreateView()

    abstract fun initDestroyView()


    override fun showSnackBar(message: String) {

    }

    override fun msgToast(message: String): UtilToast {
        return UtilToast(this.context!!, message)
    }

    override fun jsonParser(): Gson {
        return Gson()
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = UtilLoading.showLoadingDialog(this.context!!)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    fun viewComponent(): IViewComponent {
        return (this.activity as BaseActivity).viewComponent()
    }

    fun goToActivity(bundle: Bundle, kcalss: Class<*>) {
        startActivity(Intent(this.context, kcalss).putExtras(bundle))
    }

    fun goToActivityForResult(bundle: Bundle, kcalss: Class<*>, codeResult: Int) {
        startActivityForResult(Intent(this.context, kcalss).putExtras(bundle), codeResult)
    }

    override fun appContext(): Context {
        return this.context!!
    }
}