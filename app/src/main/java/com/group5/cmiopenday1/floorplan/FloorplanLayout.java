package com.group5.cmiopenday1.floorplan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.FrameLayout;

//responsible for reading touch inputs and it executes the event of a scale detector during a touch event.
public class FloorplanLayout extends FrameLayout {
    private ScaleGestureDetector scaleDetector; //responsible for receiving touches with 2 fingers (scaling)
    private GestureDetector gestureDetector;

    public FloorplanLayout(Context context){
        super(context);
    }

    public FloorplanLayout(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    //sets the scaledetector for the ontouchevent function
    public void setScaleDetector(ScaleGestureDetector scaleDetector) {
        this.scaleDetector = scaleDetector;
    }

    //sets the gestureDetector for the ontouchevent function
    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gestureDetector = gestureDetector;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(scaleDetector != null){
            scaleDetector.onTouchEvent(event);
        }
        if(gestureDetector != null){
            gestureDetector.onTouchEvent(event);
        }

        return true;
    }
}
