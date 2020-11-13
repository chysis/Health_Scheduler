package com.example.health_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ex_list_chest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_list_chest);

    ImageButton button = findViewById(R.id.btnBenchPress);
    ImageButton button2 = findViewById(R.id.btnBenchThrow);
    ImageButton button3 = findViewById(R.id.btnChestPress_db);
    ImageButton button4 = findViewById(R.id.btnChestPress_mc);
    ImageButton button5 = findViewById(R.id.btnPullUp);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ex_bentover_barbell_row.class);
            startActivity(intent);
        }
    });

    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent2 = new Intent(getApplicationContext(), ex_chin_up.class);
            startActivity(intent2);
        }
    });

    button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent3 = new Intent(getApplicationContext(), ex_pull_up.class);
            startActivity(intent3);
        }
    });

    button4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent4 = new Intent(getApplicationContext(), ex_lat_pull_down.class);
            startActivity(intent4);
        }
    });

    button5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent5 = new Intent(getApplicationContext(), ex_seated_row.class);
            startActivity(intent5);
        }
    });
}}
