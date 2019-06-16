package com.group5.cmiopenday1;

import android.os.Bundle;
import android.widget.TextView;

public class resultPage extends menu_Activity {
    static int finalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        super.onCreateDrawer(savedInstanceState);

        TextView resultScore = findViewById(R.id.textView29);
        resultScore.setText(displayResult());

        TextView resultText = findViewById(R.id.scoreText);
        resultText.setText(whatText());
    }
    public String displayResult() {
        int res = finalResult * 100 / 6;
        return res + "%";
    }
    public String whatText() {
        if(finalResult <= 2) {
            return getResources().getString(R.string.negativeQ);
        }
        if(finalResult > 2 && finalResult <= 4) {
            return getResources().getString(R.string.neutralQ);
        }
        else {
            return getResources().getString(R.string.positiveQ);
        }
    }
}
