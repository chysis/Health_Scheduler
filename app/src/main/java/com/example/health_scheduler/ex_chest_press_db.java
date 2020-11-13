package com.example.health_scheduler;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ex_chest_press_db extends YouTubeBaseActivity {
    YouTubePlayerView playerView;
    YouTubePlayer player;

    private static String API_KEY="AIzaSyBrEvSjzDIdr18Sy1e3E508vpYS8FYMiUo";
    private static String videoId="VmB1G1K7v94";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_chest_press_db);

        TextView textView = findViewById(R.id.howToChestPress_db);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

        initPlayer();

        Button button = findViewById(R.id.playChestPressVideo_db);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });
    }
    public void initPlayer(){
        playerView = findViewById(R.id.chestPressView_db);
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