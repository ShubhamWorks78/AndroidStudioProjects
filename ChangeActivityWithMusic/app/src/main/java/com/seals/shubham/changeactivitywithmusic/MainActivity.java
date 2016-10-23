package com.seals.shubham.changeactivitywithmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                mp.create(getApplicationContext(), R.raw.sabtera);
                mp.start();
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        }, 15000);
    }
}
