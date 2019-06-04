package com.group5.cmiopenday;



import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;

import java.util.EventListener;

import java.util.List;


public class openDayDetails extends menu_Activity {



    final String date = "04-04-2019";
    final int[] dateArray = {04, 04, 2019, 12, 00, 16, 00};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_day_layout);
        super.onCreateDrawer(savedInstanceState);


        ImageButton shareButton = findViewById(R.id.button2);
        final Context context = this;
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareOnOtherSocialMedia(context);


            }
        });

        Button openDay1 = findViewById(R.id.button3);
        openDay1.setOnClickListener(new onClickPopUp(0, this));
        Button openDay2 = findViewById(R.id.button4);
        openDay2.setOnClickListener(new onClickPopUp(1, this));
        Button openDay3 = findViewById(R.id.button5);
        openDay3.setOnClickListener(new onClickPopUp(2, this));
        Button openDay4 = findViewById(R.id.button6);
        openDay4.setOnClickListener(new onClickPopUp(3, this));


        ImageButton calendarButton = findViewById(R.id.button);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(openDayDetails.this, getString(R.string.calendarMessage), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("title", getString(R.string.calendarTitle));
                intent.putExtra("description", getString(R.string.calendarBody) + date);
                //intent.putExtra("Wijnhaven",103);
                //intent.putExtra(Events.EVENT_LOCATION, "Wijnhaven 103/107");
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(dateArray[2], dateArray[1], dateArray[0], dateArray[3], dateArray[4]);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                //CHANGE LOCATION IF NEEDED
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Wijnhaven 103/107, Rotterdam");

                Calendar endTime = Calendar.getInstance();


                endTime.set(dateArray[2], dateArray[1], dateArray[0], dateArray[5], dateArray[6]);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
                startActivity(intent);
            }
        });
    }

    public void shareOnOtherSocialMedia(Context context) {

        List<Intent> shareIntentsLists = new ArrayList<Intent>();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        List<ResolveInfo> resInfos = context.getPackageManager().queryIntentActivities(shareIntent, 0);
        if (!resInfos.isEmpty()) {
            for (ResolveInfo resInfo : resInfos) {
                String packageName = resInfo.activityInfo.packageName;
                if (packageName.toLowerCase().contains("twitter") || packageName.toLowerCase().contains("facebook") || packageName.toLowerCase().contains("whatsapp") || packageName.toLowerCase().contains("email") || packageName.toLowerCase().contains("gm")) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(packageName, resInfo.activityInfo.name));
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String shareBody = "CMI OPEN DAY";
                    String shareSub = "On " + date + ", I am going to an open day at the CMI of the Rotterdam University of Applied Sciences! Learn more at https://www.hogeschoolrotterdam.nl/";
                    intent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                    intent.putExtra(Intent.EXTRA_TEXT, shareSub);
                    intent.setPackage(packageName);
                    shareIntentsLists.add(intent);
                }
            }
            if (!shareIntentsLists.isEmpty()) {
                Intent chooserIntent = Intent.createChooser(shareIntentsLists.remove(0), "Choose app to share");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, shareIntentsLists.toArray(new Parcelable[]{}));
                context.startActivity(chooserIntent);
            } else
                Toast.makeText(openDayDetails.this, "Error", Toast.LENGTH_SHORT).show();

        }



    }

}