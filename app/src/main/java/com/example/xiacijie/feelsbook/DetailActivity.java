package com.example.xiacijie.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/** This is the activity for showing details and editing details*/
public class DetailActivity extends AppCompatActivity {

    private Button cancelButton;
    private Button saveButton;
    private Button deleteButton ;
    private RadioGroup radioGroup ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getElements();
        bindEventListener();



    }

    private void getElements(){
        cancelButton = (Button) findViewById(R.id.cancelButton);
        saveButton =  (Button) findViewById(R.id.saveButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

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
    }


    /** Go back to the previous activity */
    private void goBack(){
        ActivityConnectionHelper.goBack(this);
    }

    /** Save the result and go back */
    private void save(){
        Intent intent = new Intent();
        ActivityConnectionHelper.save(this,intent);
    }

    /** Delete the current emotion */
    private void delete(){
        Intent intent = new Intent();
        intent.putExtra(Config.ID,getIntent().getIntExtra(Config.ID,0));
        ActivityConnectionHelper.delete(this,intent);
    }
}
