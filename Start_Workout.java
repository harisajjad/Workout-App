package com.example.task4;


import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Start_Workout extends AppCompatActivity {
    private TextView workoutTextView;
    private TextView workoutTimeTextView;
    private EditText workoutDurationEditText;
    private TextView restTextView;
    private TextView restTimeTextView;
    private EditText restDurationEditText;
    private Button startStopButton;
    private ProgressBar progressBar;

    private CountDownTimer timer;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);

        // Initialize UI components
        workoutTextView = findViewById(R.id.work_out_textview);
        workoutTimeTextView = findViewById(R.id.workout_time_text_view);
        workoutDurationEditText = findViewById(R.id.workout_duration_edittext);
        restTextView = findViewById(R.id.rest_text_view);
        restTimeTextView = findViewById(R.id.rest_time_textview);
        restDurationEditText = findViewById(R.id.rest_duration_edittext);
        startStopButton = findViewById(R.id.start_stopbutton);
        progressBar = findViewById(R.id.progressbar);

        // Set click listener for start/stop button
        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });
    }

    private void startTimer() {
        int workoutDuration = Integer.parseInt(workoutDurationEditText.getText().toString()) * 60 * 1000; // convert minutes to milliseconds
        int restDuration = Integer.parseInt(restDurationEditText.getText().toString()) * 60 * 1000; // convert minutes to milliseconds
        int totalDuration = workoutDuration + restDuration;

        timer = new CountDownTimer(totalDuration, 1000) {
            boolean isResting = false;
            int progress = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);

                if (isResting) {
                    restTimeTextView.setText(timeLeftFormatted);
                } else {
                    workoutTimeTextView.setText(timeLeftFormatted);
                }

                progress ++;
                progressBar.setProgress(progress);

                if (millisUntilFinished < restDuration && !isResting) {
                    isResting = true;
                    playSound();

                    restTimeTextView.setVisibility(View.VISIBLE);
                    workoutTimeTextView.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFinish() {
                stopTimer();
                playSound();

            }
        }.start();

        isRunning = true;
        startStopButton.setText("Stop");
    }

    private void stopTimer() {
        timer.cancel();
        isRunning = false;
        startStopButton.setText("Start");
        workoutTimeTextView.setText("00:00");
        restTimeTextView.setText("00:00");
        progressBar.setProgress(0);
        restTimeTextView.setVisibility(View.INVISIBLE);
        workoutTimeTextView.setVisibility(View.VISIBLE);
        playSound();
    }

    private void playSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.notification);
        mediaPlayer.start();


    }


}