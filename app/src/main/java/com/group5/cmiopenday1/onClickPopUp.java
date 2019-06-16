package com.group5.cmiopenday1;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class onClickPopUp implements View.OnClickListener {
    public int pUpId;
    Activity activity;
    public onClickPopUp(int pUpId, Activity activity) {
        this.pUpId = pUpId;
        this.activity = activity;
    }
    @Override
    public void onClick(View v) {
        this.activity.startActivity(new Intent(v.getContext(), PopActivity.class));
        PopActivity.popUpId = pUpId;
    }
}
