package com.group5.cmiopenday;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CheckForAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_check_for_app);

        startActivity(new Intent(CheckForAppActivity.this, openDayDetails.class));


        boolean facebookInstalled  = appInstalled ("com.facebook.katana.");


        if(facebookInstalled){
            startActivity(getPackageManager().getLaunchIntentForPackage("com.facebook.katana."));

        }

        else{
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/")));


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
