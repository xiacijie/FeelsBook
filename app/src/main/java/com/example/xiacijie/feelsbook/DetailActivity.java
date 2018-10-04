package com.example.xiacijie.feelsbook;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Currency;
import java.util.Date;

/** This is the activity for showing details and editing details*/
public class DetailActivity extends AppCompatActivity {

    private Button cancelButton;
    private Button saveButton;
    private Button deleteButton ;
    private Button dateButton;
    private Button timeButton;
    private TextView emotionText;
    private EditText commentText;
    private TextView dateText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getElements();
        bindEventListener();

        emotionText.setText(getIntent().getStringExtra(Config.EMOTION));
        commentText.setText(getIntent().getStringExtra(Config.COMMENT));
        dateText.setText(getIntent().getStringExtra(Config.DATE));

    }

    /** get the elements from the layout */
    private void getElements(){
        cancelButton = (Button) findViewById(R.id.cancelButton);
        saveButton =  (Button) findViewById(R.id.saveButton);
        dateButton = (Button) findViewById(R.id.dateButton);
        timeButton = (Button) findViewById(R.id.timeButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        emotionText = (TextView) findViewById(R.id.emotionText);
        commentText = (EditText) findViewById(R.id.editComment);
        dateText = (TextView) findViewById(R.id.dateText);

    }



    /** bind the event listeners for elements */
    private void bindEventListener(){

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
//            https://developer.android.com/guide/topics/ui/controls/pickers
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                ((TimePickerFragment) newFragment).setContext(DetailActivity.this);
                newFragment.show(getSupportFragmentManager(), "timePicker");


            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            // https://developer.android.com/guide/topics/ui/controls/pickers
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                ((DatePickerFragment) newFragment).setContext(DetailActivity.this);
                newFragment.show(getSupportFragmentManager(), "datePicker");

            }
        });
    }

    /** To update the date */
    public void updateTime(int hour,int minute){
        String currentDateString = dateText.getText().toString();
        String newDateString = currentDateString.substring(0,11) + String.format("%02d",hour) +":" +String.format("%02d",minute) +":00";
        dateText.setText(newDateString);

    }

    /** To update the time */
    public void updateDate(int year, int month, int day){
        Log.d("mmmmmmmmmmmm",month+"");
        String currentDateString = dateText.getText().toString();
        String newDateString = String.format("%04d",year) +"-" + String.format("%02d",month+1) +"-" + String.format("%02d",day) + currentDateString.substring(10,19);
        dateText.setText(newDateString);


    }


    /** Go back to the previous activity */
    private void goBack(){
        ActivityConnectionHelper.goBack(this);
    }

    /** Save the result and go back */
    private void save(){
        Intent intent = new Intent();
        intent.putExtra(Config.ID,getIntent().getIntExtra(Config.ID, 0));
        intent.putExtra(Config.COMMENT,commentText.getText().toString());
        intent.putExtra(Config.DATE,dateText.getText().toString());
        ActivityConnectionHelper.save(this,intent);
    }

    /** Delete the current emotion */
    private void delete(){
        Intent intent = new Intent();
        intent.putExtra(Config.ID,getIntent().getIntExtra(Config.ID,0));
        ActivityConnectionHelper.delete(this,intent);
    }
}
