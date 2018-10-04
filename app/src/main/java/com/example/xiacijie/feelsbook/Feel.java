package com.example.xiacijie.feelsbook;

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

    public String getStringDate(){


        return DateStringHelper.dateToString(this.date);
    }

    public Date getRawDate(){
        return this.date;
    }

    public void setDate(String s){
        this.date = DateStringHelper.stringToDate(s);
    }

    public String getComment(){

        return this.comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String toString(){
        return this.emotion + " --- " + this.getStringDate();
    }
}
