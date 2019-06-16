package com.group5.cmiopenday1.questionform;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

//this class is responsible calling the send function when clicked.
public class FormSubmitListener implements View.OnClickListener {
    private Context context; //needed for executing the email intent
    private EditText senderEmailField;
    private EditText nameField;
    private EditText subjectField;
    private EditText questionField;

    public FormSubmitListener(Context context, EditText senderEmailField, EditText nameField, EditText subjectField, EditText questionField){
        this.senderEmailField = senderEmailField;
        this.nameField = nameField;
        this.subjectField = subjectField;
        this.questionField = questionField;
    }

    @Override
    public void onClick(View v) {
        //send the message
        FormSender.Send(
                context,
                senderEmailField.getText().toString(),
                nameField.getText().toString(),
                subjectField.getText().toString(),
                questionField.getText().toString()
        );
    }
}
