package com.group5.cmiopenday1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class TravelActivity extends menu_Activity {

    Button Hmap;
    Button WDmap;
    Button WNmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        super.onCreateDrawer(savedInstanceState);

        Intent b = new Intent(TravelActivity.this, MainActivity.class);
        startActivity(b);

        Intent a = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.nl/maps/place/Wijnhaven+107,+3011+WN+Rotterdam/@51.9173982,4.4833703,19z/data=!3m1!4b1!4m5!3m4!1s0x47c4335dd6b0b5a3:0x3b8dcf047e6f0073!8m2!3d51.9173974!4d4.4839175"));
        startActivity(a);
    }

}
