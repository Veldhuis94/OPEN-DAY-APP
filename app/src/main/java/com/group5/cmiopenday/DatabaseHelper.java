package com.group5.cmiopenday;

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

import static android.content.ContentValues.TAG;


public class DatabaseHelper extends SQLiteOpenHelper {

    String DB_PATH = null;
    private static String DB_NAME = "MyDatabase";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    int row_id = 0;

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

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
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

    public void deleteAll() {
        SQLiteDatabase myDbHelper = this.getWritableDatabase();
        myDbHelper.execSQL("delete from " + "Homepage");
        myDbHelper.close();

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

    public Cursor fetch_row(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, int row_id) {
        return myDataBase.query("Homepage", null, "_id=" + row_id, null, null, null, null);
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy,String Table) {
        return myDataBase.query("Homepage", null, null, null, null, null, null);
    }
    public Cursor fetch_item(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, int row_id,String Table) {
        return myDataBase.query(Table,columns , "_id=" + row_id, null, null, null, null);
    }

    public Cursor ViewData() {
        SQLiteDatabase myDbHelper = this.getReadableDatabase();

        Cursor cursor = myDbHelper.rawQuery("select * from " + DB_NAME, null);
        return cursor;
    }


    public void purgeDatabase(Context context) {
        context.deleteDatabase("MyDatabase");
    }






}
