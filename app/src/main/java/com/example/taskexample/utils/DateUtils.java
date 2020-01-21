package com.example.taskexample.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String setDate(String date){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date1);
        String  date2 = DateFormat.getDateInstance().format(calendar.getTime());
        return date2;
    }
}
