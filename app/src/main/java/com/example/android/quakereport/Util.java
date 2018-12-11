package com.example.android.quakereport;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Util {

    private Util() {

    }

    public static String formatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h: mm a");
        return  dateFormat.format(date);
    }

    public static String formatDate(Date date ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, YYYY");
        return dateFormat.format(date);
    }

    public static String formatScaleNumber(double scaleNumber) {
        DecimalFormat scaleFormat = new DecimalFormat("0.0");
        return scaleFormat.format(scaleNumber);
    }

}
