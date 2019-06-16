package com.group5.cmiopenday1.floorplan;

import android.graphics.RectF;
import android.widget.ImageView;

import com.group5.cmiopenday1.math.MathUtil;

//Responsible for dragging the floorplan image
public class DragController {
    private ImageView floorplanImage;

    public DragController(ImageView floorplanImage){
        this.floorplanImage = floorplanImage;
    }

    //calculates and returns the boundaries of the imageview (top left corner to bottom right corner)
    private RectF getBoundaries(){
        float halfWidth = floorplanImage.getWidth() / 2; //Divide by 2 because the position moves the center point of the image
        float halfHeight = floorplanImage.getHeight() / 2;
        float scaledHalfWidth = halfWidth* floorplanImage.getScaleX();
        float scaledHalfHeight = halfHeight * floorplanImage.getScaleY();
        return new RectF(-scaledHalfWidth + halfWidth, -scaledHalfHeight + halfHeight, scaledHalfWidth - halfWidth, scaledHalfHeight - halfHeight);
    }

    //move the image
    public void dragImage(float x, float y) {
        RectF boundaries = getBoundaries();
        x = MathUtil.clamp(x, boundaries.left, boundaries.right); //clamp the position to the boundaries of the imageview
        y = MathUtil.clamp(y, boundaries.top, boundaries.bottom);

        floorplanImage.setX(x); //set the imageview position
        floorplanImage.setY(y);
    }

    //returns the imageview of the floorplan
    public ImageView getFloorplanImage(){
        return floorplanImage;
    }
}
