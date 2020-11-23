package com.example.health_scheduler;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class pause_display extends Activity {

    private static final int MILLISINFUTURE = 31*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private int count=10;
    private TextView countTxt;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_display);

        countTxt = (TextView)findViewById(R.id.count_txt);
        countDownTimer();
        countDownTimer.start();
    }

    public void countDownTimer(){

        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL){
            public void onTick(long millisUntilFinished){
                countTxt.setText(String.valueOf(count));
                count--;
            }
            public void onFinish(){
                countTxt.setText(String.valueOf("Finish"));
            }
        };
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        try{
            countDownTimer.cancel();
        } catch (Exception e){}
    }
}
