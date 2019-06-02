package com.group5.cmiopenday;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.group5.cmiopenday.questionform.FormSender;
import com.group5.cmiopenday.questionform.FormSubmitListener;
import com.group5.cmiopenday.questionform.FormTextListener;
import com.group5.cmiopenday.questionform.FormValidator;

public class QuestionFormActivity extends menu_Activity{

    private FormValidator validator; //for validating the textfields
    boolean valid = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionform);
        super.onCreateDrawer(savedInstanceState);

        final EditText email = (EditText) findViewById(R.id.questionform_editemail);
        final EditText subject = (EditText) findViewById(R.id.questionform_editsubject);
        final EditText question = (EditText) findViewById(R.id.questionform_editmessage);
        final EditText name = (EditText) findViewById(R.id.questionform_editname);
        final QuestionFormActivity activity = this;

        final Button submitButton = (Button) findViewById(R.id.questionform_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FormValidator.valids) {
                    FormSender.Send(activity, email.getText().toString(), name.getText().toString(), subject.getText().toString(), question.getText().toString());
                }
                else{
                    Toast.makeText(QuestionFormActivity.this,"You have some invalid field(s).",Toast.LENGTH_SHORT).show();
                }
            }
        });


        validator = new FormValidator(submitButton); //initialise object for validating the fields
        //create listeners for the validator, the validator will check the textfield after it has been changed.
        email.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Email, email, validator));
        subject.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, subject, validator));
        question.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, question, validator));
        name.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, name, validator));

    }
}






