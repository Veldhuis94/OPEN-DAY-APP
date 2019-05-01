package com.group5.cmiopenday;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Communicatie_courseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicatie_course);
        Button btCommunication_info = (Button) findViewById(R.id.button17);
        btCommunication_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hogeschoolrotterdam.nl/opleidingen/bachelor/communicatie/voltijd/")));
            }
        });
    }
}
