package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private DateUtil() {

    }

    public static String formatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h: mm a");
        return  dateFormat.format(date);
    }

    public static String formatDate(Date date ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
        return dateFormat.format(date);
    }

}
