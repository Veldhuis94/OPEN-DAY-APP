package com.group5.cmiopenday1;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class onClickResultpage implements View.OnClickListener {
    Questionnaire activity;
    public onClickResultpage(Questionnaire activity) {
        this.activity = activity;
    }
    @Override
    public void onClick (View v) {
        int result = activity.scoreCalculate();
        if (result <= -1) {
            TextView scoreDisplay = activity.findViewById(R.id.SCOREVIEW);
            scoreDisplay.setText(activity.getResources().getString(R.string.questionnaire_incomplete));
        }
        else {
            this.activity.startActivity(new Intent(v.getContext(), resultPage.class));
            resultPage.finalResult = result;
        }
    }
}
