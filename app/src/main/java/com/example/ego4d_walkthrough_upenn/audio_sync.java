package com.example.ego4d_walkthrough_upenn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class audio_sync extends AppCompatActivity {
    MediaPlayer player;
    private Button back;
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_sync);

        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);

        next.setText("Next Step");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_page();
            }
        });

        back.setText("Previous Step");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previous_page();
            }
        });

    }

    public void play(View v){
        if (player == null){
            player = MediaPlayer.create(this, R.raw.audio_sync);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });

        }
        player.start();
    }


    public void stopPlayer(){
        if (player!= null){
            player.release();
            player = null;
            Toast.makeText(this, "Media Player Release", Toast.LENGTH_SHORT);
        }
    }

    public void previous_page(){
        Intent intent = new Intent(this, qr_code_sync_video.class);
        startActivity(intent);
        finish();
    }

    public void next_page(){
        Intent intent = new Intent(this, take_seperator.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }
}