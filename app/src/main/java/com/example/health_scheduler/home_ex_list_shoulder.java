package com.example.health_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class home_ex_list_shoulder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ex_list_shoulder);

        ImageButton button = findViewById(R.id.btnDbDiagonalRaise);
        ImageButton button2 = findViewById(R.id.btnDbFrontRaise);
        ImageButton button3 = findViewById(R.id.btnLateralRaise);
        ImageButton button4 = findViewById(R.id.btnSideLyingLtRaise);
        ImageButton button5 = findViewById(R.id.btnShoulderShrugs);
        Button button1 = findViewById(R.id.addedList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ex_dumbbell_diagonal_raise.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), ex_dumbbell_front_raise.class);
                startActivity(intent2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), ex_lateral_raise.class);
                startActivity(intent3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), ex_side_lying_lateral_raise.class);
                startActivity(intent4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), ex_shoulder_shrugs.class);
                startActivity(intent5);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getApplicationContext(), added_list.class);
                startActivity(intent6);
            }
        });
    }
}
