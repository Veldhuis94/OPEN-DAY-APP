package com.group5.cmiopenday.floorplan;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

//verantwoordelijk voor het lezen van touch inputs en gebruikt andere classes om te zoomen en te bewegen.
//todo: voeg code voor het zoomen en bewegen van de floorplan imageview
public class FloorplanLayout extends FrameLayout {
    public FloorplanLayout(Context context){
        super(context);
    }

    public FloorplanLayout(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }
}
