package com.group5.cmiopenday1;

import android.os.Bundle;

public class creditsPage extends menu_Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_page);
        super.onCreateDrawer(savedInstanceState);
    }
}
