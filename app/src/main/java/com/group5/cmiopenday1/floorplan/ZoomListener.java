package com.group5.cmiopenday1.floorplan;

import android.view.ScaleGestureDetector;

//Responsible for executing the zoom function during an onScale event
public class ZoomListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private ZoomController zoomController;

    public ZoomListener(ZoomController zoomController){
        super();
        this.zoomController = zoomController;
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector){ //executes when 2 fingers are used
        float zoom = zoomController.getZoomLevel() * (1 / detector.getScaleFactor());
        zoomController.setZoomLevel(zoom); //zoom in/out
        return true;
    }
}
