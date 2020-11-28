package com.project.framework.mvp.model.room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.project.framework.mvp.model.base.BaseModel
import androidx.room.PrimaryKey



/*

Jay Application

*/
@Entity(tableName = "roomitemuser")
class RoomItemUser : BaseModel() {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private val id: Long? = null
    @ColumnInfo(name = "name")
    private val name: String? = null
    @ColumnInfo(name = "description")
    private val description: String? = null
    @ColumnInfo(name = "quantity")
    private val quantity: Long? = null
}