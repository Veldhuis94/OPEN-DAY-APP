package com.group5.cmiopenday;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Home.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists HomeDatabase(Date TEXT, Time TEXT, Courses TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists HomeDatabase");

    }

    public boolean insertinHomeDatabase(String s1, String s2, String s3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Date", s1);
        contentValues.put("Time", s2);
        contentValues.put("Courses", s3);
        long result = db.insert("HomeDatabase", null, contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }

    }

}