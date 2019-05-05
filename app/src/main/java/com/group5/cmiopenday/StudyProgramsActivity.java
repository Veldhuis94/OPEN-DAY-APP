package com.group5.cmiopenday;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
=======
>>>>>>> 1322aa2ea681ef03a8a6b36569d3d0f96a28c858
import android.widget.Button;

public class StudyProgramsActivity extends AppCompatActivity {

    Button btinformatica;
    Button btcommunicatie;
    Button btcmd;
    Button bttinformatica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
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
=======
        setContentView(R.layout.activity_study_programs);

        int buttonIds[] = {R.id.sp_com, R.id.sp_cmd, R.id.sp_cmgt, R.id.sp_si, R.id.sp_ti};
        int pageIds[] = {1,2,4,0,3};
        for(int i = 0; i < buttonIds.length; i++){
            Button button = findViewById(buttonIds[i]);
            button.setOnClickListener(new onClickStudypage(pageIds[i], this));
        }
    }
}
>>>>>>> 1322aa2ea681ef03a8a6b36569d3d0f96a28c858
