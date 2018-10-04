package com.example.xiacijie.feelsbook;


import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/** A helper class that convert date to string and convert string to date */
public class DateStringUtil {
    static public String dateToString(Date date){
        //https://stackoverflow.com/questions/5683728/convert-java-util-date-to-string
        Format formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String s = formatter.format(date);
        return s;
    }

    static public Date stringToDate(String s){
//        https://stackoverflow.com/questions/6510724/how-to-convert-java-string-to-date-object
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date startDate = null;
        try {
            startDate = df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return startDate;

    }
}
