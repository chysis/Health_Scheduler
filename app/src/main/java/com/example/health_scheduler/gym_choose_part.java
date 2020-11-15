package com.example.health_scheduler;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class gym_choose_part extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gym_choose_part);

        Button button = findViewById(R.id.btnGymArm);
        Button button2 = findViewById(R.id.btnGymShoulder);
        Button button3 = findViewById(R.id.btnGymChest);
        Button button4 = findViewById(R.id.btnGymCore);
        Button button5 = findViewById(R.id.btnGymLeg);
        Button button6 = findViewById(R.id.btnGymBack);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ex_list_arm.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(getApplicationContext(), ex_list_shoulder.class);
                startActivity(intent2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(getApplicationContext(), ex_list_chest.class);
                startActivity(intent3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent4 = new Intent(getApplicationContext(), ex_list_core.class);
                startActivity(intent4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent5 = new Intent(getApplicationContext(), ex_list_leg.class);
                startActivity(intent5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent6 = new Intent(getApplicationContext(), ex_list_back.class);
                startActivity(intent6);
            }
        });
    }
}