package com.group5.cmiopenday;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CheckForApp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_check_for_app2);

        startActivity(new Intent(CheckForApp2Activity.this, openDayDetails.class));

        boolean twitterInstalled  = appInstalled ("com.twitter.android");


        if(twitterInstalled){
            startActivity(getPackageManager().getLaunchIntentForPackage("com.twitter.android"));

        }
        else{
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/")));


        }



    }
    public boolean appInstalled(String uri){
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;

        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;

        }
        return app_installed;
    }
}

