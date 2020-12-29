package com.example.gtf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity3 extends AppCompatActivity {

    private Button buttonPlay,buttonPause;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Chronometer simpleChronometer = (Chronometer) findViewById(R.id.chrono); // initiate a chronometer
        buttonPlay = (Button) findViewById(R.id.btnplay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleChronometer.start(); // start a chronometer
            }
        });

        buttonPause = (Button) findViewById(R.id.btnpause);
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleChronometer.stop(); // start a chronometer
            }
        });
    }

}