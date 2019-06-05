package com.group5.cmiopenday;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends menu_Activity{
    private Button button;
    private Button button21;
    Cursor row_1 = null;
    Cursor row_2 = null;
    private ImageView loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer(savedInstanceState);
        DatabaseHelper myDbHelper = new DatabaseHelper(MainActivity.this);//Database
        StringBuilder stringBuilder_row_1 = new StringBuilder();
        StringBuilder stringBuilder_row_2 = new StringBuilder();
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        myDbHelper.openDataBase();
        row_1 = myDbHelper.fetch_row("Homepage", null, null, null, null, null, null,1);
        row_2 = myDbHelper.fetch_row("Homepage", null, null, null, null, null, null,2);
        if (row_1.moveToFirst()) {
            do {
                stringBuilder_row_1.append("CMI Open Day, "+row_1.getString(1)+"\nTime: "+row_1.getString(2)+"\n"+row_1.getString(3));
            } while (row_1.moveToNext());
        }
        if (row_2.moveToFirst()) {
            do {
                stringBuilder_row_2.append("CMI Open Day, "+row_2.getString(1)+"\nTime: "+row_2.getString(2)+"\n"+row_2.getString(3));
            } while (row_2.moveToNext());
        }
        textView2.setText(stringBuilder_row_1);
        textView3.setText(stringBuilder_row_2);//Database

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, openDay2.class));
            }
        });
        //get the texts of both open days and fill it in with the full dates
//        TextView firstOpenDay = findViewById(R.id.opendaytext_1);
//        TextView secondOpenDay = findViewById(R.id.opendaytext_2);
//        firstOpenDay.setText(String.format(firstOpenDay.getText().toString(), DateUtility.getFullDate(4,4, 2019)));
//        secondOpenDay.setText(String.format(secondOpenDay.getText().toString(), DateUtility.getFullDate(4,6, 2019)));


        button = findViewById(R.id.button);
        loginbtn = findViewById(R.id.loggbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpenDayDetails();
            }
        });

        ((Button) findViewById(R.id.button21)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDbHelper = new DatabaseHelper(MainActivity.this);
                myDbHelper.close();
                myDbHelper.purgeDatabase(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Database reloaded", Toast.LENGTH_SHORT).show();
            }

        });

    }




    public void openOpenDayDetails(){
        Intent intent = new Intent(this,openDayDetails.class);
        startActivity(intent);
    }





}


