package com.example.health_scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class pause_display extends Activity {

    private static final int MILLISINFUTURE = 31 * 1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private int count = 30;
    private TextView countTxt;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_display);

        //
        final Intent intent = getIntent();

        final int i = intent.getIntExtra("num", 0);
        final int number[] = intent.getIntArrayExtra("number1");
        final Integer sum = intent.getIntExtra("sum1", 1);

        Integer a = i;

        //a값이 잘 변하는지 확인하기 위한 변수
        //final String test = sum.toString();

        /*
        Button button = findViewById(R.id.btn_goto_ex);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), test, Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getApplicationContext(), exercise_display.class);
                intent1.putExtra("inum", i);
                intent1.putExtra("number2", number);
                intent1.putExtra("sum2", sum);
                startActivity(intent1);
            }
        });
        */

        countTxt = (TextView) findViewById(R.id.count_txt);
        countDownTimer();
        countDownTimer.start();

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    public void countDownTimer() {
        final Intent intent = getIntent();
        final int i = intent.getIntExtra("num", 0);
        final int number[] = intent.getIntArrayExtra("number1");
        final Integer sum = intent.getIntExtra("sum1", 1);

        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            public void onTick(long millisUntilFinished) {
                countTxt.setText(String.valueOf(count));
                count--;
            }

            public void onFinish() {
                countTxt.setText(String.valueOf("Finish"));
                Intent intent1 = new Intent(getApplicationContext(), exercise_display.class);
                intent1.putExtra("inum", i);
                intent1.putExtra("number2", number);
                intent1.putExtra("sum2", sum);
                startActivity(intent1);
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            countDownTimer.cancel();
        } catch (Exception e) {
        }
    }
}
