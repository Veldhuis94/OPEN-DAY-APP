package com.group5.cmiopenday.floorplan;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

//responsible for dragging the image
public class DragListener extends GestureDetector.SimpleOnGestureListener {
    private ImageView floorplanImage;

    public DragListener(ImageView floorplanImage){
        super();
        this.floorplanImage = floorplanImage;
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float x = floorplanImage.getX();
        float y = floorplanImage.getY();
        floorplanImage.setX(x + distanceX);
        floorplanImage.setY(y + distanceY);
        Log.i("DragListener onScroll", "Test");
        return true;
    }
}
