package com.seals.shubham.myecommerceapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageButton iv;
    Handler hnd;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hnd = new Handler();
        mp = MediaPlayer.create(MainActivity.this,R.raw.sabtera);
        hnd.postDelayed(new Runnable() {
            @Override
            public void run() {
                mp.start();
            }
        }, 25000);
        mp.stop();
        Intent i = new Intent(MainActivity.this,LogInOrSignUp.class);
        startActivity(i);
    }
}
