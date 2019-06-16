package com.group5.cmiopenday1.questionform;

import android.widget.Button;
import android.widget.EditText;

import com.group5.cmiopenday1.R;

import java.util.HashSet;
import java.util.regex.Pattern;

//sources used for researching regular expression
//-https://www.geeksforgeeks.org/check-email-address-valid-not-java/
//-https://developer.android.com/reference/java/util/regex/Pattern

//Class used to validate fields of the question form
//This class could be used for other forms in the future
public class FormValidator {
    public enum FieldType{
        Text, Email
    }
    private Button submitButton; //button for sending or submitting a form
    private Pattern emailPattern; //object for storing the email regular expression (used to validate emails)
    private HashSet invalidFields = new HashSet(); //set that contains textfields that are invalid.

    public int minTextLength = 1; //min length of a textfield to be valid
    public boolean valids;

    public FormValidator(Button submitButton){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"; //create regular expression for checking emails
        emailPattern = Pattern.compile(emailRegex); //compile the expression and store it in a pattern object.
        this.submitButton = submitButton;
    }

    private boolean textIsValid(String text){
        return text != null && text.length() >= minTextLength; //return true if it is at least the minTextLengthValue
    }

    private boolean emailIsValid(String email){ //check if the email is valid
        return textIsValid(email) && emailPattern.matcher(email).matches();
    }

    //Checks whether the textfield is valid and updates its state and the button state.
    public void checkField(FieldType type, EditText textField, boolean changeBackgroundIfInvalid){
        boolean valid;
        switch (type){
            case Text: valid = textIsValid(textField.getText().toString()); break; //valid textfield?
            case Email: valid = emailIsValid(textField.getText().toString()); break; //valid email?
            default: throw new RuntimeException("Validation for the fieldtype '" + type.name() + "' has not been implemented."); //just in case if we ever add a new type
        }
        if(valid){
            invalidFields.remove(textField);
            textField.setBackgroundResource(R.drawable.textfield_valid); //set background for showing it's valid.
            if(invalidFields.size() == 0){ //All fields must be valid before the
                valids = true;
                submitButton.setEnabled(true);
            }
        }
        else{ //text is invalid
            invalidFields.add(textField);
            if(changeBackgroundIfInvalid){
                textField.setBackgroundResource(R.drawable.textfield_invalid); //set background for showing it's invalid.
            }
            valids = false;
            submitButton.setEnabled(true);
        }
    }
}
