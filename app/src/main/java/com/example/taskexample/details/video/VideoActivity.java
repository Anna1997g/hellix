package com.example.taskexample.details.video;

import android.content.Intent;
import android.os.Bundle;

import com.example.taskexample.R;
import com.example.taskexample.details.DetailsActivity;
import com.example.taskexample.utils.YoutubeConfig;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity {
    YouTubePlayer.OnInitializedListener onInitializedListener;

    private String youtubeid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.view_youtube);

        Intent intent = getIntent();
        youtubeid = intent.getStringExtra(DetailsActivity.YOUTUBE_ID_KEY);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(youtubeid);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(YoutubeConfig.getApiKey(), onInitializedListener);

    }
}
