package com.project.framework.mvp.data.Sqlite;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class SqliteManager extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "PUJI.db";
    private static final int DATABASE_VERSION = 1;

    public SqliteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
