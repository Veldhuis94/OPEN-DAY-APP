package com.group5.cmiopenday;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Questionnaire extends menu_Activity {


    boolean[] isPressed = {false, false, false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        super.onCreateDrawer(savedInstanceState);
        onClickEvent();


        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalScoreSend = scoreCalculate();
                TextView scoreView = findViewById(R.id.SCOREVIEW);
                if(finalScoreSend <= 0) {
                    scoreView.setText("You have not filled in all the questions.");
                }
                else {
                    scoreView.setText("Your score is: " + finalScoreSend);
                }
            }
        });
    }
    private void onClickEvent() {
        final Button[] answers = {findViewById(R.id.q1a1), findViewById(R.id.q1a2), findViewById(R.id.q1a3), findViewById(R.id.q2a1), findViewById(R.id.q2a2), findViewById(R.id.q2a3), findViewById(R.id.q3a1), findViewById(R.id.q3a2), findViewById(R.id.q3a3)};
        final int disabledColor = R.color.secondary2;
        final int enabledColor = R.color.secondary1;


        for(int id = 0; id <= 9; id ++) {
            if(id == 0 || id == 3 || id == 6) {
                final int finalId = id;
                answers[finalId].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answers[finalId].setBackgroundColor(getResources().getColor(enabledColor));
                        answers[finalId + 1].setBackgroundColor(getResources().getColor(disabledColor));
                        answers[finalId + 2].setBackgroundColor(getResources().getColor(disabledColor));
                        isPressed[finalId] = true;
                        isPressed[finalId + 1] = false;
                        isPressed[finalId + 2] = false;
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
                        isPressed[finalId] = true;
                        isPressed[finalId + 1] = false;
                        isPressed[finalId - 1] = false;
                    }
                });
            }
            else if(id == 2 || id == 5 || id == 8) {
                final int finalId = id;
                answers[finalId].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answers[finalId].setBackgroundColor(getResources().getColor(enabledColor));
                        answers[finalId - 1].setBackgroundColor(getResources().getColor(disabledColor));
                        answers[finalId - 2].setBackgroundColor(getResources().getColor(disabledColor));
                        isPressed[finalId] = true;
                        isPressed[finalId - 1] = false;
                        isPressed[finalId - 2] = false;
                    }
                });
            }
        }
    }
    private int scoreCalculate() {
        int score = 0;
        for(int id = 0; id <= 8; id ++) {
            if(isPressed[id]){
                if(id == 0 || id == 3 || id == 6){
                    score += 1;
                }
                else if(id == 1 || id == 4 || id == 7){
                    score += 3;
                }
                else if(id == 2 || id == 5 || id == 8) {
                    score += 5;
                }
            }
        }
        if((isPressed[0] || isPressed[1] || isPressed[2]) && (isPressed[3] || isPressed[4] || isPressed[5]) && (isPressed[6] || isPressed[7] || isPressed[8])) {
            return score;
        }
        else {
            return 0;
        }
    }
}
