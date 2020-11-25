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
                        .setMessage("유튜브 영상의 key를 이용해 임베디드 링크를 만들었습니다.\n" +
                                "영상 원본과 연결되는 것으로 모든 수익은 제작자에게 전해집니다.\n" +
                                "사진은 영상에서 캡쳐했으며, 이 앱은 상업적으로 이용되지 않음을 알립니다.")
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
                        .setMessage("오픈소스(github)에서 piechart 이용.\n" +
                                "https://github.com/PhilJay/MPAndroidChart/tree/master/MPChartLib/src/main/java/com/github/mikephil/charting")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){}
                        })
                        .show();
            }
        });
    }
    }