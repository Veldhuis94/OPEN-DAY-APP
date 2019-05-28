package com.group5.cmiopenday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends menu_Activity{
    private Button button;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer(savedInstanceState);
        db = new DatabaseHelper(this);
//        boolean insert = db.insertinHomeDatabase("4-4-2019", "12:00-16:00", "Software Engineering, Computer Engineering, Communication");
//        insert = db.insertinHomeDatabase("4-6-2019", "17:00-20:00", "Software Engineering, Communication");
//       if (insert = true) {
//        Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();


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

//    }
    public void openOpenDayDetails () {
        Intent intent = new Intent(this, openDayDetails.class);
        startActivity(intent);
    }
}