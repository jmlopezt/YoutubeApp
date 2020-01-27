package com.example.youtubeplayer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    private String YOUTUBE_API_KEY = "Your API key";
    private String YOUTUBE_VIDEO_ID = "wa-8VjTNV6c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(YOUTUBE_API_KEY,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Toast.makeText(this, R.string.onInitialisedToast, Toast.LENGTH_SHORT).show();
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if (!wasRestored){
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }

    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this, R.string.onPlaying_toast,Toast.LENGTH_SHORT);

        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this, R.string.onPaused_toast,Toast.LENGTH_SHORT);
        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(YoutubeActivity.this, R.string.onAdStarted_toast,Toast.LENGTH_SHORT);

        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YoutubeActivity.this, R.string.onVideoStarted_toast,Toast.LENGTH_SHORT);
        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, R.string.onInitialisationFailedToast, Toast.LENGTH_SHORT).show();
    }
}
