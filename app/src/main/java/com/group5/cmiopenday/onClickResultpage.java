package com.group5.cmiopenday;

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
        TextView scoreDisplay = activity.findViewById(R.id.SCOREVIEW);
        if (result <= -1) {
            scoreDisplay.setText(activity.getResources().getString(R.string.questionnaire_incomplete));
        }
        else {
            this.activity.startActivity(new Intent(v.getContext(), resultPage.class));
            resultPage.finalResult = activity.scoreCalculate();
        }
    }
}
