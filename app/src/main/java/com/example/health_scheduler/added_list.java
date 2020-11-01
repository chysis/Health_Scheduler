package com.example.health_scheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

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
