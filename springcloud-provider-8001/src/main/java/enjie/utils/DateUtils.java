package enjie.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateUtils {
    public static String getDate(){
        Date date  = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date1 = format.format(date);
        return date1;
    }

}
