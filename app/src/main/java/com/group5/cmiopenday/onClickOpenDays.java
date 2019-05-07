package com.group5.cmiopenday;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class onClickOpenDays implements View.OnClickListener{
    int pageId;
    int[] dateArray;
    Activity activity;

    public onClickOpenDays(int pageId, int[] dateArray, Activity activity) {
        this.pageId = pageId;
        this.dateArray = dateArray;
        this.activity = activity;
    }
    public void onClick(View v) {
        this.activity.startActivity(new Intent(v.getContext(), openDayDetails.class));
    }
}
