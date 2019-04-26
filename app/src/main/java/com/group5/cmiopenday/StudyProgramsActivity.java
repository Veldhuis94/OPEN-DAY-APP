package com.group5.cmiopenday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class StudyProgramsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_programs);

        Button com = findViewById(R.id.sp_com);
        com.setOnClickListener(new onClickStudypage(1, this));
        Button cmd = findViewById(R.id.sp_cmd);
        cmd.setOnClickListener(new onClickStudypage(2, this));
        Button cmgt = findViewById(R.id.sp_cmgt);
        cmgt.setOnClickListener(new onClickStudypage(4, this));
        Button si = findViewById(R.id.sp_si);
        si.setOnClickListener(new onClickStudypage(0, this));
        Button ti = findViewById(R.id.sp_ti);
        ti.setOnClickListener(new onClickStudypage(3, this));
    }
}