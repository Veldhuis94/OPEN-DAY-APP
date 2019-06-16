package com.group5.cmiopenday1.floorplan;

import android.widget.ImageView;

//Is responsible for zooming in and out on the image.
public class ZoomController {
    private ImageView imageView; //target image view to control

    private float currentZoom = 1.0f; //current zoom level
    private float minZoom; //minimum zoom level
    private float maxZoom; //maximum zoom level

    public ZoomController(ImageView targetImageView, float minZoom, float maxZoom){
        this.imageView = targetImageView;
        this.minZoom = minZoom;
        this.maxZoom = maxZoom;
    }

    //sets the zoom level of image. Use a smaller value if you want to zoom in and a larger value to zoom out. The value will be clamped between the minZoom en maxZoom attributes.
    public void setZoomLevel(float zoom){
        //clamp the value
        if(zoom < minZoom){
            zoom = minZoom;
        }
        else if(zoom > maxZoom){
            zoom = maxZoom;
        }
        this.currentZoom = zoom; //set the zoom level

        updateImageView(); //update the imageView
    }

    //returns the current zoom level
    public float getZoomLevel(){
        return this.currentZoom;
    }

    //scales the imageview based on the zoom level
    private void updateImageView(){
        imageView.setScaleX(1 / this.currentZoom);
        imageView.setScaleY(1 / this.currentZoom);
    }
}
