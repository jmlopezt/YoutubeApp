package com.example.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener{

    private String YOUTUBE_API_KEY = "AIzaSyB9iK4A9yQgG6e7vx0d6aT41h_4LfNg0_o";
    private String YOUTUBE_VIDEO_ID = "wa-8VjTNV6c";
    private String YOUTUBE_PLAYLIST_ID = "PL597E0BDDC1D74ED2";
    private Button btnPlayVideo;
    private Button btnPlayPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlayPlaylist = (Button) findViewById(R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this,YOUTUBE_API_KEY,YOUTUBE_VIDEO_ID);
                break;

            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,YOUTUBE_API_KEY,YOUTUBE_PLAYLIST_ID);
                break;

            default:

        }

        if (intent!=null){
            startActivity(intent);
        }

    }
}
