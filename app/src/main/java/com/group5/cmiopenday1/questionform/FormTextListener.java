package com.group5.cmiopenday1.questionform;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

//used to execute the form validator after changes of a textfield
public class FormTextListener implements TextWatcher {
    private FormValidator.FieldType type; //type of the textfield
    private EditText textField; //textfield to validate
    private FormValidator validator; //validator object to check the field

    public FormTextListener(FormValidator.FieldType type, EditText textField, FormValidator validator){
        this.type = type;
        this.textField = textField;
        this.validator = validator;
        validator.checkField(type, textField, false);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        validator.checkField(type, textField, true); //check if the field is valid.
    }
}
