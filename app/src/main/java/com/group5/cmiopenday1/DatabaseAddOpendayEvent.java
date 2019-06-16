package com.group5.cmiopenday1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.group5.cmiopenday1.questionform.FormTextListener;
import com.group5.cmiopenday1.questionform.FormValidator;

public class DatabaseAddOpendayEvent extends menu_Activity {
    EditText editText_Classroom, editText_Time, editText_Course, editText_Location;
    DatabaseHelper myDbHelper;
    private Button buttonadd;
    private FormValidator validator;
    Toast toast;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_add_openday_event);
        super.onCreateDrawer(savedInstanceState);
        myDbHelper = new DatabaseHelper(DatabaseAddOpendayEvent.this);
        myDbHelper.openDataBase();
        editText_Classroom = findViewById(R.id.editext_Classroom);
        editText_Time = findViewById(R.id.editext_Time);
        editText_Course = findViewById(R.id.editext_Course);
        editText_Location = findViewById(R.id.editext_Location);
        buttonadd = findViewById(R.id.buttonadd);
        validator = new FormValidator(buttonadd); //initialise object for validating the fields
        //create listeners for the validator, the validator will check the textfield after it has been changed.
        editText_Course.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, editText_Course, validator));
        editText_Classroom.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, editText_Classroom, validator));
        editText_Time.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, editText_Time, validator));
        editText_Location.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, editText_Location, validator));
        InsertData();
    }

    public void InsertData() {
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = myDbHelper.addDataEvent(editText_Course.getText().toString(), editText_Classroom.getText().toString(), editText_Time.getText().toString(), editText_Location.getText().toString());
                if (validator.valids) {
                if (result == true) {
                    Toast.makeText(DatabaseAddOpendayEvent.this, "Data is inserted :)", Toast.LENGTH_SHORT).show();}

                } else{
                    if(toast !=null){
                        toast.cancel();
                    }
                    toast = Toast.makeText(DatabaseAddOpendayEvent.this,R.string.invalid_fields,Toast.LENGTH_LONG);
                    toast.show();
                }
        }});}
}

