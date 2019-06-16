package com.group5.cmiopenday1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;


public class DatabaseHelper extends SQLiteOpenHelper {

    String DB_PATH = null;
    private static String DB_NAME = "MyDatabase";
    private static final String TABLE_NAME = "Homepage";
    private static final String TABLE_NAME1 = "OpenDays";
    private static final String Col1 = "ID";
    private static final String Col2 = "Date";
    private static final String Col3 = "Time";
    private static final String Col4 = "Courses";
    private static final String Col5 = "Course";
    private static final String Col6 = "Classroom";
    private static final String Col7 = "Time";
    private static final String Col8 = "Location";
    String Language = "";
    String Language1 = "";


    private static final String DBlocation = "/data/data/com.group5.cmiopenday/databases/";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 10);
        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }


    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }
    public void ReloadDataBase(Context context) throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {context.deleteDatabase("MyDatabase");
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
        }}  else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    public boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);//Gets Database from assets folder
        String outFileName = DB_PATH + DB_NAME;//Path to Database on phone
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();

            }
    }
    public boolean addData(String date, String time, String courses){
        String Phonelanguage = Locale.getDefault().getLanguage();
        if(Phonelanguage.equals("nl")){
            Language = "NL";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col2,date);
        contentValues.put(Col3,time);
        contentValues.put(Col4,courses);
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_NAME+Language, null, contentValues);
        return result != -1;
    }

    public boolean addDataEvent(String course, String time, String courses, String location){
        String Phonelanguage = Locale.getDefault().getLanguage();
        if(Phonelanguage.equals("nl")){
            Language = "NL";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col5,course);
        contentValues.put(Col6,time);
        contentValues.put(Col7,courses);
        contentValues.put(Col8,location);
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_NAME1 +Language, null, contentValues);
        return result != -1;
    }

    public Cursor fetch_row(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, int row_id) {
        return myDataBase.query("Homepage", null, "_id=" + row_id, null, null, null, null);
    }

    public Cursor fetch_item(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, int row_id,String Table) {
        return myDataBase.query(Table,columns , "_id=" + row_id, null, null, null, null);
    }

    public void purgeDatabase(Context context) {
        context.deleteDatabase("MyDatabase");
    }






}

