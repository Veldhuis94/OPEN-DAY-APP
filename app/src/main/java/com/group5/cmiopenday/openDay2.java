package com.group5.cmiopenday;



import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;



public class openDay2 extends menu_Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_day_layout);
        super.onCreateDrawer(savedInstanceState);

        final String date = "04-06-2019";
        final int[] dateArray = {04, 06, 2019, 17, 00, 20, 00};

        ImageButton shareButton = findViewById(R.id.button2);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "CMI OPEN DAY";
                String shareSub = getString(R.string.shareBody1) + date + getString(R.string.shareBody2);
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(myIntent, getString(R.string.shareString)));
            }
        });

        Button openDay1 = findViewById(R.id.button3);
        openDay1.setOnClickListener(new onClickPopUp(4, this));
        Button openDay2 = findViewById(R.id.button4);
        openDay2.setOnClickListener(new onClickPopUp(5, this));
        Button openDay3 = findViewById(R.id.button5);
        openDay3.setOnClickListener(new onClickPopUp(6, this));
        Button openDay4 = findViewById(R.id.button6);
        openDay4.setOnClickListener(new onClickPopUp(7, this));




        ImageButton calendarButton = findViewById(R.id.button);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(openDay2.this, getString(R.string.calendarMessage), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("title", getString(R.string.calendarTitle));
                intent.putExtra("description", getString(R.string.calendarBody) + date);
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(dateArray[2], dateArray[1], dateArray[0], dateArray[3], dateArray[4]);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                Calendar endTime = Calendar.getInstance();
                endTime.set(dateArray[2], dateArray[1], dateArray[0], dateArray[5], dateArray[6]);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
                startActivity(intent);
            }
        });
    }


}
