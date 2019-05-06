package com.group5.cmiopenday;

import android.os.Bundle;

public class CMI_Activity extends menu_Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmi);
        super.onCreateDrawer(savedInstanceState);
    }


    }


