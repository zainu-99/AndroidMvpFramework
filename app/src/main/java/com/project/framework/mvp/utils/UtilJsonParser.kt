package com.project.framework.mvp.utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class UtilJsonParser<m : Any> {
    var gson = Gson()
    fun jsonArrayToListObject(jsonString: String): Any {
        val listType = object : TypeToken<List<m>>() {
        }.type
        return Gson().fromJson(jsonString, listType)
    }

    fun jsonObjectToObject(jsonString: String, cls: Class<*>): Any {
        return gson.fromJson(jsonString, cls)
    }
}