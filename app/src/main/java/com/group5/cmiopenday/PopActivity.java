package com.group5.cmiopenday;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

public class PopActivity extends Activity {
    static int popUpId;
//    Cursor PopUpinfo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .800), (int) (height * .70));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 10;
        params.y = -20;

        getWindow().setAttributes(params);
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
//           textView26.setText(stringBuilder_room);
//            textView27.setText(stringBuilder_room);
//            textView28.setText(stringBuilder_text);


            int[] ids = {R.array.firstTimeArray, R.array.secondTimeArray, R.array.thirdTimeArray};
            int[] textViews = {R.id.textView15, R.id.textView21, R.id.textView23};

            for (int i = 0; i < textViews.length; i++) {
                String[] firstTime = getResources().getStringArray(ids[i]);
                TextView firstTimeView = findViewById(textViews[i]);
                firstTimeView.setText(firstTime[popUpId]);
            }

            int[] classid = {R.array.firstClassroomArray, R.array.secondClassroomArray, R.array.thirdClassroomArray};
            int[] classrooms = {R.id.textView25, R.id.textView26, R.id.textView27};

            for (int l = 0; l < classrooms.length; l++) {
                String[] firstClassroom = getResources().getStringArray(classid[l]);
                TextView firstClassroomView = findViewById(classrooms[l]);
                firstClassroomView.setText(firstClassroom[popUpId]);
            }

            int[] projectId = {R.array.StudyProjectArray};
            int[] projectText = {R.id.textView28};

            for (int x = 0; x < projectText.length; x++) {
                String[] firstProject = getResources().getStringArray(projectId[x]);
                TextView firstProjectView = findViewById(projectText[x]);
                firstProjectView.setText(firstProject[popUpId]);
            }

        }
    }





