package com.group5.cmiopenday1;



import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class openDay2 extends menu_Activity  {

    final String date = "04-06-2019";
    final int[] dateArray = {4, 6, 2019, 17, 00, 20, 00};
    Cursor course_1 = null;
    Cursor course_2 = null;
    Cursor course_3 = null;
    Cursor course_4 = null;
    String Language = "";
    String Room = "Room: ";
    String Time = "Time: ";
    String Location = "Location: ";


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
        DatabaseHelper myDbHelper = new DatabaseHelper(openDay2.this);//Database
        myDbHelper.openDataBase();
        TextView textView = findViewById(R.id.textView);//course 1
        StringBuilder stringBuilder_course_1 = new StringBuilder();
        TextView textView2 = findViewById(R.id.textView2);//info 1
        StringBuilder stringBuilder_info_1 = new StringBuilder();
        TextView textView3 = findViewById(R.id.textView3);//course 2
        StringBuilder stringBuilder_course_2 = new StringBuilder();
        TextView textView4 = findViewById(R.id.textView4);//info 2
        StringBuilder stringBuilder_info_2 = new StringBuilder();
        TextView textView5 = findViewById(R.id.textView5);//course 3
        StringBuilder stringBuilder_course_3 = new StringBuilder();
        TextView textView6 = findViewById(R.id.textView6);//info 3
        StringBuilder stringBuilder_info_3 = new StringBuilder();
        TextView textView7 = findViewById(R.id.textView7);//course 4
        StringBuilder stringBuilder_course_4 = new StringBuilder();
        TextView textView8 = findViewById(R.id.textView8);//info 4
        StringBuilder stringBuilder_info_4 = new StringBuilder();


        String PhoneLanguage = Locale.getDefault().getLanguage();//Gets phone language
        if(PhoneLanguage.equals("nl")){
            Language = "NL";
            Room = "Kamer: ";
            Time = "Tijd: ";
            Location = "Locatie: ";//Changes to dutch table
        }

        course_1 = myDbHelper.fetch_item("OpenDays", null, null, null, null, null, null,4,"OpenDays"+Language);
        course_2 = myDbHelper.fetch_item("OpenDays", null, null, null, null, null, null,5,"OpenDays"+Language);
        course_3 = myDbHelper.fetch_item("OpenDays", null, null, null, null, null, null,6,"OpenDays"+Language);
        course_4 = myDbHelper.fetch_item("OpenDays", null, null, null, null, null, null,7,"OpenDays"+Language);

        if (course_1.moveToFirst()) {
            do {
                stringBuilder_course_1.append(course_1.getString(2));
                stringBuilder_info_1.append(Room+course_1.getString(3)+" | "+Time+course_1.getString(4)+"\n"+Location+course_1.getString(5));
            } while (course_1.moveToNext());
        }

        if (course_2.moveToFirst()) {
            do {
                stringBuilder_course_2.append(course_2.getString(2));
                stringBuilder_info_2.append(Room+course_2.getString(3)+" | "+Time+course_2.getString(4)+"\n"+Location+course_2.getString(5));
            } while (course_2.moveToNext());
        }

        if (course_3.moveToFirst()) {
            do {
                stringBuilder_course_3.append(course_3.getString(2));
                stringBuilder_info_3.append(Room+course_3.getString(3)+" | "+Time+course_3.getString(4)+"\n"+Location+course_3.getString(5));
            } while (course_3.moveToNext());
        }

        if (course_4.moveToFirst()) {
            do {
                stringBuilder_course_4.append(course_4.getString(2));
                stringBuilder_info_4.append(Room+course_4.getString(3)+" | "+Time+course_4.getString(4)+"\n"+Location+course_4.getString(5));
            } while (course_4.moveToNext());

        }
        textView.setText(stringBuilder_course_1);
        textView2.setText(stringBuilder_info_1);
        textView3.setText(stringBuilder_course_2);
        textView4.setText(stringBuilder_info_2);
        textView5.setText(stringBuilder_course_3);
        textView6.setText(stringBuilder_info_3);
        textView7.setText(stringBuilder_course_4);
        textView8.setText(stringBuilder_info_4);

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
                //CHANGE LOCATION ID NEEDED
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
                if (packageName.toLowerCase().contains("twitter")  || packageName.toLowerCase().contains("whatsapp") || packageName.toLowerCase().contains("email") || packageName.toLowerCase().contains("gm")) {
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
                Toast.makeText(openDay2.this,"Error",Toast.LENGTH_SHORT).show();

        }
    }

}
