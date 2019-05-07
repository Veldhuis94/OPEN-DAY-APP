package com.group5.cmiopenday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends menu_Activity{
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer(savedInstanceState);


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpenDayDetails();
            }
        });
    }



    public void openOpenDayDetails(){
        Intent intent = new Intent(this,openDayDetails.class);
        startActivity(intent);
    }





}


