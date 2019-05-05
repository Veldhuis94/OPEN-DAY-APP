package com.group5.cmiopenday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class StudyProgramsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_programs);

        int buttonIds[] = {R.id.sp_com, R.id.sp_cmd, R.id.sp_cmgt, R.id.sp_si, R.id.sp_ti};
        int pageIds[] = {1,2,4,0,3};
        for(int i = 0; i < buttonIds.length; i++){
            Button button = findViewById(buttonIds[i]);
            button.setOnClickListener(new onClickStudypage(pageIds[i], this));
        }
    }
}