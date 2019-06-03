package com.group5.cmiopenday;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class CopyDatabase extends AppCompatActivity {

    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy_database);

        ((Button) findViewById(R.id.CopyDB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDbHelper = new DatabaseHelper(CopyDatabase.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                try {
                    myDbHelper.openDataBase();
                } catch (SQLException sqle) {
                    throw sqle;
                }
                Toast.makeText(CopyDatabase.this, "Successfully Imported" , Toast.LENGTH_SHORT).show();
          //      c = myDbHelper.query("Homepage", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(CopyDatabase.this,
                                "_id: " + c.getString(0) + "\n" +
                                        "Date: " + c.getString(1) + "\n" +
                                        "Time: " + c.getString(2) + "\n" +
                                        "Courses:  " + c.getString(3),
                                Toast.LENGTH_LONG).show();
                    } while (c.moveToNext());
                }
            }
        });

    }


}
