package com.project.framework.mvp.data

import com.project.framework.mvp.data.local.RoomManager

interface IDataManager {
    fun RoomDatabase() : RoomManager
}