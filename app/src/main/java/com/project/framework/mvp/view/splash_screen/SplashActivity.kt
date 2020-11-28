package com.project.framework.mvp.view.splash_screen
import com.project.framework.mvp.R
import com.project.framework.mvp.view.baseview.BaseActivity
import android.content.Intent
import com.project.framework.mvp.view.main.MainActivity


class SplashActivity : BaseActivity() {


    override fun setLayout(): Int = R.layout.activity_splash_screen
    override fun initCreateView() {
        val background = object : Thread() {
            override fun run() {
                try {
                    sleep((1 * 1000).toLong())
                    val i = Intent(baseContext, MainActivity::class.java)
                    startActivity(i)
                    finish()
                } catch (e: Exception) {
                }

            }
        }
        background.start()
    }

    override fun initDestroyView() {

    }

}
