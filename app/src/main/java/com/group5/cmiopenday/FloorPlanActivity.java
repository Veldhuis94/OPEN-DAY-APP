package com.group5.cmiopenday;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class FloorPlanActivity extends menu_Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }


}
