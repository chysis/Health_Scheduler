package com.example.health_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class exercise_display extends YouTubeBaseActivity {

    YouTubePlayerView playerView;
    YouTubePlayer player;

    private static String API_KEY="AIzaSyBrEvSjzDIdr18Sy1e3E508vpYS8FYMiUo";
    private static String videoId="Z0e0ron8nDM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_display);

        TextView textViewt =findViewById(R.id.exerciseName);

        int number[] = new int[100];
        Integer sum;


        final Intent intent = getIntent();
        int i = intent.getIntExtra("inum",0);

        if (i==0){
            sum = intent.getIntExtra("sum",0);
        }
        else {
            sum = intent.getIntExtra("sum2",0);
        }

        // 맨 처음 배열 넘겨받기
        if (i==0) {
            number = intent.getIntArrayExtra("number");
        }
        // 그 이후 휴식화면에서 배열 넘겨받기
        else {
            number = intent.getIntArrayExtra("number2");
        }


        // 제목에 settext를 하기위한 스위치문
        switch (number[i]) {
            case 1:
            case 101:
                textViewt.setText("덤벨컬");
                break;
            case 2:
            case 102:
                textViewt.setText("해머컬");
                break;
            case 3:
            case 103:
                textViewt.setText("바이셉컬");
                break;
            case 4:
                textViewt.setText("트라이셉스 익스텐션(바벨)");
                break;
            case 5:
            case 104:
                textViewt.setText("트라이셉스 익스텐션(덤벨)");
                break;
            case 6:
                textViewt.setText("트라이셉스 익스텐션(머신)");
                break;

            case 7:
                textViewt.setText("벤치 프레스");
                break;
            case 9:
                textViewt.setText("벤치 스로우");
                break;
            case 10:
                textViewt.setText("체스트 프레스(덤벨)");
                break;
            case 11:
                textViewt.setText("체스트 프레스(머신)");
                break;
            case 12:
                textViewt.setText("디클라인 벤치프레스");
                break;
            case 13:
                textViewt.setText("인클라인 벤치프레스");
                break;

            case 15:
            case 109:
                textViewt.setText("덤벨 대각선 레이즈");
                break;
            case 16:
            case 110:
                textViewt.setText("덤벨 프론트 레이즈");
                break;
            case 17:
            case 111:
                textViewt.setText("레터럴 레이즈");
                break;
            case 18:
                textViewt.setText("밀리터리 프레스");
                break;
            case 19:
                textViewt.setText("리버스 플라이");
                break;
            case 20:
                textViewt.setText("숄더 프레스");
                break;
            case 21:
                textViewt.setText("업라이트 로우");
                break;
            case 22:
            case 113:
                textViewt.setText("숄더 슈러그");
                break;

            case 24:
                textViewt.setText("벤치 풀");
                break;
            case 25:
                textViewt.setText("벤트오버 바벨로우");
                break;
            case 26:
                textViewt.setText("친 업");
                break;
            case 27:
                textViewt.setText("풀 업");
                break;
            case 28:
                textViewt.setText("랫 풀다운");
                break;
            case 29:
                textViewt.setText("시티드 로우");
                break;
            case 30:
                textViewt.setText("덤벨 로우");
                break;

            case 32:
                textViewt.setText("데드 리프트");
                break;
            case 33:
                textViewt.setText("행잉 니 레이즈");
                break;

            case 35:
                textViewt.setText("레그 컬");
                break;
            case 36:
                textViewt.setText("레그 프레스");
                break;
            case 37:
                textViewt.setText("바벨 스쿼트");
                break;

            case 106:
                textViewt.setText("덤벨 플라이");
                break;
            case 107:
                textViewt.setText("푸쉬 업");
                break;

            case 112:
                textViewt.setText("사이드 라잉 래터럴 레이즈");
                break;

            case 115:
                textViewt.setText("풀 업");
                break;
            case 116:
                textViewt.setText("벤트오버 덤벨로우");
                break;
            case 117:
                textViewt.setText("스카퓰라 리트랙션");
                break;

            case 119:
                textViewt.setText("업도미널 크런치");
                break;
            case 120:
                textViewt.setText("더블 크런치");
                break;
            case 121:
                textViewt.setText("브릿지");
                break;
            case 122:
                textViewt.setText("싱글 레그 데드리프트");
                break;
            case 123:
                textViewt.setText("엘보우-투-니 크런치");
                break;
            case 124:
                textViewt.setText("행잉 니 레이즈");
                break;
            case 125:
                textViewt.setText("니 턱");
                break;
            case 126:
                textViewt.setText("헌드레드");
                break;
            case 127:
                textViewt.setText("플랭크");
                break;

            case 129:
                textViewt.setText("카프 레이즈");
                break;
            case 130:
                textViewt.setText("레터럴 런지");
                break;
            case 131:
                textViewt.setText("라잉 레그컬(덤벨)");
                break;
            case 132:
                textViewt.setText("런지");
                break;
            case 133:
                textViewt.setText("맨몸 스쿼트");
                break;
            case 134:
                textViewt.setText("스플릿 스쿼트");
                break;

            default:
                break;
        }

        i++;

        final Integer a = i;

        final int number1[] = number;
        final int Asum = sum;

        // a값이 잘 변하는지 확인하기 위한변수
        final String test;
        test = sum.toString();
        //

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),test,Toast.LENGTH_SHORT).show();

                // 운동이 모두 끝나면 운동종료화면으로
                if (a==Asum){
                    Intent intent0 = new Intent(getApplicationContext(),end_ex_display.class);
                    intent0.putExtra("num",a);
                    intent0.putExtra("number1",number1);
                    startActivity(intent0);
                }
                else {
                    Intent intent1 = new Intent(getApplicationContext(), pause_display.class);
                    intent1.putExtra("num", a);
                    intent1.putExtra("number1", number1);
                    intent1.putExtra("sum1",Asum);
                    startActivity(intent1);
                }
            }
        });

        initPlayer();

        Button button = findViewById(R.id.playVideo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    public void initPlayer(){
        playerView = findViewById(R.id.exerciseView);
        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                player=youTubePlayer;

                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                    @Override
                    public void onLoading() {}

                    @Override
                    public void onLoaded(String id) {
                        Log.d("PlayerView", "onLoaded 호출됨: " + id);
                        player.play();
                    }

                    @Override
                    public void onAdStarted() {}

                    @Override
                    public void onVideoStarted() {}

                    @Override
                    public void onVideoEnded() {}

                    @Override
                    public void onError(YouTubePlayer.ErrorReason errorReason) {}
                });
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }

    public void playVideo(){
        if(player!=null){
            if(player.isPlaying()){
                player.pause();
            }
            player.cueVideo(videoId);
        }
    }
}
