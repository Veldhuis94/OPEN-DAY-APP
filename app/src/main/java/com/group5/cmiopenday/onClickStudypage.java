package com.group5.cmiopenday;

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
        Intent intent = new Intent(v.getContext(), EducationPage.class);
        this.activity.startActivity(intent);

        EducationPage.currentPageId = pageId;
    }
}
