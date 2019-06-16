package com.group5.cmiopenday1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//helper class for date related tasks
public class DateUtility {
    public static String getFullDate(int day, int month, int year){ //returns for example 5 april, 2019
        //Subtract 1900 from year, because the year of the Date class starts at 1900 BC (I have no idea why)
        Date date = new Date(year-1900, month, day); //create a date object so it can be used for formatting
        DateFormat format = SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG);
        return format.format(date); //convert the date object to a full date string
    }
    public static String getFullDate(Date date){ //returns for example 5 april, 2019
        DateFormat format = SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG);
        return format.format(date); //convert the date object to a full date string
    }
}
