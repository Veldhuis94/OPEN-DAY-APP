package com.group5.cmiopenday1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Questionnaire extends menu_Activity {

    static int currentPageId; //decides which questionnaire is displayed, received from onClickQuestionnaire which in turn received it from its call on EducationPage
    boolean[] isPressed = {false, false, false, false, false, false, false, false, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        super.onCreateDrawer(savedInstanceState);
        onClickEvent();
        setTitle("Questionnaire");

        //System to assign the correct strings to the correct textviews
        String[] q1strings = getResources().getStringArray(R.array.q1Body);
        TextView q1 = findViewById(R.id.qbody1);
        q1.setText(q1strings[currentPageId]);

        String[] q2strings = getResources().getStringArray(R.array.q2Body);
        TextView q2 = findViewById(R.id.qbody2);
        q2.setText(q2strings[currentPageId]);

        String[] q3strings = getResources().getStringArray(R.array.q3Body);
        TextView q3 = findViewById(R.id.qbody3);
        q3.setText(q3strings[currentPageId]);

        final Button submitButton = findViewById(R.id.submitButton);
        final Questionnaire current = this;
        submitButton.setOnClickListener(new onClickResultpage(current));
    }
    //sets onClicks for all the buttons, and checks which are pressed
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
    //Calculates the score and returns it into onClickResultpage
    public int scoreCalculate() {
        int score = 0;
        for(int id = 0; id <= 8; id ++) {
            if(isPressed[id]){
                if(id == 0 || id == 3 || id == 6){
                    score += 0;
                }
                else if(id == 1 || id == 4 || id == 7){
                    score += 1;
                }
                else if(id == 2 || id == 5 || id == 8) {
                    score += 2;
                }
            }
        }
        if((isPressed[0] || isPressed[1] || isPressed[2]) && (isPressed[3] || isPressed[4] || isPressed[5]) && (isPressed[6] || isPressed[7] || isPressed[8])) {
            return score;
        }
        else {
            return -1;
        }
    }
}
