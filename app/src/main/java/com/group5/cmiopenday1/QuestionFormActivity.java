package com.group5.cmiopenday1;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.group5.cmiopenday1.questionform.FormSender;
import com.group5.cmiopenday1.questionform.FormTextListener;
import com.group5.cmiopenday1.questionform.FormValidator;

public class QuestionFormActivity extends menu_Activity{

    private FormValidator validator; //for validating the textfields
    Toast toast;
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
                if(validator.valids) {
                    FormSender.Send(activity, email.getText().toString(), name.getText().toString(), subject.getText().toString(), question.getText().toString());
                }
                else{
                        if(toast !=null){
                            toast.cancel();
                        }
                        toast = Toast.makeText(QuestionFormActivity.this,R.string.invalid_fields,Toast.LENGTH_LONG);
                   toast.show();
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






