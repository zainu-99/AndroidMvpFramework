package com.project.framework.mvp.utils

import android.app.Activity

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class UtilBundleData constructor(val activity: Activity) {
    fun getBundleDataString(key: String): String {
        return activity.intent.extras.getString(key)
    }

    fun getBundleDataInteger(key: String): Int {
        return activity.intent.extras.getInt(key)
    }

    fun getBundleDataBoolean(key: String): Boolean {
        return activity.intent.extras.getBoolean(key)
    }

    fun getBundleDataFloat(key: String): Float {
        return activity.intent.extras.getFloat(key)
    }

    fun getBundleDataDouble(key: String): Double {
        return activity.intent.extras.getDouble(key)
    }
}