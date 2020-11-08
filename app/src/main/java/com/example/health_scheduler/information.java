package com.example.health_scheduler;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class information extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        Button button=findViewById(R.id.btnDeveloper);
        Button button1=findViewById(R.id.btnCopyright);
        Button button2=findViewById(R.id.btnTechnology);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(information.this)
                        .setTitle("개발자 안내")
                        .setMessage("KWU 공학설계입문 3조\n\n조장: 장준영, 조원: 박철민")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                        .show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(information.this)
                        .setTitle("저작권 안내")
                        .setMessage("TODO")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                        .show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(information.this)
                        .setTitle("TECHNOLOGY")
                        .setMessage("TODO")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){}
                        })
                        .show();
            }
        });
    }
    }