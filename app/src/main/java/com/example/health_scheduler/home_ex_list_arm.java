package com.example.health_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class home_ex_list_arm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ex_list_arm);

        ImageButton button = findViewById(R.id.btnDumbCurl);
        ImageButton button2=findViewById(R.id.btnHamCurl);
        ImageButton button3=findViewById(R.id.btnBicepscurl);
        ImageButton button4=findViewById(R.id.btnTriExten_db);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ex_dumbbell_curl.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2=new Intent(getApplicationContext(), ex_hammer_curl.class);
                startActivity(intent2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3=new Intent(getApplicationContext(), ex_biceps_curl.class);
                startActivity(intent3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent4=new Intent(getApplicationContext(), ex_triceps_extension_db.class);
                startActivity(intent4);
            }
        });
    }
}
