package com.example.xiacijie.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Button> buttonList = new ArrayList<Button>();
    private ArrayList<TextView> emotionCounterTextList = new ArrayList<TextView>();
    private EditText commentText;
    private ArrayAdapter<Feel> adapter;
    private ListView feelsList;
    private ArrayList<Feel> feels = new ArrayList<Feel>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the elements from the layout
        getListView();
        getTextElements();
        getButtonElements();
        getCounterTextElements();

        //bind the listener
        bindListener();



    }

    @Override
    protected void onStart(){

        super.onStart();
        feels = FileHelper.loadFile(this,Config.FILENAME);
        adapter = new ArrayAdapter<Feel>(this, R.layout.list_item, feels);
        feelsList.setAdapter(adapter);

        // set the view click listener
        feelsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActivityConnectionHelper.switchToActivity(MainActivity.this,DetailActivity.class,position,feels.get(position));
            }
        });

        updateState();

    }
    /** process the data sent back from detailActivity */
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if(resultCode == Config.DELETE) {
                int id = intent.getIntExtra(Config.ID,0);
                feels.remove(id);
                updateState();

            }
            else if (resultCode == Config.UPDATE){
                Log.d("*************action","UPDATE");
            }
        }
    }

    /** Update the state when there is change */
    private void updateState(){
        countEmotions();
        adapter.notifyDataSetChanged();
        FileHelper.saveFile(this,Config.FILENAME,feels);
    }

    /** Count the number of different kinds of emotions */
    private void countEmotions(){
        int countArray[] = {0,0,0,0,0,0};
        for (Feel feel : feels){
            if (feel.getEmotion().equals("Love")) countArray[0] ++;
            else if (feel.getEmotion().equals("Joy")) countArray[1] ++;
            else if (feel.getEmotion().equals("Surprise")) countArray[2] ++;
            else if (feel.getEmotion().equals("Anger")) countArray[3] ++;
            else if (feel.getEmotion().equals("Sadness")) countArray[4] ++;
            else if (feel.getEmotion().equals("Fear")) countArray[5] ++;
        }

        for (int i = 0 ; i < countArray.length; i ++){
            TextView currentCountView = (TextView) emotionCounterTextList.get(i);
            currentCountView.setText(Integer.toString(countArray[i]));
        }

    }

    /** Get the text elements from the layout */
    private void getTextElements(){

        commentText = (EditText) findViewById(R.id.commentText);

    }

    /** Get the listView elements from the layout */
    private void getListView(){

        feelsList = (ListView) findViewById(R.id.feelsList);
    }


    /** Bind the event listener of clicking  */
    private void bindListener(){
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

        Feel newFeel = new Feel(buttonList.get(i).getText().toString());
        feels.add(newFeel);

        updateState();




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
