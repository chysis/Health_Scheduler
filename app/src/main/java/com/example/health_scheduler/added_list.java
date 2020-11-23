package com.example.health_scheduler;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class added_list extends AppCompatActivity {
    ListView listView;

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

        final ListView listview = (ListView) findViewById(R.id.exListView);

        Button addButton = (Button)findViewById(R.id.btnAdd);
        addButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

            }
        });

        Button deleteButton = (Button)findViewById(R.id.btnDelete);
        deleteButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

            }
        });

        Button button2 = findViewById(R.id.btnStart);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), pause_display.class);
                startActivity(intent);
            }
        });
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