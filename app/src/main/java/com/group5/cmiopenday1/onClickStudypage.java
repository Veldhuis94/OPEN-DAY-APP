package com.group5.cmiopenday1;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class onClickStudypage implements View.OnClickListener {
    public int pageId;
    Activity activity;
    public onClickStudypage(int pageId, Activity activity) {
        this.pageId = pageId;
        this.activity = activity;
    }
    @Override
    public void onClick(View v) {
        this.activity.startActivity(new Intent(v.getContext(), EducationPage.class)); //start the activity EducationPage

        EducationPage.currentPageId = pageId; //pass pageId to the new instance of EducationPage
    }


}
