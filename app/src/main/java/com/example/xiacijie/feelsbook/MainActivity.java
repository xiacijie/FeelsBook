package com.example.xiacijie.feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Button> buttonList = new ArrayList<Button>();
    private ArrayList<TextView> emotionCounterTextList = new ArrayList<TextView>();
    private EditText commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the elements from the layout

        getTextElements();
        getButtonElements();
        getCounterTextElements();

        //bind the listener
        bindEmotionButtonsListener();



    }

    /** Get the text elements from the layout */
    private void getTextElements(){

        commentText = (EditText) findViewById(R.id.commentText);

    }


    /** Bind the event listener of clicking the emotion button */
    private void bindEmotionButtonsListener(){
        for (int i =0; i < buttonList.size(); i ++){
            final int j = i;
            Button currentButton = buttonList.get(i);
            currentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emotionClickHandler(j);
                }
            });
        }
    }

    /** The event happens when the user clicks the emotion button */
    private void emotionClickHandler( int i){
        TextView currentCounter = (TextView) emotionCounterTextList.get(i);
        String number = currentCounter.getText().toString();
        int num =  Integer.parseInt(number);
        num += 1;
        currentCounter.setText(Integer.toString(num));



    }

    /** Get the counter elements from the layout */
    private void getCounterTextElements(){

        emotionCounterTextList.add((TextView) findViewById(R.id.loveCount));
        emotionCounterTextList.add((TextView) findViewById(R.id.joyCount));
        emotionCounterTextList.add((TextView) findViewById(R.id.surpriseCount));
        emotionCounterTextList.add((TextView) findViewById(R.id.angerCount));
        emotionCounterTextList.add((TextView) findViewById(R.id.sadnessCount));
        emotionCounterTextList.add((TextView) findViewById(R.id.fearCount));

    }


    /** Get the button elements from the layout */
    private void getButtonElements(){

        buttonList.add((Button) findViewById(R.id.loveButton));
        buttonList.add((Button) findViewById(R.id.joyButton));
        buttonList.add((Button) findViewById(R.id.surpriseButton));
        buttonList.add((Button) findViewById(R.id.angerButton));
        buttonList.add((Button) findViewById(R.id.sadnessButton));
        buttonList.add((Button) findViewById(R.id.fearButton));

    }
}
