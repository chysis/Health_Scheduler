package com.example.health_scheduler;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class added_list extends AppCompatActivity {

    PieChart pieChart;
    int[] colorArr = new int[] {Color.RED,Color.GREEN,Color.BLUE,Color.LTGRAY,Color.CYAN,Color.YELLOW};
    int arm=0, chest=0, back=0, shoulder=0, leg=0, core=0, sum;
    List<Integer> Array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_list);

        pieChart = (PieChart)findViewById(R.id.piechart);




        final ListView exListView ;
        final ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        exListView = (ListView) findViewById(R.id.exListView);
        exListView.setAdapter(adapter);

        final Button add = (Button) findViewById(R.id.btnAdd);
        final Button del = (Button) findViewById(R.id.btnDelete);
        final Button btn_refresh = (Button) findViewById(R.id.btn_refresh);

        // number배열에 운동 번호 저장 (운동종류)
        final int number[] = new int[100];
        // number배열에 운동 타입 번호 저장 (고중량 운동?,저중량운동?,타임운동?)
        final int number2[] = new int[100];

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(added_list.this);
                alertDialog.setTitle("운동장소 선택");
                String[] items = {"헬스장","홈트"};
                int checkedItem = -1;

                alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            // 헬스장 눌렀을때
                            case 0:
                                AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(added_list.this);
                                alertDialog1.setTitle("운동선택");
                                String[] items = {"<팔 운동>", "덤벨컬", "해머컬", "바이셉컬", "트라이셉스 익스텐션(바벨)", "트라이셉스 익스텐션(덤벨)", "트라이셉스 익스텐션(머신)",
                                        "<가슴 운동>", "벤치 프레스", "벤치 스로우", "체스트 프레스(덤벨)", "체스트 프레스(머신)", "디클라인 벤치프레스", "인클라인 벤치프레스",
                                        "<어깨 운동>", "덤벨 대각선 레이즈", "덤벨 프론트 레이즈", "레터럴 레이즈", "밀리터리 프레스", "리버스 플라이", "숄더 프레스", "업라이트 로우", "숄더 슈러그",
                                        "<등 운동>", "벤치 풀", "벤트오버 바벨로우", "친 업", "풀 업", "랫 풀다운", "시티드 로우", "덤벨 로우",
                                        "<코어 운동>", "데드 리프트", "행잉 니 레이즈",
                                        "<다리 운동>", "레그 컬", "레그 프레스", "바벨 스쿼트"};
                                /*
                                        "<팔 운동>", "덤벨컬0","해머컬1","바이셉컬2","트라이셉스 익스텐션(바벨)3","트라이셉스 익스텐션(덤벨)4","트라이셉스 익스텐션(머신)5",
                                        "<가슴 운동>", "벤치 프레스10","벤치 스로우11", "체스트 프레스(덤벨)12","체스트 프레스(머신)13","디클라인 벤치프레스14","인클라인 벤치프레스15",
                                        "<어깨 운동>", "덤벨 대각선 레이즈20","덤벨 프론트 레이즈21","레터럴 레이즈22","밀리터리 프레스23", "리버스 플라이24", "숄더 프레스25", "업라이트 로우26", "숄더 슈러그27",
                                        "<등 운동>", "벤치 풀30", "벤트오버 바벨로우31", "친 업32", "풀 업33", "랫 풀다운34", "시티드 로우35", "덤벨 로우36",
                                        "<코어 운동>", "데드 리프트40", "행잉 니 레이즈41",
                                        "<다리 운동>", "레그 컬50", "레그 프레스51", "바벨 스쿼트52"
                                 */
                                int checkedItem = -1;
                                alertDialog1.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        switch (which) {
                                            case 1:
                                                int count;
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(0);
                                                number[count]=which;

                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dumbbell_curl),
                                                        "덤벨컬");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 2:
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(1);
                                                number[count]=which;

                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.hammer_curl),
                                                        "해머컬");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 3:
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(2);
                                                number[count]=which;

                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.biceps_curl),
                                                        "바이셉컬");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 4:
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(3);
                                                number[count]=which;

                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.triceps_bb),
                                                        "트라이셉스 익스텐션(바벨)");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 5:
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(4);
                                                number[count]=which;

                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.triceps_db),
                                                        "트라이셉스 익스텐션(덤벨)");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 6:
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(5);
                                                number[count]=which;

                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.triceps_mc),
                                                        "트라이셉스 익스텐션(머신)");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 8:
                                                count = adapter.getCount();
                                                chest++;
                                                Array.add(10);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bench_press),
                                                        "벤치 프레스");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 9:
                                                count = adapter.getCount();
                                                chest++;
                                                Array.add(11);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bench_throw),
                                                        "벤치 스로우");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 10:
                                                count = adapter.getCount();
                                                chest++;
                                                Array.add(12);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.chestpress_db),
                                                        "체스트 프레스(덤벨)");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 11:
                                                count = adapter.getCount();
                                                chest++;
                                                Array.add(13);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.chestpress_mc),
                                                        "체스트 프레스(머신)");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 12:
                                                count = adapter.getCount();
                                                chest++;
                                                Array.add(14);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.declinebenchpress),
                                                        "디클라인 벤치 프레스");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 13:
                                                count = adapter.getCount();
                                                chest++;
                                                Array.add(15);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.inclinebenchpress),
                                                        "인클라인 벤치 프레스");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 15:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(20);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dumbbell_diagonal),
                                                        "덤벨 대각선 레이즈");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 16:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(21);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dumbbell_front),
                                                        "덤벨 프론트 레이즈");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 17:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(22);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lateral_raise),
                                                        "레터럴 레이즈");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 18:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(23);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.military_press),
                                                        "밀리터리 프레스");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 19:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(24);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.reverse_fly),
                                                        "리버스 플라이");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 20:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(25);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.shoulder_press),
                                                        "숄더 프레스");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 21:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(26);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.upright_row),
                                                        "업라이트 로우");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 22:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(27);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.shoulder_shrugs),
                                                        "숄더 슈러그");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 24:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(30);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bench_pull),
                                                        "벤치 풀");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 25:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(31);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bent_over_barbelll_row),
                                                        "벤트오버 바벨로우");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 26:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(32);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.chin_up),
                                                        "친 업");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 27:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(33);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.pull_up),
                                                        "풀 업");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 28:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(34);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lat_pull_down),
                                                        "랫 풀다운");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 29:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(35);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.seated_row),
                                                        "시티드 로우");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 30:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(36);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bent_over_dumbbell_row),
                                                        "덤벨 로우");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 32:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(40);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.deadlift),
                                                        "데드 리프트");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 33:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(41);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.hanging_knee_raise),
                                                        "행잉 니 레이즈");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 35:
                                                count = adapter.getCount();
                                                leg++;
                                                Array.add(50);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.leg_curl),
                                                        "레그 컬");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 36:
                                                count = adapter.getCount();
                                                leg++;
                                                Array.add(51);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.leg_press),
                                                        "레그 프레스");

                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 37:
                                                count = adapter.getCount();
                                                leg++;
                                                Array.add(52);
                                                number[count]=which;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.barbell_squat),
                                                        "바벨 스쿼트");

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
                                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(added_list.this);
                                alertDialog2.setTitle("운동선택");
                                String[] items2 = {"<팔 운동>", "덤벨컬","해머컬","바이셉컬","트라이셉스 익스텐션(덤벨)",
                                        "<가슴 운동>", "덤벨 플라이","푸쉬 업",
                                        "<어깨 운동>", "덤벨 대각선 레이즈","덤벨 프론트 레이즈","레터럴 레이즈","사이드 라잉 레터럴 레이즈", "숄더 슈러그",
                                        "<등 운동>", "풀 업", "벤트오버 덤벨로우", "스카퓰라 리트랙션",
                                        "<코어 운동>", "업도미널 크런치", "더블 크런치", "브릿지", "싱글 레그 데드리프트", "엘보우-투-니 크런치", "행잉 니 레이즈", "니 턱", "헌드레드", "플랭크",
                                        "<다리 운동>", "카프 레이즈", "레터럴 런지", "라잉 레그컬(덤벨)", "런지", "맨몸 스쿼트", "스플릿 스쿼트"};
                                /*
                                        "<팔 운동>", "덤벨컬100","해머컬101","바이셉컬102","트라이셉스 익스텐션(덤벨)103",
                                        "<가슴 운동>", "덤벨 플라이200","푸쉬 업201",
                                        "<어깨 운동>", "덤벨 대각선 레이즈300","덤벨 프론트 레이즈301","레터럴 레이즈302","사이드 라잉 레터럴 레이즈303", "숄더 슈러그304",
                                        "<등 운동>", "풀 업400", "벤트오버 덤벨로우401", "스카퓰라 리트랙션402", "시티드 밴드 로우403",
                                        "<코어 운동>", "업도미널 크런치500", "더블 크런치501", "브릿지502", "싱글 레그 데드리프트503", "엘보우-투-니 크런치504", "행잉 니 레이즈505", "니 턱506", "헌드레드507", "플랭크508",
                                        "<다리 운동>", "카프 레이즈600", "레터럴 런지601", "라잉 레그컬(덤벨)602", "런지603", "맨몸 스쿼트604", "스플릿 스쿼트605"
                                 */


                                int checkedItem2 = -1;
                                alertDialog2.setSingleChoiceItems(items2, checkedItem2, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        switch (which) {
                                            case 1:
                                                int count;
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(100);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dumbbell_curl),
                                                        "덤벨컬");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 2:
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(101);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.hammer_curl),
                                                        "해머컬");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 3:
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(102);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.biceps_curl),
                                                        "바이셉 컬");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 4:
                                                count = adapter.getCount();
                                                arm++;
                                                Array.add(103);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.triceps_db),
                                                        "트라이셉스 익스텐션(덤벨)");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 6:
                                                count = adapter.getCount();
                                                chest++;
                                                Array.add(200);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dumbbell_fly),
                                                        "덤벨 플라이");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 7:
                                                count = adapter.getCount();
                                                chest++;
                                                Array.add(201);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.push_up),
                                                        "푸쉬 업");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 9:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(300);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dumbbell_diagonal),
                                                        "덤벨 대각선 레이즈");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 10:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(301);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dumbbell_front),
                                                        "덤벨 프론트 레이즈");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 11:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(302);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lateral_raise),
                                                        "레터럴 레이즈");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 12:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(303);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.side_lying_lateral),
                                                        "사이드 라잉 레터럴 레이즈");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 13:
                                                count = adapter.getCount();
                                                shoulder++;
                                                Array.add(304);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.shoulder_shrugs),
                                                        "숄더 슈러그");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 15:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(400);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.pull_up),
                                                        "풀 업");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 16:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(401);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bent_over_dumbbell_row),
                                                        "벤트오버 덤벨로우");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 17:
                                                count = adapter.getCount();
                                                back++;
                                                Array.add(402);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.scapular_retraction),
                                                        "스카퓰라 리트랙션");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 19:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(500);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.abdominal_crunch),
                                                        "업도미널 크런치");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 20:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(501);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.abdominal_double_crunch),
                                                        "더블 크런치");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 21:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(502);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bridge),
                                                        "브릿지");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 22:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(503);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.single_leg_deadlift),
                                                        "싱글 레그 데드리프트");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 23:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(504);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.elbow_knee_crunch),
                                                        "엘보우-투-니 크런치");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 24:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(505);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.hanging_knee_raise),
                                                        "행잉 니 레이즈");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 25:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(506);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.knee_tuck),
                                                        "니 턱");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 26:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(507);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.pilates_hundreds),
                                                        "헌드레드");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 27:
                                                count = adapter.getCount();
                                                core++;
                                                Array.add(508);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.plank),
                                                        "플랭크");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;

                                            case 29:
                                                count = adapter.getCount();
                                                leg++;
                                                Array.add(600);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.calf_raise),
                                                        "카프 레이즈");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 30:
                                                count = adapter.getCount();
                                                leg++;
                                                Array.add(601);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lateral_lunge),
                                                        "레터럴 런지");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 31:
                                                count = adapter.getCount();
                                                leg++;
                                                Array.add(602);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.leg_dum_curl),
                                                        "덤벨 라잉 레그 컬");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 32:
                                                count = adapter.getCount();
                                                leg++;
                                                Array.add(603);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lunge),
                                                        "런지");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 33:
                                                count = adapter.getCount();
                                                leg++;
                                                Array.add(604);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.squat),
                                                        "맨몸 스쿼트");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                            case 34:
                                                count = adapter.getCount();
                                                leg++;
                                                Array.add(605);
                                                number[count]=which+100;
                                                // 아이템 추가.
                                                adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.split_squat),
                                                        "스플릿 스쿼트");
                                                // listview 갱신
                                                adapter.notifyDataSetChanged();
                                                break;
                                        }
                                    }
                                });
                                AlertDialog alert2 = alertDialog2.create();
                                alert2.setCanceledOnTouchOutside(false);
                                alert2.show();
                                break;
                        }
                    }
                });
                AlertDialog alert = alertDialog.create();
                alert.setCanceledOnTouchOutside(false);
                alert.show();
            }
        });

        /*
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                exListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        int count, checked ;
                        count = adapter.getCount() ;

                        if (count > 0) {
                            // 현재 선택된 아이템의 position 획득.
                            checked = exListView.getCheckedItemPosition();

                            if (checked > -1 && checked < count) {
                                // 아이템 삭제
                                adapter.remove(checked) ;

                                // listview 선택 초기화.
                                exListView.clearChoices();

                                // listview 갱신.
                                adapter.notifyDataSetChanged();

                            }
                });

            }
        });

         */

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PieDataSet pieDataSet = new PieDataSet(data1(), "부위별 전체 운동비율");
                pieDataSet.setColors(colorArr);

                PieData pieData = new PieData(pieDataSet);

                pieChart.setData(pieData);
                pieChart.invalidate();
            }
        });



        Button btn_to_exstart = findViewById(R.id.btnStart);
        btn_to_exstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), exercise_display.class);
                Intent intent2 = new Intent(getApplicationContext(), pause_display.class);
                Integer a = exListView.getCount();
                int aa = exListView.getCount();
                if(a!=0){
                    Toast.makeText(getApplicationContext(),a.toString()+"개",Toast.LENGTH_SHORT).show();
                    intent1.putExtra("number",number);
                    intent1.putExtra("sum",aa);
                    startActivity(intent1);
                }

                /*TextView textView2 = ((exercise_display)exercise_display.context_main).textView;
                Button next = ((exercise_display)exercise_display.context_main).btnNext;

                for(int i=0;i<Array.size();i++) {

                    switch (Array.get(i)) {
                        case 0:
                            textView2.setText("<Gym> 덤벨 컬");
                        case 1:
                            textView2.setText("<Gym> 해머 컬");
                        case 2:
                            textView2.setText("<Gym> 바이셉스 컬");
                        case 3:
                            textView2.setText("<Gym> 트라이셉스 익스텐션(바벨)");
                        case 4:
                            textView2.setText("<Gym> 트라이셉스 익스텐션(덤벨)");
                        case 5:
                            textView2.setText("<Gym> 트라이셉스 익스텐션(머신)");
                        case 10:
                            textView2.setText("<Gym> 벤치 프레스");
                        case 11:
                            textView2.setText("<Gym> 벤치 스로우");
                        case 12:
                            textView2.setText("<Gym> 체스트 프레스(덤벨)");
                        case 13:
                            textView2.setText("<Gym> 체스트 프레스(머신)");
                        case 14:
                            textView2.setText("<Gym> 디클라인 벤치 프레스");
                        case 15:
                            textView2.setText("<Gym> 인클라인 벤치 프레스");
                        case 20:
                            textView2.setText("<Gym> 덤벨 대각선 레이즈");
                        case 21:
                            textView2.setText("<Gym> 덤벨 프론트 레이즈");
                        case 22:
                            textView2.setText("<Gym> 레터럴 레이즈");
                        case 23:
                            textView2.setText("<Gym> 밀리터리 프레스");
                        case 24:
                            textView2.setText("<Gym> 리버스 플라이");
                        case 25:
                            textView2.setText("<Gym> 숄더 프레스");
                        case 26:
                            textView2.setText("<Gym> 업라이트 로우");
                        case 27:
                            textView2.setText("<Gym> 숄더 슈러그");
                        case 30:
                            textView2.setText("<Gym> 벤치 풀");
                        case 31:
                            textView2.setText("<Gym> 벤트오버 바벨로우");
                        case 32:
                            textView2.setText("<Gym> 친 업");
                        case 33:
                            textView2.setText("<Gym> 풀 업");
                        case 34:
                            textView2.setText("<Gym> 랫 풀다운");
                        case 35:
                            textView2.setText("<Gym> 시티드 로우");
                        case 36:
                            textView2.setText("<Gym> 덤벨 로우");
                        case 40:
                            textView2.setText("<Gym> 데드 리프트");
                        case 41:
                            textView2.setText("<Gym> 행잉 니 레이즈");
                        case 50:
                            textView2.setText("<Gym> 레그 컬");
                        case 51:
                            textView2.setText("<Gym> 레그 프레스");
                        case 52:
                            textView2.setText("<Gym> 바벨 스쿼트");
                        case 100:
                            textView2.setText("<Home> 덤벨 컬");
                        case 101:
                            textView2.setText("<Home> 해머 컬");
                        case 102:
                            textView2.setText("<Home> 바이셉 컬");
                        case 103:
                            textView2.setText("<Home> 트라이셉스 익스텐션(덤벨)");
                        case 200:
                            textView2.setText("<Home> 덤벨 플라이");
                        case 201:
                            textView2.setText("<Home> 푸쉬 업");
                        case 300:
                            textView2.setText("<Home> 덤벨 대각선 레이즈");
                        case 301:
                            textView2.setText("<Home> 덤벨 프론트 레이즈");
                        case 302:
                            textView2.setText("<Home> 레터럴 레이즈");
                        case 303:
                            textView2.setText("<Home> 사이드 라잉 레터럴 레이즈");
                        case 304:
                            textView2.setText("<Home> 숄더 슈러그");
                        case 400:
                            textView2.setText("<Home> 풀 업");
                        case 401:
                            textView2.setText("<Home> 벤트오버 덤벨로우");
                        case 402:
                            textView2.setText("<Home> 스카퓰라 리트랙션");
                        case 403:
                            textView2.setText("<Home> 시티드 밴드로우");
                        case 500:
                            textView2.setText("<Home> 업도미널 크런치");
                        case 501:
                            textView2.setText("<Home> 더블 크런치");
                        case 502:
                            textView2.setText("<Home> 브릿지");
                        case 503:
                            textView2.setText("<Home> 싱글 레그 데드리프트");
                        case 504:
                            textView2.setText("<Home> 엘보우-투-니 크런치");
                        case 505:
                            textView2.setText("<Home> 행잉 니 레이즈");
                        case 506:
                            textView2.setText("<Home> 니 턱");
                        case 507:
                            textView2.setText("<Home> 헌드레드");
                        case 508:
                            textView2.setText("<Home> 플랭크");
                        case 600:
                            textView2.setText("<Home> 카프 레이즈");
                        case 601:
                            textView2.setText("<Home> 레터럴 런지");
                        case 602:
                            textView2.setText("<Home> 덤벨 라잉 레그 컬");
                        case 603:
                            textView2.setText("<Home> 런지");
                        case 604:
                            textView2.setText("<Home> 스쿼트");
                        case 605:
                            textView2.setText("<Home> 스플릿 스쿼트");
                    }

                startActivity(intent1);

                startActivity(intent2);

                }*/

            }
        });

        // 리스트뷰 아이템 추가 끝
    }

    private ArrayList<PieEntry> data1() {
        ArrayList<PieEntry> datavalue = new ArrayList<>();
        sum=arm+chest+back+shoulder+core+leg;

        datavalue.add(new PieEntry(arm, "팔"));
        datavalue.add(new PieEntry(shoulder, "어깨"));
        datavalue.add(new PieEntry(chest, "가슴"));
        datavalue.add(new PieEntry(core, "코어"));
        datavalue.add(new PieEntry(leg, "다리"));
        datavalue.add(new PieEntry(back, "등"));

        return datavalue;
    }



}