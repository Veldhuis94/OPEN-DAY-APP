package com.group5.cmiopenday;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends menu_Activity{
    private Button button;
    private Button button21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer(savedInstanceState);
        DatabaseHelper myDbHelper = new DatabaseHelper(MainActivity.this);
        TextView textView2 = findViewById(R.id.textView2);
        Cursor cursor = myDbHelper.ViewData();
        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext()){
            stringBuilder.append("CMI Open Day, Date: "+cursor.getString(1)+"\nTime: "+cursor.getString(2)+"\n"+cursor.getString(3));
       }
        textView2.setText(stringBuilder);

        Button button21 = findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CopyDatabase.class));
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpenDayDetails();
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, openDay2.class));
            }
        });
    }



    public void openOpenDayDetails(){
        Intent intent = new Intent(this,openDayDetails.class);
        startActivity(intent);
    }





}


