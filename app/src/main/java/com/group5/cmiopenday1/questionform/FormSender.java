package com.group5.cmiopenday1.questionform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.group5.cmiopenday1.R;

//this class is responsible for sending the message of the question form.
public class FormSender {
    public static void Send(Context context, String email, String name, String subject, String question){
        String receiverEmail = "HRotterdam12345@gmail.com";

        String message = question + "\n\n Full Name: " + name + "\n Email: " + email;

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO); //Create an intent for sending this message
        //Explanation Unified Resource Identifier (URI): this class is used to tell the Content provider what data we want to access
        //Content provider is responsible for sharing data with other applications, in this case, the email app of choice.
        emailIntent.setData(Uri.parse("mailto:")); //create an URI object for emailing
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {receiverEmail}); //receiver email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject); //subject
        emailIntent.putExtra(Intent.EXTRA_TEXT, message); //content of the message

        context.startActivity(Intent.createChooser(emailIntent, context.getString(R.string.questionform_chooseApp))); //let the user choose his app for sending
    }
}
