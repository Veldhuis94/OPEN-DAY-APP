package com.group5.cmiopenday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EducationPage extends AppCompatActivity {
    static int currentPageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_page);

        String[] bodyStrings = getResources().getStringArray(R.array.studyCourseBody);
        TextView studyCourseText = findViewById(R.id.textView5);
        studyCourseText.setText(bodyStrings[currentPageId]);
        String[] headerStrings = getResources().getStringArray(R.array.studyCourseHeader);
        TextView studyCourseHead = findViewById(R.id.textView6);
        studyCourseHead.setText(headerStrings[currentPageId]);


    }
}
