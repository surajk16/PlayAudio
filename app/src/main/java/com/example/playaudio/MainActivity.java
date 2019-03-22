package com.example.playaudio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button play, pause, stop;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);

        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bensound_creativeminds);
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        final Uri mediaPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bensound_creativeminds);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bensound_creativeminds);
            }
        });
    }
}
