package com.group5.cmiopenday;

import android.content.Intent;
<<<<<<< HEAD
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
=======
>>>>>>> 6938bb20103c605936c169f30be97be504914062
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URL;


public class CMI_Activity extends menu_Activity {
    Button qfbtn;
    Button fpbtn;
    Button cbtn;
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
