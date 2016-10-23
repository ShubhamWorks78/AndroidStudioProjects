package com.seals.shubham.changingwallpaperastime;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler hnd = new Handler();
        hnd.postDelayed(new Runnable() {
            @Override
            public void run() {
                MediaPlayer mp;
                mp = MediaPlayer.create(getApplicationContext(),R.raw.sab);
                long startTime = System.currentTimeMillis();
                while((System.currentTimeMillis()-startTime)<10000)
                {
                    mp.start();
                }
                mp.stop();
                startService(new Intent(MainActivity.this,MyService.class));
            }
        }, 4000);
    }
}
