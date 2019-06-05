package com.group5.cmiopenday;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseAddOpendayEvent extends menu_Activity {
    EditText editText_Classroom, editText_Time, editText_Course, editText_Location;
    DatabaseHelper myDbHelper;
    private Button buttonadd;

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
        InsertData();
    }

    public void InsertData() {
        buttonadd = findViewById(R.id.buttonadd);
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = myDbHelper.addDataEvent(editText_Course.getText().toString(), editText_Classroom.getText().toString(), editText_Time.getText().toString(), editText_Location.getText().toString());
                if (result == true) {
                    Toast.makeText(DatabaseAddOpendayEvent.this, "Data is inserted :)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DatabaseAddOpendayEvent.this, "Data is not inserted :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
