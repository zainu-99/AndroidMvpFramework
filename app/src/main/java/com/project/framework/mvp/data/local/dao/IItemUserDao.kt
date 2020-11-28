package com.project.framework.mvp.data.local.dao

import androidx.room.*
import com.project.framework.mvp.model.room.RoomItemUser

@Dao
interface IItemUserDao {
    @Insert
    fun insert(vararg items: RoomItemUser)

    @Update
    fun update(vararg items: RoomItemUser)

    @Delete
    fun delete(item: RoomItemUser)

    @Query("SELECT * FROM roomitemuser WHERE id = :id")
    fun selectOne(id: Int)

    @Query("SELECT * FROM roomitemuser")
    fun selectAll()
}