package com.example.health_scheduler;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class exercise_display extends AppCompatActivity {

    public static Context context_main;
    public int var;
    TextView textView = findViewById(R.id.exerciseName);
    Button btnNext = findViewById(R.id.btnNext);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_display);

        context_main = this;
    }

    public void onClick(View view){
        finish();
    }
}
