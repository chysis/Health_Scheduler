package com.example.health_scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class exercise_display extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_display);

        TextView textViewt =findViewById(R.id.exerciseName);

        int number[] = new int[100];
        Integer sum;


        final Intent intent = getIntent();
        int i = intent.getIntExtra("inum",0);

        if (i==0){
            sum = intent.getIntExtra("sum",0);
        }
        else {
            sum = intent.getIntExtra("sum2",0);
        }

        // 맨 처음 배열 넘겨받기
        if (i==0) {
            number = intent.getIntArrayExtra("number");
        }
        // 그 이후 휴식화면에서 배열 넘겨받기
        else {
            number = intent.getIntArrayExtra("number2");
        }


        // 제목에 settext를 하기위한 스위치문
        switch (number[i]) {
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

        i++;

        final Integer a = i;
        
        final int number1[] = number;
        final int Asum = sum;

        // a값이 잘 변하는지 확인하기 위한변수
        final String test;
        test = sum.toString();
        //



        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),test,Toast.LENGTH_SHORT).show();

                // 운동이 모두 끝나면 운동종료화면으로
                if (a==Asum){
                    Intent intent0 = new Intent(getApplicationContext(),end_ex_display.class);
                    intent0.putExtra("num",a);
                    intent0.putExtra("number1",number1);
                    startActivity(intent0);
                }
                else {
                    Intent intent1 = new Intent(getApplicationContext(), pause_display.class);
                    intent1.putExtra("num", a);
                    intent1.putExtra("number1", number1);
                    intent1.putExtra("sum1",Asum);
                    startActivity(intent1);
                }
            }
        });




    /*   context_main = this;


    public void onClick(View view){
        finish();
    }*/
    }


}
