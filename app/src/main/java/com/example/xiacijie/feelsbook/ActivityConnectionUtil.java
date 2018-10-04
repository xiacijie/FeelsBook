package com.example.xiacijie.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;


/** This is a helper class that jumps between activities and sending data between activities */
public class ActivityConnectionUtil {


    /** go to anthoer activity */
    static public void switchToActivity(AppCompatActivity context, Class Destination, int id,Feel feel){
        Intent intent = new Intent(context,Destination);
        intent.putExtra(Config.ID,id);
        intent.putExtra(Config.EMOTION, feel.getEmotion());
        intent.putExtra(Config.COMMENT,feel.getComment());
        intent.putExtra(Config.DATE,feel.getStringDate());
        //https://stackoverflow.com/questions/14292398/how-to-pass-data-from-2nd-activity-to-1st-activity-when-pressed-back-android
        context.startActivityForResult(intent,1);
    }

    /** go back to the previous activity*/
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
