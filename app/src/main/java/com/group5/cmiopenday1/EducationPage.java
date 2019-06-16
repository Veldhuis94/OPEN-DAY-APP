package com.group5.cmiopenday1;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EducationPage extends menu_Activity{
    static int currentPageId; //received from onClickStudypage


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //load layout
        setContentView(R.layout.activity_education_page);
        super.onCreateDrawer(savedInstanceState);


        Button questionnairebutton = findViewById(R.id.questionnairebutton);
        questionnairebutton.setOnClickListener(new onClickQuestionnaire(currentPageId, this));

        //set strings for proper display of correct page
        String[] bodyStrings = getResources().getStringArray(R.array.studyCourseBody); //fetch array of strings for Body
        TextView studyCourseText = findViewById(R.id.textView5); //fetch TextView for Body
        studyCourseText.setText(bodyStrings[currentPageId]); //set the string to be displayed in the body, indicated by currentPageId
        String[] headerStrings = getResources().getStringArray(R.array.studyCourseHeader); //fetch array of strings for Header
        TextView studyCourseHead = findViewById(R.id.textView6); //fetch TextView for header
        studyCourseHead.setText(headerStrings[currentPageId]);//set the string to be displayed in the Header, as indicated by currentPageId



    }

}
