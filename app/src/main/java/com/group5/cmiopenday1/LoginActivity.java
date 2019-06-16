package com.group5.cmiopenday1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//Reminder: remove the code of the nightmode when it's extending from menu_Activity
public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private boolean nightmodeDuringCreation; //nightmode of the app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int themeId = ((menu_Activity.nightmodeIsOn)? R.style.AppThemeDark : R.style.AppTheme);
        getTheme().applyStyle(themeId, true); //set the theme
        nightmodeDuringCreation = menu_Activity.nightmodeIsOn;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.buttonlogin);
        Info = (TextView) findViewById(R.id.textView22) ;

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    @Override
    protected void onStart(){
        if(nightmodeDuringCreation != menu_Activity.nightmodeIsOn){
            nightmodeDuringCreation = menu_Activity.nightmodeIsOn;
            recreate(); //recreate the activity with the right theme.
        }
        super.onStart();
    }

    private void validate(String userName, String userPassword){

        if ((userName.equals("admin")) && (userPassword.equals("admin123"))){
            Intent intent = new Intent(LoginActivity.this, DatabaseAddOpendays.class);
            startActivity(intent);
            //CHANGE MAINACTIVITY TO THE NEW ACTIVITY WHEN ITS DONE
            //CHANGE USERNAME AND  PASSWORD IF NEEDED
            //CHANGE A BUTTON ON THE HOMEPAGE TO START THIS ACTIVITY
            //USERNAME AND PASSOWRD ARE: admin and admin123


        }
        else {Info.setText("Wrong username or password"); Toast.makeText(LoginActivity.this,"Try Again", Toast.LENGTH_SHORT).show();}



    }
}
