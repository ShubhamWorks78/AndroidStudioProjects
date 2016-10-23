package com.seals.shubham.changingwallpaperastime;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shubham on 6/8/2016.
 */
public class MyService extends Service{
    static int i=0;
    Integer img[] = {R.drawable.akshardham,R.drawable.background,R.drawable.banglasahib,R.drawable.connaughtplacecp,R.drawable.humayun,R.drawable.indiagate,R.drawable.jamamasjid,R.drawable.lotusf,R.drawable.lotust,R.drawable.lotusth};
    WallpaperManager mWallpaperManager;
    Timer myTimer;
    int inter = 10000;
    int prev = 1;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myTimer = new Timer();
        mWallpaperManager = WallpaperManager.getInstance(MyService.this);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    mWallpaperManager.setResource(img[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                i++;
                if(i==9)
                    i=0;
            }
        },10000,inter);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
