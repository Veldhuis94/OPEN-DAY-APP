package com.group5.cmiopenday;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class EducationPage extends menu_Activity{
    static int currentPageId; //received from onClickStudypage


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //load layout
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_education_page);
        super.onCreateDrawer(savedInstanceState);




        //set strings for proper display of correct page
        String[] bodyStrings = getResources().getStringArray(R.array.studyCourseBody); //fetch array of strings for Body
        TextView studyCourseText = findViewById(R.id.textView5); //fetch TextView for Body
        studyCourseText.setText(bodyStrings[currentPageId]); //set the string to be displayed in the body, indicated by currentPageId
        String[] headerStrings = getResources().getStringArray(R.array.studyCourseHeader); //fetch array of strings for Header
        TextView studyCourseHead = findViewById(R.id.textView6); //fetch TextView for header
        studyCourseHead.setText(headerStrings[currentPageId]);//set the string to be displayed in the Header, as indicated by currentPageId



    }

}
