package com.example.health_scheduler;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
    public static Context context_main;
    public int var;  // 다른 액티비티에서 접근할 변수
    final ArrayList<String> items = new ArrayList<String>();
    final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);

    PieChart pieChart;
    int[] colorArr = new int[] {Color.RED,Color.GREEN,Color.BLUE,Color.LTGRAY,Color.CYAN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_list);

        context_main=this;

        pieChart = (PieChart)findViewById(R.id.piechart);

        PieDataSet pieDataSet = new PieDataSet(data1(), "부위별 전체 운동비율");
        pieDataSet.setColors(colorArr);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.invalidate();

        final ListView listview = (ListView) findViewById(R.id.exListView);
        listview.setAdapter(adapter);

        Button addButton = (Button)findViewById(R.id.btnAdd);
        addButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                int count;
                count=adapter.getCount();

                items.add("LIST" + Integer.toString(count+1));

                adapter.notifyDataSetChanged();
            }
        });

        Button deleteButton = (Button)findViewById(R.id.btnDelete);
        deleteButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                int count, checked;
                count=adapter.getCount();

                if(count>0){
                    checked=listview.getCheckedItemPosition();

                    if(checked>-1&&checked<count){
                        items.remove(checked);
                        listview.clearChoices();
                        adapter.notifyDataSetChanged();
                    }
                }
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