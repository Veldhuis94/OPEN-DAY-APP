package com.group5.cmiopenday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tempeduc1 = (Button)findViewById(R.id.temp1);
        Button tempeduc2 = (Button)findViewById(R.id.temp2);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpenDayDetails();
            }
        });
        /* TODO: remove these buttons */
        tempeduc1.setOnClickListener(new onClickStudypage(2,MainActivity.this));
        tempeduc2.setOnClickListener(new onClickStudypage(3, MainActivity.this));
    }

    public void openOpenDayDetails(){
        Intent intent = new Intent(this,openDayDetails.class);
        startActivity(intent);
    }
}


