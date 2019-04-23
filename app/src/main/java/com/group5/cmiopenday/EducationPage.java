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

        if (currentPageId == 0) {
            TextView studyCourseText = findViewById(R.id.textView5);
            studyCourseText.setText(R.string.informaticainfo);
            TextView studyCourseHead = findViewById(R.id.textView6);
            studyCourseHead.setText(R.string.informatica);
        }
        if (currentPageId == 1) {
            TextView studyCourseText = findViewById(R.id.textView5);
            studyCourseText.setText(R.string.communicatieinfo);
            TextView studyCourseHead = findViewById(R.id.textView6);
            studyCourseHead.setText(R.string.communicatie);

        }
    }
}
