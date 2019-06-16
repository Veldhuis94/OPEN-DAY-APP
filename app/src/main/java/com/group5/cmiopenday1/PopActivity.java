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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class PopActivity extends menu_Activity {
    static int popUpId;
    Cursor PopUp_info = null;
    String Language = "";

    final String date = "04-06-2019";
    final int[] dateArray = {04, 06, 2019, 17, 00, 20, 00};
    int sharetextcount =0;
    boolean extra ;
    TextView shareText;
    TextView CalendarText;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        super.onCreateDrawer(savedInstanceState);




        //share button calls the function shareONOtherSocialMedia
        ImageButton shareButton = findViewById(R.id.imageButton);
        final Context context = this;
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getText();
                //shareMessage();
                shareOnOtherSocialMedia(context);


            }
        });

        ImageButton noteButton = findViewById(R.id.imageButton2);
        final Context context1 = this;
        noteButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openNoteApp(context1);


            }
        });

        //code for the add to calendar button
        ImageButton calendarButton = findViewById(R.id.imageButton3);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarText = findViewById(R.id.textView101);
                String calendartext = CalendarText.getText().toString();
                Toast.makeText(PopActivity.this, getString(R.string.calendarMessage), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("title", getString(R.string.calendarTitle)+ " "+ calendartext);
                intent.putExtra("description", getString(R.string.calendarBody) +" " + date + " "+calendartext);
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(dateArray[2], dateArray[1], dateArray[0], dateArray[3], dateArray[4]);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                Calendar endTime = Calendar.getInstance();
                endTime.set(dateArray[2], dateArray[1], dateArray[0], dateArray[5], dateArray[6]);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
                startActivity(intent);
            }
        });


        int[] courseId = {R.array.CourseNameArray};
        int[] courseText = {R.id.textView18};

        for(int o = 0; o < courseText.length; o++){
            String[] firstCourse = getResources().getStringArray(courseId[o]);
            TextView firstCourseView = findViewById(courseText[o]);
            firstCourseView.setText(firstCourse[popUpId]);


        DatabaseHelper myDbHelper = new DatabaseHelper(PopActivity.this);//Database

        StringBuilder stringBuilder_time_1 = new StringBuilder();
        StringBuilder stringBuilder_time_2 = new StringBuilder();
        StringBuilder stringBuilder_time_3 = new StringBuilder();
        StringBuilder stringBuilder_room = new StringBuilder();
        StringBuilder stringBuilder_text = new StringBuilder();
        StringBuilder stringBuilder_title = new StringBuilder();
        TextView textView15 = findViewById(R.id.textView15);//time1
        TextView textView21 = findViewById(R.id.textView21);//time2
        TextView textView18 = findViewById(R.id.textView18);//title
        TextView textView23 = findViewById(R.id.textView23);//time3
        TextView textView25 = findViewById(R.id.textView25);//Room1
        TextView textView26 = findViewById(R.id.textView26);//Room2
        TextView textView27 = findViewById(R.id.textView27);//Room3
        TextView textView28 = findViewById(R.id.textView28);//Text

        String PhoneLanguage = Locale.getDefault().getLanguage();//Checks if phone language is NL

        if(PhoneLanguage.equals("nl")){
            Language = "NL";}

        myDbHelper.openDataBase();

        if (popUpId == 0) {
           PopUp_info = myDbHelper.fetch_item("PopUps", null, null, null, null, null, null, 1, "PopUps"+Language);}
        if ((popUpId == 1)){
           PopUp_info = myDbHelper.fetch_item("PopUps", null, null, null, null, null, null, 2, "PopUps"+Language);}
        if (popUpId == 2) {
           PopUp_info = myDbHelper.fetch_item("PopUps", null, null, null, null, null, null, 3, "PopUps"+Language);}
        if ((popUpId == 3)){
           PopUp_info = myDbHelper.fetch_item("PopUps", null, null, null, null, null, null, 4, "PopUps"+Language);}
        if (popUpId == 4) {
            PopUp_info = myDbHelper.fetch_item("PopUps", null, null, null, null, null, null, 5, "PopUps"+Language);}
        if ((popUpId == 5)){
            PopUp_info = myDbHelper.fetch_item("PopUps", null, null, null, null, null, null, 6, "PopUps"+Language);}
        if (popUpId == 6) {
            PopUp_info = myDbHelper.fetch_item("PopUps", null, null, null, null, null, null, 7, "PopUps"+Language);}
        if ((popUpId == 7)){
            PopUp_info = myDbHelper.fetch_item("PopUps", null, null, null, null, null, null, 8, "PopUps"+Language);}//Checks which popup to show


        if (PopUp_info.moveToFirst()) {
            do {
                stringBuilder_time_1.append(PopUp_info.getString(1));
                stringBuilder_time_2.append(PopUp_info.getString(2));
                stringBuilder_time_3.append(PopUp_info.getString(3));
                stringBuilder_room.append(PopUp_info.getString(4));
                stringBuilder_text.append(PopUp_info.getString(5));
                stringBuilder_title.append(PopUp_info.getString(6));
            } while (PopUp_info.moveToNext());

            textView15.setText(stringBuilder_time_1);
            textView21.setText(stringBuilder_time_2);
            textView23.setText(stringBuilder_time_3);
            textView25.setText(stringBuilder_room);
            textView26.setText(stringBuilder_room);
            textView27.setText(stringBuilder_room);
            textView28.setText(stringBuilder_text);
            textView18.setText(stringBuilder_title);

        }
    }



        int[] ids = {R.array.firstTimeArray, R.array.secondTimeArray, R.array.thirdTimeArray};
        int[] textViews = {R.id.textView15, R.id.textView21, R.id.textView23};

        for (int i = 0; i < textViews.length; i++) {
            String[] firstTime = getResources().getStringArray(ids[i]);
            TextView firstTimeView = findViewById(textViews[i]);
            firstTimeView.setText(firstTime[popUpId]);
        }

        int[] classid = {R.array.firstClassroomArray, R.array.secondClassroomArray, R.array.thirdClassroomArray};
        int[] classrooms = {R.id.textView25, R.id.textView26, R.id.textView27};

        for(int l = 0; l< classrooms.length; l++){
            String[] firstClassroom = getResources().getStringArray(classid[l]);
            TextView firstClassroomView = findViewById(classrooms[l]);
            firstClassroomView.setText(firstClassroom[popUpId]);
        }
        //text for all study studyprojects. You can find it in strings.
        int[] projectId = {R.array.StudyProjectArray};
        int[] projectText = {R.id.textView28};

        for(int x = 0; x < projectText.length; x++){
            String[] firstProject = getResources().getStringArray(projectId[x]);
            TextView firstProjectView = findViewById(projectText[x]);
            firstProjectView.setText(firstProject[popUpId]);



        }

        int[] shareId = {R.array.ShareTextArray};
        int[] shareText = {R.id.textView100};

        for(int z = 0; z < shareText.length; z++) {
            String[] firstShare = getResources().getStringArray(shareId[z]);
            TextView firstShareView = findViewById(shareText[z]);
            firstShareView.setText(firstShare[popUpId]);

        }

        int[] CalendarId = {R.array.CalendarTextArray};
        int[] CalendarText = {R.id.textView101};

        for(int q = 0; q < CalendarText.length; q++) {
            String[] firstCalendar = getResources().getStringArray(CalendarId[q]);
            TextView firstCalendarView = findViewById(CalendarText[q]);
            firstCalendarView.setText(firstCalendar[popUpId]);

        }




    }










    public void shareOnOtherSocialMedia(Context context) {
        shareText = findViewById(R.id.textView100);
        String sharetext = shareText.getText().toString();
        List<Intent> shareIntentsLists = new ArrayList<Intent>();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        List<ResolveInfo> resInfos = context.getPackageManager().queryIntentActivities(shareIntent, 0);
        if (!resInfos.isEmpty()) {
            for (ResolveInfo resInfo : resInfos) {
                String packageName = resInfo.activityInfo.packageName;
                if (packageName.toLowerCase().contains("twitter") || packageName.toLowerCase().contains("whatsapp") || packageName.toLowerCase().contains("email") || packageName.toLowerCase().contains("gm")) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(packageName, resInfo.activityInfo.name));
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String shareBody = "CMI OPEN DAY";
                    String shareSub = "On " + date + " " + sharetext;
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
                Toast.makeText(PopActivity.this,"Error",Toast.LENGTH_SHORT).show();

        }
    }

    public void openNoteApp(Context context) {

        List<Intent> shareIntentsLists = new ArrayList<Intent>();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        List<ResolveInfo> resInfos = context.getPackageManager().queryIntentActivities(shareIntent, 0);
        if (!resInfos.isEmpty()) {
            for (ResolveInfo resInfo : resInfos) {
                String packageName = resInfo.activityInfo.packageName;
                if (packageName.toLowerCase().contains("keep") || packageName.toLowerCase().contains("note") || packageName.toLowerCase().contains("notes") || packageName.toLowerCase().contains("memo") ) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(packageName, resInfo.activityInfo.name));
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    //String shareBody = "CMI OPEN DAY";
                    //String shareSub = "On " + date + ", I am going to an open day at the CMI of the Rotterdam University of Applied Sciences! Learn more at https://www.hogeschoolrotterdam.nl/";
                    //intent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                    //intent.putExtra(Intent.EXTRA_TEXT, shareSub);
                    intent.setPackage(packageName);
                    shareIntentsLists.add(intent);
                }
            }
            if (!shareIntentsLists.isEmpty()) {
                Intent chooserIntent = Intent.createChooser(shareIntentsLists.remove(0), "Choose a note app");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, shareIntentsLists.toArray(new Parcelable[]{}));
                context.startActivity(chooserIntent);
            } else
                Toast.makeText(PopActivity.this,"No memo app installed",Toast.LENGTH_SHORT).show();

        }
    }

}

