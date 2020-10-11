package com.example.newpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Welcome extends AppCompatActivity {

    Button join;
    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.final_video);

        videoView.start();

        videoView.requestFocus();
        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        join = (Button) findViewById(R.id.joinButton);
        join.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openJoin();
            }
        });

        log = (Button) findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openLog();
            }
        });

    }

    public void openJoin(){
        Intent intent = new Intent(this, JoinUs.class);
        startActivity(intent);
    }

    public void openLog(){
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }
}