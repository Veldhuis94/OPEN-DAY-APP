package com.group5.cmiopenday1;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.group5.cmiopenday1.floorplan.DragController;
import com.group5.cmiopenday1.floorplan.DragListener;
import com.group5.cmiopenday1.floorplan.FloorplanLayout;
import com.group5.cmiopenday1.floorplan.ZoomController;
import com.group5.cmiopenday1.floorplan.ZoomListener;


public class FloorPlanActivity extends menu_Activity {


    Button upButton;
    Button downButton;
    Button HButton;
    Button WDButton;
    Button WNButton;
    TextView floorText;
    int currentFloor = 0 ;
    ImageView floorplanImage;
    Boolean HisPressed = true;
    Boolean WDisPressed = false;
    Boolean WNisPressed = false;

    int[] imageResourceIdsH = {R.drawable.minusone, R.drawable.bg, R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.fourth, R.drawable.fifth, R.drawable.sixth};
    int[] imageResourceIdsWD = {R.drawable.wdminusone, R.drawable.wdbg, R.drawable.wdone, R.drawable.wdtwo, R.drawable.wdthree, R.drawable.wdfour, R.drawable.wdfive, R.drawable.wdsix};
    int[] imageResourceIdsWN = {R.drawable.wnminusone, R.drawable.wnbg, R.drawable.wnone, R.drawable.wntwo, R.drawable.wnthree, R.drawable.wnfour, R.drawable.wnfive};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);
        super.onCreateDrawer(savedInstanceState);




        upButton = findViewById(R.id.Floor_Up_Button);
        downButton = findViewById(R.id.Floor_Down_Button);
        HButton = findViewById(R.id.BuildingH_Button);
        HButton.setBackgroundColor(getResources().getColor(R.color.secondary3));
        WDButton = findViewById(R.id.BuildingWD_Button);
        WNButton = findViewById(R.id.BuildingWN_Button);
        floorText = findViewById(R.id.Floor_Value_Text);
        floorplanImage = findViewById(R.id.FloorplanImageView);

        updateBuildingButtonColors(); //set the buttons to the right colours from startup
        addEventsToButtons(); //add events to the buttons to change the current floor and building
        floorplanImageInit(); //initialise objects for the floorplan imageview
    }

    private void updateFloorplanImage(){ //change the floorplan image to the image of the current floor
        floorplanImage.setImageResource(getCurrentBuildingFloorplans()[currentFloor+1]);
    }

    //Return the floorplan image id array of the current building
    private int[] getCurrentBuildingFloorplans(){
        floorCheck();
        if(HisPressed) {
            return imageResourceIdsH;
        }
        if(WDisPressed){
            return imageResourceIdsWD;
        }
        else {//wn has been pressed
            return imageResourceIdsWN;
        }
    }

    //The selected building button will have a different color from the other buttons
    private void updateBuildingButtonColors() {
        int selectedBackground = R.drawable.round_button;
        int defaultBackground = R.drawable.round_button_grey;
        //                                  condition       true            false
        HButton.setBackgroundResource((HisPressed)? selectedBackground : defaultBackground);
        WNButton.setBackgroundResource((WNisPressed)? selectedBackground : defaultBackground);
        WDButton.setBackgroundResource((WDisPressed)? selectedBackground : defaultBackground);
        //disables or enables the button based on if the building is selected or not
        HButton.setEnabled(!HisPressed);
        WNButton.setEnabled(!WNisPressed);
        WDButton.setEnabled(!WDisPressed);
    }

    //The plus or minus buttons will turn grey if the floor above or below does not exist
    private void floorCheck() {
        int disabledBackground = R.drawable.round_button_grey_disabled;
        int defaultBackground = R.drawable.round_button_grey;
        if(currentFloor == -1) {
            downButton.setBackgroundResource(disabledBackground); //sets background
            downButton.setEnabled(false); //sets pressability
        }
        else {
            downButton.setBackgroundResource(defaultBackground);
            downButton.setEnabled(true);
        }
        if(HisPressed || WDisPressed) {
            if(currentFloor == 6) {
                upButton.setBackgroundResource(disabledBackground);
                upButton.setEnabled(false);
            }
            else {
                upButton.setBackgroundResource(defaultBackground);
                upButton.setEnabled(true);
            }
        }
        else if(WNisPressed) {
            if(currentFloor == 5) {
                upButton.setBackgroundResource(disabledBackground);
                upButton.setEnabled(false);
            }
            else {
                upButton.setBackgroundResource(defaultBackground);
                upButton.setEnabled(true);
            }
        }
    }

    private void onBuildingButtonClick(boolean h, boolean wd, boolean wn) { //Used when a new building is selected with a button
        HisPressed = h;
        WDisPressed = wd;
        WNisPressed = wn;

        floorText.setText(String.valueOf(currentFloor));
        updateFloorplanImage();
        updateBuildingButtonColors();
    }

    //create instances of classes responsible for zooming in and dragging the image
    private void floorplanImageInit(){
        ImageView floorplanImage = findViewById(R.id.FloorplanImageView);
        FloorplanLayout floorplanLayout = findViewById(R.id.FloorplanLayout); //get the zoomableframelayout that contains the imageview

        DragController dragController = new DragController(floorplanImage);
        floorplanLayout.setGestureDetector(new GestureDetector(this, new DragListener(dragController)));

        ZoomController zoomController = new ZoomController(floorplanImage, 0.25f, 1.0f);
        floorplanLayout.setScaleDetector(new ScaleGestureDetector(this, new ZoomListener(zoomController)));
    }



    private void addEventsToButtons(){ //add the events to the buttons for changing the current floor and building
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentFloor < getCurrentBuildingFloorplans().length - 2){ //because the lowest floor is -1
                    currentFloor += 1;
                    floorText.setText(String.valueOf(currentFloor));
                }
                floorCheck();
                updateFloorplanImage();
            }
        });
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentFloor > -1){
                    currentFloor -=1;
                    floorText.setText(String.valueOf(currentFloor));
                }
                floorCheck();
                updateFloorplanImage();
            }
        });

        HButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBuildingButtonClick(true, false, false);
            }
        });
        WDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBuildingButtonClick(false, true, false); //select wd
            }
        });
        WNButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentFloor == 6){
                    currentFloor = 5;
                }
                onBuildingButtonClick(false, false, true);
            }
        });
    }


}
