package com.group5.cmiopenday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends menu_Activity{
    private Button button;
    EditText editText_Date, editText_Time, editText_Courses;
    DatabaseHelper myDatabase;
    private Button buttonadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer(savedInstanceState);

        //editText_Date = findViewById(R.id.editext_Date);
        //editText_Time = findViewById(R.id.editext_Time);
        //editText_Courses = findViewById(R.id.editext_Courses);

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


