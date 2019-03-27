package com.dannextech.apps.classreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class ClassQueries {
    private SQLiteDatabase db;
    Context context;
    private ClassHelper dbHelper;


    public ClassQueries(Context context) {
        this.context = context;
        dbHelper =new ClassHelper(context);
    }

    public void saveTask(String name, String code, String venue, String date, String time, String remind){
        db = dbHelper.getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put(ClassContract.Classes.COL_CLASS_NAME,name);
        val.put(ClassContract.Classes.COL_CLASS_CODE,code);
        val.put(ClassContract.Classes.COL_CLASS_VENUE,venue);
        val.put(ClassContract.Classes.COL_CLASS_DATE,date);
        val.put(ClassContract.Classes.COL_CLASS_TIME,time);
        val.put(ClassContract.Classes.COL_CLASS_REMINDER,remind);

        db.insert(ClassContract.Classes.TABLE_NAME,null,val);

        db.close();
        Toast.makeText(context,"Class Saved Successfully",Toast.LENGTH_SHORT).show();
    }

    public ClassModel[] retrieveClasses() throws SQLException {
        db = dbHelper.getReadableDatabase();
        String mColumns[] = {ClassContract.Classes.COL_CLASS_NAME,ClassContract.Classes.COL_CLASS_CODE, ClassContract.Classes.COL_CLASS_VENUE, ClassContract.Classes.COL_CLASS_DATE,ClassContract.Classes.COL_CLASS_TIME,ClassContract.Classes.COL_CLASS_REMINDER};
        String sortOrder = ClassContract.Classes.COL_CLASS_DATE+" DESC";


        Cursor cursor = db.query(ClassContract.Classes.TABLE_NAME,mColumns,null,null,null,null,sortOrder);

        int numRows = (int) DatabaseUtils.queryNumEntries(db, ClassContract.Classes.TABLE_NAME);
        ClassModel[] classes = new ClassModel[numRows];

        int position = 0;
        while (cursor.moveToNext()){
            classes[position] = new ClassModel();
            classes[position].setcName(cursor.getString(cursor.getColumnIndexOrThrow(ClassContract.Classes.COL_CLASS_NAME)));
            classes[position].setcCode(cursor.getString(cursor.getColumnIndexOrThrow(ClassContract.Classes.COL_CLASS_CODE)));
            classes[position].setcVenue(cursor.getString(cursor.getColumnIndexOrThrow(ClassContract.Classes.COL_CLASS_VENUE)));
            classes[position].setcDate(cursor.getString(cursor.getColumnIndexOrThrow(ClassContract.Classes.COL_CLASS_DATE)));
            classes[position].setcTime(cursor.getString(cursor.getColumnIndexOrThrow(ClassContract.Classes.COL_CLASS_TIME)));
            classes[position].setcReminder(cursor.getString(cursor.getColumnIndexOrThrow(ClassContract.Classes.COL_CLASS_REMINDER)));
            
            position++;
        }
        cursor.close();
        db.close();
        return classes;
    }

}
