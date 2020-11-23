package com.example.health_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class home_ex_list_core extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ex_list_core);

        ImageButton button = findViewById(R.id.btnAbdominalCrunch);
        ImageButton button3 = findViewById(R.id.btnAbdominalDoubleCrunch);
        ImageButton button4 = findViewById(R.id.btnBridge);
        ImageButton button5 = findViewById(R.id.btnSingleLegDeadlift);
        ImageButton button6 = findViewById(R.id.btnElbowtoKneeCrunch);
        ImageButton button7 = findViewById(R.id.btnHangingKneeRaise);
        ImageButton button8 = findViewById(R.id.btnKneeTuck);
        ImageButton button9 = findViewById(R.id.btnPilatesHundreds);
        ImageButton button10 = findViewById(R.id.btnPlank);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ex_abdominal_crunch.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), ex_abdominal_double_crunch.class);
                startActivity(intent3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), ex_bridge.class);
                startActivity(intent4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), ex_single_leg_deadlift.class);
                startActivity(intent5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getApplicationContext(), ex_elbow_to_knee_crunch.class);
                startActivity(intent6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(getApplicationContext(), ex_hanging_knee_raise.class);
                startActivity(intent7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(getApplicationContext(), ex_knee_tuck.class);
                startActivity(intent8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent9 = new Intent(getApplicationContext(), ex_pilates_hundreds.class);
                startActivity(intent9);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent10 = new Intent(getApplicationContext(), ex_plank.class);
                startActivity(intent10);
            }
        });
    }
}
