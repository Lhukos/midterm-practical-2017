package com.toney.burnedcaloriescalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class BurnedCaloriesCalculatorActivity extends AppCompatActivity
        implements TextView.OnEditorActionListener {

    // define variables for the widgets
    private EditText weightET;
    private TextView milesTV;
    private Spinner feetSpinner;
    private Spinner inchesSpinner;
    private SeekBar milesSeekBar;
    private TextView bmiTV;
    private TextView caloriesBurnedTV;
    private EditText nameET;

    // define instance variables that should be saved
    private String weightString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burned_calories_calculator);

        // get references to the widgets
        weightET = (EditText) findViewById(R.id.weightET);
        milesTV = (TextView) findViewById(R.id.milesTV);
        bmiTV = (TextView) findViewById(R.id.bmiTV);
        caloriesBurnedTV = (TextView) findViewById(R.id.caloriesBurnedTV);
        nameET = (EditText) findViewById(R.id.nameET);
        feetSpinner = (Spinner) findViewById(R.id.feetSpinner);
        inchesSpinner = (Spinner) findViewById(R.id.inchesSpinner);
        milesSeekBar = (SeekBar) findViewById(R.id.milesSeekBar);

        // set the listener
        // current class as listener
        weightET.setOnEditorActionListener(this);

        // anonymous class
        //milesSeekBar.setOnSeekBarChangeListener(seekBarListener);
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if(actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateAndDisplay();
        }
        return false;
    }

    private void calculateAndDisplay() {

        //get weight amount
        weightString = weightET.getText().toString();
        float weight;
        if(weightString.equals("")) {
            weight = 0;
        } else {
            weight = Float.parseFloat(weightString);
        }

        // get miles ran
        int progress = milesSeekBar.getProgress();
        //milesTV = (float) progress + 1;

        /*
        // get calories burned
        caloriesBurned = 0.75 * weight * milesRan;
        bmi = (weight * 703) / ((12 * feet + inches) * (12 * feet + inches));
         */
    }

    /*private OnSeekBarChangeListener seekBarListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            milesTV.setText(progess + "mi");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            calculateAndDisplay();
        }
    };*/
}
