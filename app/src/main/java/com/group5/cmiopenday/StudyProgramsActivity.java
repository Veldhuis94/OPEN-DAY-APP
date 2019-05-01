package com.group5.cmiopenday;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudyProgramsActivity extends AppCompatActivity {

    Button btinformatica;
    Button btcommunicatie;
    Button btcmd;
    Button bttinformatica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_page);

        btinformatica = (Button) findViewById(R.id.button7);
        btinformatica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( StudyProgramsActivity.this, Informatica_courseActivity.class));
            }
        });

        btcommunicatie = (Button) findViewById(R.id.button10);
        btcommunicatie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( StudyProgramsActivity.this, Communicatie_courseActivity.class));
            }
        });
        btcmd = (Button) findViewById(R.id.button12);
        btcmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( StudyProgramsActivity.this, cmd_courseActivity.class));
            }
        });
        bttinformatica = (Button) findViewById(R.id.button14);
        bttinformatica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( StudyProgramsActivity.this, Tinformatica_courseActivity.class));
            }
        });
    }

}
