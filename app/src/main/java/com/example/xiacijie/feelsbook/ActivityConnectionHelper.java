package com.example.xiacijie.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;


/** This is a helper class that jumps between activities and sending data between activities */
public class ActivityConnectionHelper {


    /** go to anthoer activity */
    static public void switchToActivity(AppCompatActivity context, Class Destination, int id,Feel feel){
        Intent intent = new Intent(context,Destination);
        intent.putExtra(Config.ID,id);
        context.startActivityForResult(intent,1);
    }

    /** go back */
    static public void goBack(AppCompatActivity context){

        context.finish();
    }

    /** save result and go back */
    static public void save(AppCompatActivity context, Intent intent){

        context.setResult(Config.UPDATE,intent);
        goBack(context);
    }

    /** Delete the emotion and go back */
    static public void delete(AppCompatActivity context, Intent intent){
        context.setResult(Config.DELETE,intent);
        goBack(context);
    }


}
