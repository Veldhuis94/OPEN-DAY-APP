package com.group5.cmiopenday;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.CalendarContract;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class PopActivity extends Activity {
    static int popUpId;

    final String date = "04-06-2019";
    final int[] dateArray = {04, 06, 2019, 17, 00, 20, 00};
    int sharetextcount = 0;
    boolean extra ;
    String sharetext = "";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);


        //share button calls the function shareONOtherSocialMedia
        ImageButton shareButton = findViewById(R.id.imageButton);
        final Context context = this;
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareOnOtherSocialMedia(context);


            }
        });

        ImageButton noteButton = findViewById(R.id.imageButton2);
        final Context context1 = this;
        noteButton.setOnClickListener(new View.OnClickListener(){
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
                Toast.makeText(PopActivity.this, getString(R.string.calendarMessage), Toast.LENGTH_SHORT).show();
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


        int[] courseId = {R.array.CourseNameArray};
        int[] courseText = {R.id.textView18};

        for(int o = 0; o < courseText.length; o++){
            String[] firstCourse = getResources().getStringArray(courseId[o]);
            TextView firstCourseView = findViewById(courseText[o]);
            firstCourseView.setText(firstCourse[popUpId]);
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
            sharetextcount= x;
            sharetext();

        }
        public void shareText(){
            if(sharetextcount==1){
                sharetext = "fgff";

            }
        }

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
                if (packageName.toLowerCase().contains("twitter") || packageName.toLowerCase().contains("whatsapp") || packageName.toLowerCase().contains("email") || packageName.toLowerCase().contains("gm")) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(packageName, resInfo.activityInfo.name));
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String shareBody = "CMI OPEN DAY";
                    String shareSub = "On " + date + sharetext;
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
                Intent chooserIntent = Intent.createChooser(shareIntentsLists.remove(0), "Choose app to share");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, shareIntentsLists.toArray(new Parcelable[]{}));
                context.startActivity(chooserIntent);
            } else
                Toast.makeText(PopActivity.this,"No memo app installed",Toast.LENGTH_SHORT).show();

        }
    }

}

//        DatabaseHelper myDbHelper = new DatabaseHelper(PopActivity.this);//Database
//        StringBuilder stringBuilder_time_1 = new StringBuilder();
//        StringBuilder stringBuilder_time_2 = new StringBuilder();
//        StringBuilder stringBuilder_time_3 = new StringBuilder();
//        StringBuilder stringBuilder_room = new StringBuilder();
//        StringBuilder stringBuilder_text = new StringBuilder();
//        TextView textView15 = findViewById(R.id.textView15);//time1
//        TextView textView21 = findViewById(R.id.textView21);//time2
//        TextView textView23 = findViewById(R.id.textView23);//time3
//        TextView textView25 = findViewById(R.id.textView25);//Room1
//        TextView textView26 = findViewById(R.id.textView26);//Room2
//        TextView textView27 = findViewById(R.id.textView27);//Room3
//        TextView textView28 = findViewById(R.id.textView28);//Text
//        myDbHelper.openDataBase();
//        PopUpinfo = myDbHelper.fetch_item("PopUps", null, null, null, null, null, null, popUpId, "PopUps");
//        if (PopUpinfo.moveToFirst()) {
//            do {
//                stringBuilder_time_1.append(PopUpinfo.getString(2));
//                stringBuilder_time_2.append(PopUpinfo.getString(3));
//                stringBuilder_time_3.append(PopUpinfo.getString(4));
//                stringBuilder_room.append(PopUpinfo.getString(5));
//                stringBuilder_text.append(PopUpinfo.getString(6));
//            } while (PopUpinfo.moveToNext());

//            textView15.setText(stringBuilder_time_1);
//            textView21.setText(stringBuilder_time_2);
//            textView23.setText(stringBuilder_time_3);
//            textView25.setText(stringBuilder_room);
//            textView26.setText(stringBuilder_room);
//            textView27.setText(stringBuilder_room);
//            textView28.setText(stringBuilder_text);
