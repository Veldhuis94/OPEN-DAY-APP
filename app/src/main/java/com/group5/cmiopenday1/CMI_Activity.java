package com.group5.cmiopenday1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CMI_Activity extends menu_Activity {
    Button qfbtn;
    Button fpbtn;
    Button cbtn;
    Button tdbtn;
    TextView text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmi);
        super.onCreateDrawer(savedInstanceState);

    qfbtn = (Button) findViewById(R.id.questionFormButton);
        qfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CMI_Activity.this, QuestionFormActivity.class));
            }
        });

    tdbtn = (Button) findViewById(R.id.travelDirectionButton);
        tdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CMI_Activity.this, TravelActivity.class));
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
        text =  findViewById(R.id.textView12);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hogeschoolrotterdam.nl/samenwerking/instituten/instituut-voor-communicatie-media-en-informatietechnologie/introductie/")));
            }
        });


    }
}
