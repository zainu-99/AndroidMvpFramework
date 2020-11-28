package com.project.framework.mvp.utils

import android.content.Context
import android.widget.Toast
import es.dmoral.toasty.Toasty

@Suppress("UNUSED_PARAMETER")
/*

Jay Application

*/
class UtilToast(val context: Context,val message: String) {
    fun Info() {
        Toasty.info(context, message, Toast.LENGTH_SHORT, true).show()
    }

    fun Error() {
        Toasty.error(context, message, Toast.LENGTH_SHORT, true).show()
    }

    fun Warning() {
        Toasty.warning(context, message, Toast.LENGTH_SHORT, true).show()
    }

    fun Success() {
        Toasty.success(context, message, Toast.LENGTH_SHORT, true).show()
    }

}