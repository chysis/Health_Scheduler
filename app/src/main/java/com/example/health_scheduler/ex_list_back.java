package com.example.health_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ex_bench_pull.class);
                startActivity(intent);
            }
        });

        // button2 ~ button 7 TODO
    }
}
