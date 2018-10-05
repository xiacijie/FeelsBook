package com.example.xiacijie.feelsbook;

import java.util.HashMap;

public class Config {
    public static final int DELETE = 100;
    public static final int UPDATE = 200;
    public static final String ID = "ID";
    public static final String FILENAME ="feels.sav";
    public static final String EMOTION = "EMOTION";
    public static final String COMMENT = "COMMENT";
    public static final String DATE = "DATE";
    public static final HashMap<String,Integer> emotionHash = new HashMap<String,Integer>(){
        {
            put("Love",0);
            put("Joy",1);
            put("Surprise",2);
            put("Anger",3);
            put("Sadness",4);
            put("Fear",5);
        }
    };

}