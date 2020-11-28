package com.project.framework.mvp.data.Sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.project.framework.mvp.model.sqlite.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class SqliteAccess {
    private SqliteManager sqliteManager;
    private SQLiteDatabase database;
    private static SqliteAccess instance;

    private SqliteAccess(Context context) {
        this.sqliteManager = new SqliteManager(context);
    }

    public static SqliteAccess getInstance(Context context) {
        if (instance == null) {
            instance = new SqliteAccess(context);
        }
        return instance;
    }
    public void open() {
        this.database = sqliteManager.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }
    public void addRactangle(Rectangle rectangle)
    {
       database.execSQL("insert into RectangleArea (lat_a,long_a,lat_b,long_b,lat_c,long_c,lat_d,long_d) values('"+ rectangle.getLatA() +"','"+ rectangle.getLongA() +"','"+ rectangle.getLatB() +"','"+ rectangle.getLongB() +"','"+ rectangle.getLatC() +"','"+ rectangle.getLongC() +"','"+ rectangle.getLatD() +"','"+ rectangle.getLongD() +"')");
    }
    public void deleteRactangle(int id)
    {
        database.execSQL("delete from RectangleArea where id = '"+ id  +"'");
    }
    public void updateRactangle(Rectangle rectangle)
    {
        database.execSQL("update RectangleArea set lat_a='"+ rectangle.getLatA() +"',long_a='"+ rectangle.getLongA() +"',lat_b='"+ rectangle.getLatB() +"',long_b='"+ rectangle.getLongB() +"',lat_c='"+ rectangle.getLatC() +"',long_c='"+ rectangle.getLongC() +"',lat_d='"+ rectangle.getLatD() +"',long_d='"+ rectangle.getLongD() +"' where id ='"+ rectangle.getId() +"'");
    }
    public List<Rectangle> getRectangles() {
        List<Rectangle> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from RectangleArea", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Rectangle rectangle = new Rectangle();
            rectangle.setId(cursor.getInt(0));
            rectangle.setLatA(cursor.getDouble(1));
            rectangle.setLongA(cursor.getDouble(2));
            rectangle.setLatB(cursor.getDouble(3));
            rectangle.setLongB(cursor.getDouble(4));
            rectangle.setLatC(cursor.getDouble(5));
            rectangle.setLongC(cursor.getDouble(6));
            rectangle.setLatD(cursor.getDouble(7));
            rectangle.setLongD(cursor.getDouble(8));
            list.add(rectangle);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public  Rectangle getRecatngleById(String id)
    {
        Rectangle rectangle = new Rectangle();
        Cursor cursor = database.rawQuery("select * from RectangleArea where id ='"+id+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rectangle.setId(cursor.getInt(0));
            rectangle.setLatA(cursor.getDouble(1));
            rectangle.setLongA(cursor.getDouble(2));
            rectangle.setLatB(cursor.getDouble(3));
            rectangle.setLongB(cursor.getDouble(4));
            rectangle.setLatC(cursor.getDouble(5));
            rectangle.setLongC(cursor.getDouble(6));
            rectangle.setLatD(cursor.getDouble(7));
            rectangle.setLongD(cursor.getDouble(8));
            cursor.moveToNext();
        }
        cursor.close();
        return rectangle;
    }
}
