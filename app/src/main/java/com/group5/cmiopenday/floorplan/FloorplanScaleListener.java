package com.group5.cmiopenday.floorplan;

import android.view.ScaleGestureDetector;

//Responsible for executing the zoom function during an onScale event
public class FloorplanScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private ZoomController zoomController;

    public FloorplanScaleListener(ZoomController zoomController){
        super();
        this.zoomController = zoomController;
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector){ //executes when 2 fingers are used
        float zoom = zoomController.getZoomLevel() * (1 / detector.getScaleFactor());
        zoomController.setZoomLevel(zoom);
        return true;
    }
}
