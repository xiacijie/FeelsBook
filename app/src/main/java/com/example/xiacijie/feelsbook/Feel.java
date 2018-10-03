package com.example.xiacijie.feelsbook;

import java.util.Date;

public class Feel {
    private String emotion;
    private String comment;
    private Date date;
    public Feel(String emotion){

        this.date = new Date();
        this.emotion  = emotion;
    }


    public Feel(String emotion, String comment){

        this.emotion = emotion;
        this.comment = comment;
        this.date = new Date();
    }


    public String getEmotion(){

        return this.emotion;
    }

    public String getDate(){

        return this.date.toString();
    }

    public String getComment(){

        return this.comment;
    }
}
