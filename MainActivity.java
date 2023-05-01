package com.example.task4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;




public class MainActivity extends AppCompatActivity {

    CardView cv_squats;
    CardView cv_lunges;
    CardView cv_planks;
    CardView cv_pushups;
    CardView cv_glutebridge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv_squats = findViewById(R.id.cv_squats);
        cv_lunges = findViewById(R.id.cv_lunges);
        cv_planks = findViewById(R.id.cv_planks);
        cv_pushups = findViewById(R.id.cv_pushups);
        cv_glutebridge = findViewById(R.id.cv_glutebridge);

        cv_squats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Start_Workout.class));
            }
        });
        cv_lunges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Start_Workout.class));
            }
        });
        cv_planks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Start_Workout.class));
            }
        });
        cv_pushups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Start_Workout.class));
            }
        });
        cv_glutebridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Start_Workout.class));
            }
        });


    }
}