package com.group5.cmiopenday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import com.group5.cmiopenday.floorplan.DragController;
import com.group5.cmiopenday.floorplan.DragListener;
import com.group5.cmiopenday.floorplan.FloorplanLayout;
import com.group5.cmiopenday.floorplan.ZoomListener;
import com.group5.cmiopenday.floorplan.ZoomController;

public class FloorPlanActivity extends AppCompatActivity {

    Button Up;
    Button Down;
    Button H;
    Button WD;
    Button WN;
    TextView Floor;
    int v = 0 ;
    ImageView Image;
    Boolean HisPressed = true;
    Boolean WDisPressed = false;
    Boolean WNisPressed = false;
    int imageResourceIdsH[] = {R.drawable.minusone,R.drawable.bg,R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.fifth,R.drawable.sixth};
    int imageResourceIdsWD[] = {R.drawable.wdminusone,R.drawable.wdbg,R.drawable.wdone,R.drawable.wdtwo,R.drawable.wdthree,R.drawable.wdfour,R.drawable.wdfive,R.drawable.wdsix};
    int imageResourceIdsWN[] = {R.drawable.wnminusone,R.drawable.wnbg,R.drawable.wnone,R.drawable.wntwo,R.drawable.wnthree,R.drawable.wnfour,R.drawable.wnfive                                                                                                                                                                                                                                                                                                                                              };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);

        Up = (Button)findViewById(R.id.Floor_Up_Button);
        Down = (Button)findViewById(R.id.Floor_Down_Button);
        H = (Button)findViewById(R.id.BuildingH_Button);
        H.setBackgroundColor(getResources().getColor(R.color.secondary3));
        WD = (Button)findViewById(R.id.BuildingWD_Button);
        WN = (Button)findViewById(R.id.BuildingWN_Button);
        Floor = (TextView)findViewById(R.id.Floor_Value_Text);
        Image = (ImageView)findViewById(R.id.FloorplanImageView);

        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v < 6 && WNisPressed == false) {
                    v += 1;
                    Floor.setText(String.valueOf(v));
            }
                else if(v<5 && WNisPressed){
                    v+=1;
                    Floor.setText(String.valueOf(v));
                }
                if(HisPressed) {
                    Image.setImageResource(imageResourceIdsH[v+1]);
                }
                if(WDisPressed){
                    Image.setImageResource(imageResourceIdsWD[v+1]);
                }
                if(WNisPressed){
                    Image.setImageResource(imageResourceIdsWN[v+1]);
                }
            }
        });
        Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(v > -1){
                    v-=1;
                    Floor.setText(String.valueOf(v));
                }
                if(HisPressed) {
                    Image.setImageResource(imageResourceIdsH[v+1]);
                }
                if(WDisPressed){
                    Image.setImageResource(imageResourceIdsWD[v+1]);
                }
                if(WNisPressed){
                    Image.setImageResource(imageResourceIdsWN[v+1]);
                }
            }
        });
        H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HisPressed = true;
                v = 0;
                Floor.setText(String.valueOf(v));
                Image.setImageResource(imageResourceIdsH[v+1]);
                WDisPressed = false;
                WNisPressed = false;
                H.setBackgroundColor(getResources().getColor(R.color.secondary3));
                WN.setBackgroundColor(getResources().getColor(R.color.secondary2));
                WD.setBackgroundColor(getResources().getColor(R.color.secondary2));
            }
        });
        WD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WDisPressed = true;
                v=0;
                Floor.setText(String.valueOf(v));
                Image.setImageResource(imageResourceIdsWD[v+1]);
                HisPressed = false;
                WNisPressed = false;
                WD.setBackgroundColor(getResources().getColor(R.color.secondary3));
                WN.setBackgroundColor(getResources().getColor(R.color.secondary2));
                H.setBackgroundColor(getResources().getColor(R.color.secondary2));

            }
        });
        WN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WNisPressed = true;
                v = 0;
                Floor.setText(String.valueOf(v));
                Image.setImageResource(imageResourceIdsWN[v+1]);
                WDisPressed = false;
                HisPressed = false;
                WN.setBackgroundColor(getResources().getColor(R.color.secondary3));
                WD.setBackgroundColor(getResources().getColor(R.color.secondary2));
                H.setBackgroundColor(getResources().getColor(R.color.secondary2));
            }
        });
        floorplanImageInit(); //initialise objects for the floorplan imageview
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
}
