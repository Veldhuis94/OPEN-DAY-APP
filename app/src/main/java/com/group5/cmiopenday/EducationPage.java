package com.group5.cmiopenday;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class EducationPage extends MainActivity{
    static int currentPageId; //received from onClickStudypage
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //load layout
        setContentView(R.layout.activity_education_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //set strings for proper display of correct page
        String[] bodyStrings = getResources().getStringArray(R.array.studyCourseBody); //fetch array of strings for Body
        TextView studyCourseText = findViewById(R.id.textView5); //fetch TextView for Body
        studyCourseText.setText(bodyStrings[currentPageId]); //set the string to be displayed in the body, indicated by currentPageId
        String[] headerStrings = getResources().getStringArray(R.array.studyCourseHeader); //fetch array of strings for Header
        TextView studyCourseHead = findViewById(R.id.textView6); //fetch TextView for header
        studyCourseHead.setText(headerStrings[currentPageId]);//set the string to be displayed in the Header, as indicated by currentPageId



    }

}
