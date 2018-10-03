package com.example.xiacijie.feelsbook;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;



/** A helper class for saving file to disk and read files */

public class FileHelper{

    /** load the file */
    static public ArrayList<Feel> loadFile(MainActivity context, String filename){
        ArrayList<Feel> feels = new ArrayList<Feel>();
        try {
            FileInputStream fis = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);
            Gson gson = new Gson();
            Type typeListTweets = new TypeToken<ArrayList<Feel>>(){}.getType();
            feels = gson.fromJson(reader,typeListTweets);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return feels;
    }

    /** save the file */
    static public void saveFile(MainActivity context, String filename, ArrayList<Feel> feels){
        try {

            FileOutputStream fos = context.openFileOutput(filename,0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            Gson gson = new Gson();
            gson.toJson(feels,osw);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
