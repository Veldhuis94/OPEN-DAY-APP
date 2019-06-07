package com.group5.cmiopenday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.group5.cmiopenday.questionform.FormTextListener;
import com.group5.cmiopenday.questionform.FormValidator;

public class DatabaseAddOpendays extends menu_Activity {
    EditText editText_Date, editText_Time, editText_Courses;
    DatabaseHelper myDbHelper;
    private Button buttonadd;
    private FormValidator validator;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_add_openday);
        super.onCreateDrawer(savedInstanceState);
        myDbHelper = new DatabaseHelper(DatabaseAddOpendays.this);
        myDbHelper.openDataBase();
        editText_Date = findViewById(R.id.editext_Date);
        editText_Time = findViewById(R.id.editext_Time);
        editText_Courses = findViewById(R.id.editext_Courses);
        InsertData();
    }
    public void InsertData() {
        buttonadd  = findViewById(R.id.buttonadd);
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = myDbHelper.addData(editText_Date.getText().toString(), editText_Time.getText().toString(), editText_Courses.getText().toString());
                if (result == true) {
                    Toast.makeText(DatabaseAddOpendays.this, "Data is inserted :)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DatabaseAddOpendays.this, "Data is not inserted :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DatabaseAddOpendays.this, DatabaseAddOpendayEvent.class));
                }
        });
        validator = new FormValidator(buttonadd); //initialise object for validating the fields
        //create listeners for the validator, the validator will check the textfield after it has been changed.
        editText_Courses.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, editText_Courses, validator));
        editText_Date.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, editText_Date, validator));
        editText_Time.addTextChangedListener(new FormTextListener(FormValidator.FieldType.Text, editText_Time, validator));

    }

}
