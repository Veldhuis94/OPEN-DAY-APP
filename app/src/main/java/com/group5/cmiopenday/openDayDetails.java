package com.group5.cmiopenday;



import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;



public class openDayDetails extends menu_Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_day_layout);
        super.onCreateDrawer(savedInstanceState);


        ImageButton shareButton = findViewById(R.id.button2);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Y'all finna share";
                String shareSub = "Shared from self-made android app, y'all proud of me?";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share using what?"));
            }
        });

        Button openDay1 = findViewById(R.id.button3);
        openDay1.setOnClickListener(new onClickPopUp(0, this));
        Button openDay2 = findViewById(R.id.button4);
        openDay2.setOnClickListener(new onClickPopUp(1, this));

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);

        toggle.syncState();
        Button popUpTest = findViewById(R.id.button3);
        popUpTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PopActivity.class));
            }
        });

        ImageButton calendarButton = findViewById(R.id.button);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(openDayDetails.this, "test1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("title", "test2");
                intent.putExtra("description", "Some descrsasdsaption");
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2019, 2, 19, 12, 00);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                startActivity(intent);
            }
        });
    }


}
