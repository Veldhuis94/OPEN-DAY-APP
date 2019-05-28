package com.group5.cmiopenday;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class menu_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;

    protected void onCreateDrawer(Bundle savedInstanceState) {
        // making a variable with from xml
        Toolbar toolbar = findViewById(R.id.toolbar);
        // Making the toolbar as the action bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.logohr);
        //toolbar.setLogo(R.drawable.logohr);


        // making the variable link with xml
        drawer = findViewById(R.id.drawer_layout);
        // Making the button to open the sidebar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // Add the button on the screen make it visible
        drawer.addDrawerListener(toggle);
        // Making the button move
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


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.sidebare_homescreen:
                Intent a = new Intent(menu_Activity.this, MainActivity.class);
                startActivity(a);
                break;
            case R.id.sidebare_location:
                Intent b = new Intent(menu_Activity.this,StudyProgramsActivity .class);
                startActivity(b);
                break;
            case R.id.sidebare_study_programs:
                Intent c = new Intent(menu_Activity.this, CMI_Activity.class);
                startActivity(c);
                break;
            case R.id.sidebare_ask_a_question:
                Intent d = new Intent(menu_Activity.this, QuestionFormActivity.class);
                startActivity(d);
                break;
            case R.id.floorplan:
                Intent e = new Intent(menu_Activity.this, FloorPlanActivity.class);
                startActivity(e);
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}