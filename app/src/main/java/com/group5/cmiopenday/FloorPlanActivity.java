package com.group5.cmiopenday;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FloorPlanActivity extends AppCompatActivity {

    Button Up;
    Button Down;
    TextView Floor;
    int v ;
    ImageView Image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);

        Up = (Button)findViewById(R.id.Floor_Up_Button);
        Down = (Button)findViewById(R.id.Floor_Down_Button);
        Floor = (TextView)findViewById(R.id.Floor_Value_Text);
        Image = (ImageView)findViewById(R.id.FloorplanImageView);
        Up.setOnClickListener(new View.OnClickListener() {
        int imageResourceIds[] = {R.drawable.bg,R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.fifth,R.drawable.sixth};
            @Override
            public void onClick(View view) {
                if (v < 6) {
                v += 1;
                Floor.setText(String.valueOf(v));
            }
                Image.setImageResource(imageResourceIds[v]);
            }
        });
        Down.setOnClickListener(new View.OnClickListener() {
            int imageResourceIds[] = {R.drawable.bg,R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.fifth,R.drawable.sixth};
            @Override
            public void onClick(View view) {
                if(v > 0){
                    v-=1;
                    Floor.setText(String.valueOf(v));
                }
                Image.setImageResource(imageResourceIds[v]);
            }
        });


    }
}
