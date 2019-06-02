package com.group5.cmiopenday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Questionnaire extends AppCompatActivity {

    Button[] answers = {findViewById(R.id.q1a1), findViewById(R.id.q1a2), findViewById(R.id.q1a3), findViewById(R.id.q1a3), findViewById(R.id.q2a1), findViewById(R.id.q2a2), findViewById(R.id.q2a3), findViewById(R.id.q3a1), findViewById(R.id.q3a2), findViewById(R.id.q3a3)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        int finalScore = onClickEvent();
        final int finalScoreSend = finalScore;

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Questionnaire.this, resultPage.class));
                resultPage.finalResult = finalScoreSend;
            }
        });
    }
    private int onClickEvent() {
        final int disabledColor = R.color.secondary2;
        final int enabledColor = R.color.secondary1;
        final int[] returnScores = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int ResultScore = 0;
        for(int id = 0; id <= 9; id ++) {
            if(id == 0 || id == 3 || id == 6) {
                final int finalId = id;
                answers[finalId].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answers[finalId].setBackgroundColor(getResources().getColor(enabledColor));
                        answers[finalId + 1].setBackgroundColor(getResources().getColor(disabledColor));
                        answers[finalId + 2].setBackgroundColor(getResources().getColor(disabledColor));
                        returnScores[finalId] = 1;
                    }
                });
            }
            else if(id == 1 || id == 4 || id == 7) {
                final int finalId = id;
                answers[finalId].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answers[finalId].setBackgroundColor(getResources().getColor(enabledColor));
                        answers[finalId + 1].setBackgroundColor(getResources().getColor(disabledColor));
                        answers[finalId - 1].setBackgroundColor(getResources().getColor(disabledColor));
                        returnScores[finalId] = 3;
                    }
                });
            }
            else {
                final int finalId = id;
                answers[finalId].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answers[finalId].setBackgroundColor(getResources().getColor(enabledColor));
                        answers[finalId - 1].setBackgroundColor(getResources().getColor(disabledColor));
                        answers[finalId - 2].setBackgroundColor(getResources().getColor(disabledColor));
                        returnScores[finalId] = 5;
                    }
                });
            }
            ResultScore += returnScores[id];
        }
        return ResultScore;
    }
}
