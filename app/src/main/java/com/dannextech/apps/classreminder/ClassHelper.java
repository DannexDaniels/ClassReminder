package com.dannextech.apps.classreminder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClassHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "classReminder";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+
            ClassContract.Classes.TABLE_NAME + "(" +
            ClassContract.Classes._ID + " INTEGER PRIMARY KEY, " +
            ClassContract.Classes.COL_CLASS_CODE + " TEXT, "+
            ClassContract.Classes.COL_CLASS_NAME + " TEXT, "+
            ClassContract.Classes.COL_CLASS_VENUE + " TEXT, "+
            ClassContract.Classes.COL_CLASS_DATE + " TEXT, "+
            ClassContract.Classes.COL_CLASS_TIME + " TEXT, "+
            ClassContract.Classes.COL_CLASS_REMINDER + " TEXT)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "+ ClassContract.Classes.TABLE_NAME;

    public ClassHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
