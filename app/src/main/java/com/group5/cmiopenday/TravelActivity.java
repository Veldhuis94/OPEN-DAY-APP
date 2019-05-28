package com.group5.cmiopenday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

        Hmap = (Button)findViewById(R.id.Hmap);
        WDmap = (Button)findViewById(R.id.WDmap);
        WNmap = (Button)findViewById(R.id.WNmap);

        eventsButtons();

    }

    public void eventsButtons(){
        Hmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.nl/maps/place/Wijnhaven+107,+3011+WN+Rotterdam/@51.9173982,4.4833703,19z/data=!3m1!4b1!4m5!3m4!1s0x47c4335dd6b0b5a3:0x3b8dcf047e6f0073!8m2!3d51.9173974!4d4.4839175"));
                startActivity(a);
            }
        });
        WDmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.nl/maps/place/Wijnhaven+105,+3011+WN+Rotterdam/@51.9172586,4.4836779,19z/data=!3m1!4b1!4m5!3m4!1s0x47c4335dd057d051:0x655fe30be115cf2d!8m2!3d51.9172578!4d4.4842251"));
                startActivity(b);
            }
        });
        WNmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.nl/maps/place/Wijnhaven+99,+3011+WN+Rotterdam/@51.9174229,4.4842882,19z/data=!3m1!4b1!4m5!3m4!1s0x47c4335dc94fd4eb:0xc88777a94bdb6b23!8m2!3d51.9174221!4d4.4848354"));
                startActivity(c);
            }
        });

    }

}
