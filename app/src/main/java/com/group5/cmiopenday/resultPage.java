package com.group5.cmiopenday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class resultPage extends AppCompatActivity {
    static int finalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        TextView resultScore = findViewById(R.id.textView29);
        resultScore.setText(finalResult);
    }
}
