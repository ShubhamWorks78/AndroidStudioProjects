package com.seals.shubham.changingwallpaperservice;

import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.IOException;

/**
 * Created by shubham on 6/8/2016.
 */
public class BroadCast extends BroadcastReceiver{
    WallpaperManager wallpaperManager;
    Integer img[] = {R.drawable.akshardham,R.drawable.background,R.drawable.banglasahib,R.drawable.connaughtplacecp,R.drawable.humayun,R.drawable.indiagate,R.drawable.jamamasjid,R.drawable.lotusf,R.drawable.lotust,R.drawable.lotusth};
    static int i=0;
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED"))
        {
            wallpaperManager = WallpaperManager.getInstance(context);
            try {
                wallpaperManager.setResource(img[i]);
                i++;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(i==9)
                i = 0;
        }
    }
}
