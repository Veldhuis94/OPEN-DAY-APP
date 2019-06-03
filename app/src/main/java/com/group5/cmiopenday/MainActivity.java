package com.group5.cmiopenday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;


public class MainActivity extends menu_Activity{
    private Button button;
    private ImageView loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer(savedInstanceState);

        //get the texts of both open days and fill it in with the full dates
        TextView firstOpenDay = findViewById(R.id.opendaytext_1);
        TextView secondOpenDay = findViewById(R.id.opendaytext_2);
        firstOpenDay.setText(String.format(firstOpenDay.getText().toString(), DateUtility.getFullDate(4,4, 2019)));
        secondOpenDay.setText(String.format(secondOpenDay.getText().toString(), DateUtility.getFullDate(4,6, 2019)));

        button = findViewById(R.id.button);
        loginbtn = findViewById(R.id.loggbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpenDayDetails();
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, openDay2.class));
            }
        });
    }



    public void openOpenDayDetails(){
        Intent intent = new Intent(this,openDayDetails.class);
        startActivity(intent);
    }





}


