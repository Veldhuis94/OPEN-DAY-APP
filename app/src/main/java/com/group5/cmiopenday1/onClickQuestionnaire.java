package com.group5.cmiopenday1;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class onClickQuestionnaire implements View.OnClickListener {
    public int PageId;
    Activity activity;
    public onClickQuestionnaire(int PageId, Activity activity) {
        this.PageId = PageId;
        this.activity = activity;
    }
    @Override
    public void onClick (View v) {
        this.activity.startActivity(new Intent(v.getContext(), Questionnaire.class));
        Questionnaire.currentPageId = PageId;
    }
}
