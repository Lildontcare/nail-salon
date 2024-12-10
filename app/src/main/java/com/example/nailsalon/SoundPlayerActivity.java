package com.example.nailsalon;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class SoundPlayerActivity extends AppCompatActivity {
    Button btnplay, btnpause, btnstop;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_player);

        btnplay = findViewById(R.id.soundplay);
        btnpause = findViewById(R.id.soundpause);
        btnstop = findViewById(R.id.soundstop);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null)
                {
                    player = MediaPlayer.create(SoundPlayerActivity.this, R.raw.lljunior);
                }
                    player.start();
            }
        });

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player !=null)
                {
                    player.pause();
                }
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player !=null)
                {
                    player.release();
                    player = null;
                }
            }
        });
    }
}
