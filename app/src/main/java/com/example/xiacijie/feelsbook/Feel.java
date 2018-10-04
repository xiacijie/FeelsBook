package com.example.xiacijie.feelsbook;

import android.text.format.DateFormat;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** A class for emotion object */
public class Feel {
    private String emotion;
    private String comment;
    private Date date;


    public Feel(String emotion, String comment){

        this.emotion = emotion;
        this.comment = comment;
        this.date = new Date();
    }


    public String getEmotion(){

        return this.emotion;
    }

    public String getDate(){

//        https://stackoverflow.com/questions/5683728/convert-java-util-date-to-string
        Format formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String s = formatter.format(this.date);
        return s;
    }

    public String getComment(){

        return this.comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String toString(){
        return this.emotion + " --- " + this.getDate();
    }
}
