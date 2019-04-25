package com.group5.cmiopenday;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import com.group5.cmiopenday.floorplan.FloorplanLayout;
import com.group5.cmiopenday.floorplan.FloorplanScaleListener;
import com.group5.cmiopenday.floorplan.ZoomController;

public class FloorPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);
        floorplanImageInit();
    }

    //create instances of classes responsible for zooming in and dragging the image
    private void floorplanImageInit(){
        ImageView floorplanImage = findViewById(R.id.FloorplanImageView);
        FloorplanLayout floorplanLayout = findViewById(R.id.FloorplanLayout); //get the zoomableframelayout that contains the imageview
        ZoomController zoomController = new ZoomController(floorplanImage, 0.25f, 1.0f);
        floorplanLayout.setScaleDetector(new ScaleGestureDetector(this, new FloorplanScaleListener(zoomController)));
    }
}
