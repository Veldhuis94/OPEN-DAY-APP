package com.group5.cmiopenday;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class QuestionFormActivity extends MainActivity{

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        getLayoutInflater().inflate(R.layout.activity_questionform, drawer);



        setTitle("Ask A Question");


        final EditText email = (EditText) findViewById(R.id.questionform_editemail);
        final EditText subject = (EditText) findViewById(R.id.questionform_editsubject);
        final EditText question = (EditText) findViewById(R.id.questionform_editmessage);
        final EditText name = (EditText) findViewById(R.id.questionform_editname);

        Button SendE = (Button) findViewById(R.id.questionform_button);
        SendE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String toS = to.getText().toString();
                String toS = "HRotterdam12345@gmail.com";

                String subS = subject.getText().toString();
                String queS = question.getText().toString();
                String nameS = name.getText().toString();
                String emailS = email.getText().toString();
                String messageS = question.getText().toString() + "\n\n Full Name: " + name.getText().toString() + "\n Email: " + email.getText().toString();



                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] {toS});
                email.putExtra(Intent.EXTRA_SUBJECT, subS);
                //email.putExtra(Intent.EXTRA_TEXT, queS);
                email.putExtra(Intent.EXTRA_TEXT, messageS);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose app to send the Email"));

            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sidebare_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}



