package com.group5.cmiopenday;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.group5.cmiopenday.questionform.FormTextListener;
import com.group5.cmiopenday.questionform.FormValidator;

public class QuestionFormActivity extends menu_Activity{

    FormValidator validator; //for validating the textfields

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
                String toS = "HRotterdam12345@gmail.com";

                String subS = subject.getText().toString();
                String messageS = question.getText().toString() + "\n\n Full Name: " + name.getText().toString() + "\n Email: " + email.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] {toS});
                email.putExtra(Intent.EXTRA_SUBJECT, subS);
                email.putExtra(Intent.EXTRA_TEXT, messageS);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose app to send the Email"));
            }
        });

        validator = new FormValidator(SendE); //initialise object for validating the fields
        //create listeners for the validator, the validator will check the textfield after it has been changed.
        email.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Email, email, validator));
        subject.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, subject, validator));
        question.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, question, validator));
        name.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, name, validator));

    }
}






