package com.group5.cmiopenday;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class onClickOpenDayPage implements View.OnClickListener {
    public int pageId;
    Activity activity;
    public onClickOpenDayPage(int pageId, Activity activity) {
        this.pageId = pageId;
        this.activity = activity;
    }
    @Override
    public void onClick(View v) {
        this.activity.startActivity(new Intent(v.getContext(), openDayDetails.class));
        openDayDetails.currentPageId = pageId;
    }
}
