package com.group5.cmiopenday;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PopShareActivity extends AppCompatActivity {

    ImageView btfacebook;
    ImageView bttwitter;
    ImageView btwhatsapp;
    ImageView btgmail;
    TextView textView;
    Button copyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_share);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .800), (int) (height * .70));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 10;
        params.y = -20;

        getWindow().setAttributes(params);


        //all the image buttons
        ImageView btfacebook = findViewById(R.id.imageView);
        btfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(getPackageManager().getLaunchIntentForPackage("com.facebook.katana"));
            }
        });

        ImageView bttwitter = findViewById(R.id.imageView4);
        bttwitter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(getPackageManager().getLaunchIntentForPackage("com.twitter.android"));
            }
        });

        ImageView btwhatsapp = findViewById(R.id.imageView3);
        btwhatsapp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(getPackageManager().getLaunchIntentForPackage("com.whatsapp"));
            }
        });

        ImageView btgmail = findViewById(R.id.imageView5);
        btgmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(getPackageManager().getLaunchIntentForPackage("com.google.android.gm"));
            }
        });

        textView = (TextView) findViewById(R.id.textView16);
        copyMessage = (Button) findViewById(R.id.button7);
        copyMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("EditText",textView.getText().toString());
                clipboard.setPrimaryClip(clip);


                Toast.makeText(PopShareActivity.this, "Copied.", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
