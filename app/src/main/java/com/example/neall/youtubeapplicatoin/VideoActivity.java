package com.example.neall.youtubeapplicatoin;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.mukesh.tinydb.TinyDB;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView videoPlayer;
    final String API_KEY = "AIzaSyD23izr1ZAdU2cLlBR7S0XL3zvaSq4o8OA";
    private TinyDB tinyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        tinyDB = new TinyDB(getApplicationContext());
        videoPlayer = (YouTubePlayerView)findViewById(R.id.youtube_player);
        videoPlayer.initialize(API_KEY, this);

        TextView textView = findViewById(R.id.textView);
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        textView.setText(tinyDB.getString("videodescription"));
        textViewTitle.setText(tinyDB.getString("videotitle"));

    }

    Intent intent = getIntent();
    //String id ="x933om6j9kM";
    //String id = intent.getStringExtra("idvideo");

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean complete) {
            if (!complete) {
                youTubePlayer.cueVideo(tinyDB.getString("videoid"));
            }


        // youTubePlayer.loadVideo(VIDEO_ID);
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(VideoActivity.this, youTubeInitializationResult.toString(), Toast.LENGTH_LONG).show();
    }
}
