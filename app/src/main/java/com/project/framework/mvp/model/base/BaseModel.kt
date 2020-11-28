package com.project.framework.mvp.model.base

import com.google.gson.Gson


open class BaseModel {
    fun toJson() {
        val gson = Gson()
        gson.toJson(this)
    }
}