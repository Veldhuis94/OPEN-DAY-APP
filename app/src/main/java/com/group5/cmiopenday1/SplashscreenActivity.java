package com.group5.cmiopenday1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import java.io.IOException;


public class SplashscreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        DatabaseHelper myDbHelper = new DatabaseHelper(SplashscreenActivity.this);//Creates database on startup
        try {
            myDbHelper.ReloadDataBase(SplashscreenActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ///ImageView myimage = (ImageView)  findViewById(R.id.myImageView);
       /// myimage.setImageResource(R.drawable.splashs);

        new Handler().postDelayed(new Runnable() {
            @Override
            public  void run(){
                Intent homeIntent = new Intent(SplashscreenActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
