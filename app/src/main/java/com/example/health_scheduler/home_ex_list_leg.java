package com.example.health_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class home_ex_list_leg extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_ex_list_leg);

        ImageButton button = findViewById(R.id.btnCalfRaise);
        ImageButton button2=findViewById(R.id.btnLateralLunge);
        ImageButton button3=findViewById(R.id.btnLyingLegCurlWithDumbbell);
        ImageButton button4=findViewById(R.id.btnLunge);
        ImageButton button5=findViewById(R.id.btnSquat);
        ImageButton button6=findViewById(R.id.btnSplitSquat);
        Button addbtn = findViewById(R.id.addedList);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ex_calf_raise.class);
                startActivity(intent);
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(), added_list.class);
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2=new Intent(getApplicationContext(), ex_lateral_lunge.class);
                startActivity(intent2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3=new Intent(getApplicationContext(), ex_lying_leg_curl_db.class);
                startActivity(intent3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent4=new Intent(getApplicationContext(), ex_lunge.class);
                startActivity(intent4);
            }
        });
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent5=new Intent(getApplicationContext(), ex_squat.class);
                startActivity(intent5);
            }
        });
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent6=new Intent(getApplicationContext(), ex_split_squat.class);
                startActivity(intent6);
            }
        });
    }
}
