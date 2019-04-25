package com.group5.cmiopenday.floorplan;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.group5.cmiopenday.math.MathUtil;

//responsible for dragging the image
public class DragListener extends GestureDetector.SimpleOnGestureListener {
    private ImageView floorplanImage;

    public DragListener(ImageView floorplanImage){
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

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float x = floorplanImage.getX() - distanceX;
        float y = floorplanImage.getY() - distanceY;

        RectF boundaries = getBoundaries();
        x = MathUtil.Clamp(x, boundaries.left, boundaries.right);
        y = MathUtil.Clamp(y, boundaries.top, boundaries.bottom);

        floorplanImage.setX(x);
        floorplanImage.setY(y);

        return true;
    }
}
