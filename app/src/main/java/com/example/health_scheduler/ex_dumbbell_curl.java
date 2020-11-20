package com.example.health_scheduler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class ex_dumbbell_curl extends YouTubeBaseActivity {
    YouTubePlayerView playerView;
    YouTubePlayer player;

    private static String API_KEY="AIzaSyBrEvSjzDIdr18Sy1e3E508vpYS8FYMiUo";
    private static String videoId="XE_pHwbst04";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_dumbbell_curl);

        TextView textView = findViewById(R.id.howToDumbCurl);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

        initPlayer();

        Button button = findViewById(R.id.playDumbCurlVideo);
        final Button button2 = findViewById(R.id.btnDumbCurlAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(ex_dumbbell_curl.this);
                dlg.setTitle("모드 선택");
                final String[] versionArray = new String[] {"근지구력 (15회 3세트)", "근력 (6회 5세트)", "사용자 설정"};
                //dlg.setIcon(R.drawable.)

                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //button2.setText(versionArray[which]);
                        Intent intent = new Intent(getApplicationContext(), added_list.class);
                        intent.putExtra("덤벨 컬", versionArray[which]);
                        setResult(RESULT_OK, intent);
                        Toast toast = Toast.makeText(ex_dumbbell_curl.this, versionArray[which], Toast.LENGTH_LONG);
                        toast.show();
                        ListView listView = ((added_list)added_list.context_main).listView;
                        Adapter adapter = listView.getAdapter();
                        ArrayList<String> arrayList = ((added_list)added_list.context_main).items;

                    }
                });
                dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ex_dumbbell_curl.this, "취소", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
    }

    public void initPlayer(){
        playerView = findViewById(R.id.dumbCurlView);
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
