package com.group5.cmiopenday;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

public class PopActivity extends Activity {
    static int popUpId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .800), (int) (height * .70));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 10;
        params.y = -20;

        getWindow().setAttributes(params);

        int[] ids = {R.array.firstTimeArray, R.array.secondTimeArray, R.array.thirdTimeArray};
        int[] textViews = {R.id.textView15, R.id.textView21, R.id.textView23};

        for (int i = 0; i < textViews.length; i++) {
            String[] firstTime = getResources().getStringArray(ids[i]);
            TextView firstTimeView = findViewById(textViews[i]);
            firstTimeView.setText(firstTime[popUpId]);
        }
    }
}
