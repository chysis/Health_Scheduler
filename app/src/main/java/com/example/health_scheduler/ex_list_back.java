package com.example.health_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ex_list_back extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_list_back);

        ImageButton button = findViewById(R.id.btnBenchPull);
        ImageButton button2 = findViewById(R.id.btnBentOverBarbellRow);
        ImageButton button3 = findViewById(R.id.btnChinUp);
        ImageButton button4 = findViewById(R.id.btnPullUp);
        ImageButton button5 = findViewById(R.id.btnLatPulldown);
        ImageButton button6 = findViewById(R.id.btnSeatedRow);
        ImageButton button7 = findViewById(R.id.btnDbRow);
        Button button1 = findViewById(R.id.addedList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ex_bench_pull.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), ex_bentover_barbell_row.class);
                startActivity(intent2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), ex_chin_up.class);
                startActivity(intent3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), ex_pull_up.class);
                startActivity(intent4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), ex_lat_pull_down.class);
                startActivity(intent5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getApplicationContext(), ex_seated_row.class);
                startActivity(intent6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(getApplicationContext(), ex_dumbbell_row.class);
                startActivity(intent7);
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent8 = new Intent(getApplicationContext(), added_list.class);
                startActivity(intent8);
            }
        });
    }
}
