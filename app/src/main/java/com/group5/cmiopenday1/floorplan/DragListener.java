package com.group5.cmiopenday1.floorplan;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

//responsible for dragging the image
public class DragListener extends GestureDetector.SimpleOnGestureListener {
    private DragController dragController;

    public DragListener(DragController dragController){
        this.dragController = dragController;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        ImageView floorplan = dragController.getFloorplanImage(); //get the floorplan imageview
        float x = floorplan.getX() - distanceX; //subtract the position with the distance in order to move the image
        float y = floorplan.getY() - distanceY;
        this.dragController.dragImage(x, y);
        return true;
    }
}
