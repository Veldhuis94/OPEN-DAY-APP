package com.group5.cmiopenday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class CMI_Activity extends menu_Activity {
    Button qfbtn;
    Button fpbtn;
    Button cbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmi);
        super.onCreateDrawer(savedInstanceState);
    }


    }


        qfbtn = (Button) findViewById(R.id.questionFormButton);
        qfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CMI_Activity.this, QuestionFormActivity.class));
            }
        });

        fpbtn = (Button) findViewById(R.id.floorPlanButton);
        fpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CMI_Activity.this, FloorPlanActivity.class));
            }
        });

        cbtn = (Button) findViewById(R.id.coursesButton);
        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CMI_Activity.this, StudyProgramsActivity.class));
            }
        });

    }
}
