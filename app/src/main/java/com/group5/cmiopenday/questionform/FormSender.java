package com.group5.cmiopenday.questionform;

import android.content.Context;
import android.content.Intent;

import com.group5.cmiopenday.R;

//this class is responsible for sending the message of the question form.
public class FormSender {
    public static void Send(Context context, String email, String name, String subject, String question){
        String receiverEmail = "HRotterdam12345@gmail.com";

        String message = question + "\n\n Full Name: " + name + "\n Email: " + email;

        Intent emailIntent = new Intent(Intent.ACTION_SEND); //Create an intent for sending this message
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {receiverEmail}); //receiver email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject); //subject
        emailIntent.putExtra(Intent.EXTRA_TEXT, message); //content of the message

        emailIntent.setType("message/rfc822");
        context.startActivity(Intent.createChooser(emailIntent, context.getString(R.string.questionform_chooseApp))); //let the user choose his app for sending
    }
}
