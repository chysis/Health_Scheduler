package com.example.health_scheduler;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class added_list extends AppCompatActivity {

    PieChart pieChart;
    int[] colorArr = new int[] {Color.RED,Color.GREEN,Color.BLUE,Color.LTGRAY,Color.CYAN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_list);

        pieChart = (PieChart)findViewById(R.id.piechart);

        PieDataSet pieDataSet = new PieDataSet(data1(), "부위별 전체 운동비율");
        pieDataSet.setColors(colorArr);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.invalidate();


        ListView exListView ;
        final ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        exListView = (ListView) findViewById(R.id.exListView);
        exListView.setAdapter(adapter);




        final Button add = (Button) findViewById(R.id.btnAdd);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(added_list.this);
                alertDialog.setTitle("운동장소 선택");
                String[] items = {"헬스장","홈트"};
                int checkedItem = 1;
                alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            // 헬스장 눌렀을때
                            case 0:
                                AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(added_list.this);
                                alertDialog1.setTitle("운동선택");
                                String[] items = {"덤벨컬","해머컬","1","2","3","4","5","6","7","8","9","10","11","12","13"};
                                int checkedItem = 1;
                                alertDialog1.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        switch (which) {
                                            case 0:
                                                int count;
                                                count = adapter.getCount();

                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dumbbell_curl),
                                                        "덤벨컬");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 1:

                                                count = adapter.getCount();

                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.hammer_curl),
                                                        "해머컬");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                        }
                                    }
                                });
                                AlertDialog alert = alertDialog1.create();
                                alert.setCanceledOnTouchOutside(false);
                                alert.show();
                                break;

                            // 홈트 눌렀을때
                            case 1:

                                break;

                        }
                    }
                });
                AlertDialog alert = alertDialog.create();
                alert.setCanceledOnTouchOutside(false);
                alert.show();
            }
        });
        // 리스트뷰 아이템 추가 끝
    }

    private ArrayList<PieEntry> data1() {
        ArrayList<PieEntry> datavalue = new ArrayList<>();

        datavalue.add(new PieEntry(30, "팔 운동"));
        datavalue.add(new PieEntry(10, "어깨 운동"));
        datavalue.add(new PieEntry(20, "가슴 운동"));
        datavalue.add(new PieEntry(20, "코어 운동"));
        datavalue.add(new PieEntry(20, "다리 운동"));

        return datavalue;
    }



}