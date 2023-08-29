package com.example.ego4d_walkthrough_upenn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class second_video_qr extends AppCompatActivity {

    private VideoView sync_vid;

    private Button back;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_video_qr);

        sync_vid = (VideoView) findViewById(R.id.videoView);
        String urlPath = "android.resource://" + getPackageName() + "/" + R.raw.time_sync;
        Uri uri = Uri.parse(urlPath);
        sync_vid.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        sync_vid.setMediaController(mediaController);
        mediaController.setAnchorView(sync_vid);

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

    public void previous_page(){
        Intent intent = new Intent(this, take_seperator.class);
        startActivity(intent);
        finish();
    }

    public void next_page(){
        Intent intent = new Intent(this, second_audio_sync.class);
        startActivity(intent);
        finish();
    }
}