package com.project.framework.mvp.view.baseview

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.project.framework.mvp.MvpApplication
import com.project.framework.mvp.R
import com.project.framework.mvp.di.componen.DaggerIViewComponent
import com.project.framework.mvp.di.componen.IViewComponent
import com.project.framework.mvp.di.module.ViewModule
import com.project.framework.mvp.utils.UtilLoading
import com.project.framework.mvp.utils.UtilToast
import com.project.framework.mvp.utils.constant.StringConstant
import com.project.framework.mvp.utils.sessions.SessionManager
import org.json.JSONArray
import java.text.DecimalFormat
import java.util.*

@Suppress("DEPRECATION")
abstract /*

Jay Application

*/
class BaseActivity : AppCompatActivity(), IBaseView {
    private lateinit var mViewComponent: IViewComponent
    private var mProgressDialog: Dialog? = null
    lateinit var sessionManager: SessionManager
    val numberFormatter = DecimalFormat("#,###")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewComponent = DaggerIViewComponent.builder().viewModule(ViewModule(this)).iApplicationComponent(
            (application as MvpApplication).applicationComponent
        ).build()
        setContentView(setLayout())
        sessionManager = SessionManager(applicationContext)
        initCreateView()
    }

    override fun onDestroy() {
        super.onDestroy()
        initDestroyView()
    }

    //----------SetUp------------------------------
    abstract fun setLayout(): Int

    abstract fun initCreateView()

    abstract fun initDestroyView()


    //---------------Utility----------------------
    override fun showSnackBar(message: String) {

    }

    override fun msgToast(message: String): UtilToast {
        return UtilToast(this, message)
    }


    override fun jsonParser(): Gson {
        return Gson()
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = UtilLoading.showLoadingDialog(this)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    fun viewComponent(): IViewComponent {
        return mViewComponent
    }

    fun goToActivity(bundle: Bundle, kcalss: Class<*>) {
        startActivity(Intent(this, kcalss).putExtras(bundle))
    }

    fun goToActivityForResult(bundle: Bundle, kcalss: Class<*>, codeResult: Int) {
        startActivityForResult(Intent(this, kcalss).putExtras(bundle), codeResult)
    }

    fun setViewFragment(id: Int, fragment: Fragment, ActionBarTitle: String) {
        val fragmentManager = supportFragmentManager
        if (!fragmentManager.fragments.contains(fragment)) {
            fragmentManager.beginTransaction()
                .add(id, fragment)
                .commit()
        }else{
            for(i in fragmentManager.fragments) {
                if(fragment!=i) fragmentManager.beginTransaction().hide(i).commit()
                else fragmentManager.beginTransaction().show(fragment).commit()
            }
        }
        supportActionBar?.title = ActionBarTitle
    }

    override fun appContext(): Context {
        return this.applicationContext
    }
}