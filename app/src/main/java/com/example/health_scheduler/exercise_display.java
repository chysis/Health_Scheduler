package com.example.health_scheduler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class exercise_display extends AppCompatActivity {

    public static Context context_main;
    public int var;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_display);

        TextView textViewt =findViewById(R.id.exerciseName);

        int number[] = new int[100];

        int i=0;

        Intent intent = getIntent();
        number = intent.getIntArrayExtra("number");

        // 제목에 settxt를 하기위한 스위치문
        switch (number[0]) {
            case 1:
                textViewt.setText("덤벨컬");
                break;
            case 2:
                textViewt.setText("해머컬");
                break;
            case 3:
                textViewt.setText("바이셉컬");
                break;
            case  4:
                textViewt.setText("트라이셉스 익스텐션(바벨)");
                break;
            case  5:
                textViewt.setText("트라이셉스 익스텐션(덤벨)");
                break;
            default:
                break;
        }


    /*   context_main = this;


    public void onClick(View view){
        finish();
    }*/
    }
}
