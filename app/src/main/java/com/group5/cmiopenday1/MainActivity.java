package com.group5.cmiopenday1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;
import java.util.Locale;

public class MainActivity extends menu_Activity{
    private Button button;
    private Button button21;
    Cursor row_1 = null;
    Cursor row_2 = null;
    Cursor row_3 = null;
    private ImageView loginbtn;
    String Language = "";
    String Openday = "CMI Open Day, ";
    String Time = "Time: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer(savedInstanceState);

        DatabaseHelper myDbHelper = new DatabaseHelper(MainActivity.this);//Database

        StringBuilder stringBuilder_row_1 = new StringBuilder();
        StringBuilder stringBuilder_row_2 = new StringBuilder();
        StringBuilder stringBuilder_row_3 = new StringBuilder();
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);

        TextView textView4 = findViewById(R.id.textViewdatabase);


        String PhoneLanguage = Locale.getDefault().getLanguage();// Gets language code

        if(PhoneLanguage.equals("nl")){
            Language = "NL";
            Openday = "CMI Opendag, ";
            Time = "Tijd: ";}

        myDbHelper.openDataBase();

        row_1 = myDbHelper.fetch_item("Homepage", null, null, null, null, null, null,1,"Homepage"+Language);
        row_2 = myDbHelper.fetch_item("Homepage", null, null, null, null, null, null,2,"Homepage"+Language);
        row_3 = myDbHelper.fetch_item("Homepage", null, null, null, null, null, null,3,"Homepage"+Language);
        if (row_1.moveToFirst()) {
            do {
                stringBuilder_row_1.append(Openday+row_1.getString(1)+"\n"+Time+row_1.getString(2)+"\n"+row_1.getString(3));
            } while (row_1.moveToNext());
        }

        if (row_2.moveToFirst()) {
            do {
                stringBuilder_row_2.append(Openday+row_2.getString(1)+"\n"+Time+row_2.getString(2)+"\n"+row_2.getString(3));
            } while (row_2.moveToNext());
        }
        if (row_3.moveToFirst()) {
            do {
                stringBuilder_row_3.append(Openday+row_3.getString(1)+"\n" + Time+row_3.getString(2)+"\n"+row_3.getString(3));
            } while (row_3.moveToNext());
        }

        textView2.setText(stringBuilder_row_1);
        textView3.setText(stringBuilder_row_2);//Database
        textView4.setText(stringBuilder_row_3);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, openDay2.class));
            }
        });

        Button button3 = findViewById(R.id.buttondatabase);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, openDay3.class));
            }
        });
        //get the texts of both open days and fill it in with the full dates
//        TextView firstOpenDay = findViewById(R.id.opendaytext_1);
//        TextView secondOpenDay = findViewById(R.id.opendaytext_2);
//        firstOpenDay.setText(String.format(firstOpenDay.getText().toString(), DateUtility.getFullDate(4,4, 2019)));
//        secondOpenDay.setText(String.format(secondOpenDay.getText().toString(), DateUtility.getFullDate(4,6, 2019)));


        button = findViewById(R.id.button);
        loginbtn = findViewById(R.id.loggbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpenDayDetails();
            }
        });

        ((Button) findViewById(R.id.button21)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDbHelper = new DatabaseHelper(MainActivity.this);
                myDbHelper.close();
                myDbHelper.purgeDatabase(MainActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Database reloaded", Toast.LENGTH_SHORT).show();
            }

        });


    }




    public void openOpenDayDetails(){
        Intent intent = new Intent(this,openDayDetails.class);
        startActivity(intent);
    }





}


