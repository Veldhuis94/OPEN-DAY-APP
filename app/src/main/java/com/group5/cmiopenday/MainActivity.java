package com.group5.cmiopenday;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button button;

    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button tempeduc1 = (Button)findViewById(R.id.temp1);
        Button tempeduc2 = (Button)findViewById(R.id.temp2);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpenDayDetails();
            }
        });
        /* TODO: remove these buttons */
        tempeduc1.setOnClickListener(new onClickStudypage(0,MainActivity.this));
        tempeduc2.setOnClickListener(new onClickStudypage(1, MainActivity.this));


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.sidebar_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    public void openOpenDayDetails(){
        Intent intent = new Intent(this,openDayDetails.class);
        startActivity(intent);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.sidebare_homescreen:
                Intent a = new Intent(MainActivity.this,MainActivity.class);
                startActivity(a);
                break;
            case R.id.sidebare_location:
                Intent b = new Intent(MainActivity.this,EducationPage.class);
                startActivity(b);
                break;
            case R.id.sidebare_study_programs:
                Intent c = new Intent(MainActivity.this,CMI_Activity.class);
                startActivity(c);
                break;
            case R.id.sidebare_ask_a_question:
                Intent d = new Intent(MainActivity.this,QuestionFormActivity.class);
                startActivity(d);
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}


