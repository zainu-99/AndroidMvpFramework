package com.project.framework.mvp.model.api

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("status")
    @Expose
    val status: String? = null
    @SerializedName("message")
    @Expose
    val message: String? = null
    @SerializedName("values")
    @Expose
    val values: Values? = null
    inner class Values {
        @SerializedName("id")
        @Expose
        val id: Int? = null
        @SerializedName("kd_lang")
        @Expose
        val kdLang: String? = null
        @SerializedName("nm_lang")
        @Expose
        val nmLang: String? = null
        @SerializedName("address1")
        @Expose
        val address1: String? = null
        @SerializedName("password")
        @Expose
        val password: String? = null
        @SerializedName("pin")
        @Expose
        val pin: String? = null
        @SerializedName("created_at")
        @Expose
        val createdAt: Any? = null
        @SerializedName("updated_at")
        @Expose
        val updatedAt: String? = null
    }
}
