package com.group5.cmiopenday;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class QuestionFormActivity extends menu_Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionform);
        super.onCreateDrawer(savedInstanceState);



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


}






