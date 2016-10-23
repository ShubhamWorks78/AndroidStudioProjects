package com.seals.shubham.messageservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Telephony;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shubham on 6/9/2016.
 */
public class MessageService extends Service{

    SmsManager sm;
    Timer mTimer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        sm = SmsManager.getDefault();
        mTimer = new Timer();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                sm.sendTextMessage("121",null,"Hi Unknown",null,null);
            }
        },1000,2*60*1000);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
