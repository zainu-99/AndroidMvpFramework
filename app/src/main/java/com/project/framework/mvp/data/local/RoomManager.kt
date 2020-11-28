package com.project.framework.mvp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.framework.mvp.model.room.RoomItemUser

/*

Jay Application

*/

@Database(entities = arrayOf(RoomItemUser::class), version = 1)
abstract class RoomManager : RoomDatabase(), IRoomManager {

}