package com.group5.cmiopenday1;

import android.os.Bundle;
import android.widget.Button;

public class StudyProgramsActivity extends menu_Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_programs);
        super.onCreateDrawer(savedInstanceState);

        int[] buttonIds = {R.id.sp_com, R.id.sp_cmd, R.id.sp_cmgt, R.id.sp_si, R.id.sp_ti};
        int[] pageIds = {1, 2, 4, 0, 3};
        for(int i = 0; i < buttonIds.length; i++){
            Button button = findViewById(buttonIds[i]);
            button.setOnClickListener(new onClickStudypage(pageIds[i], this));
        }
    }
}