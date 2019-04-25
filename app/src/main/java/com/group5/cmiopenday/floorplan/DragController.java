package com.group5.cmiopenday.floorplan;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

//responsible for dragging the image
public class DragController extends GestureDetector.SimpleOnGestureListener {
    private ImageView floorplanImage;

    public DragController(ImageView floorplanImage){
        super();
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float x = floorplanImage.getX();
        float y = floorplanImage.getY();
        floorplanImage.setX(x + distanceX);
        floorplanImage.setY(y + distanceY);
        return true;
    }
}
