package com.group5.cmiopenday1.math;

public class MathUtil {
    //returns a clamped value between min and max
    public static float clamp(float value, float min, float max){
        if(value < min){ //Under the minimum value?
            value = min;
        }
        else if(value > max){ //Under the maximum value?
            value = max;
        }
        return value;
    }
}
