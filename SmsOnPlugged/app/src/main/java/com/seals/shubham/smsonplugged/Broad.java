package com.seals.shubham.smsonplugged;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;

/**
 * Created by shubham on 6/7/2016.
 */
public class Broad extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED"))
        {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage("121",null,"Hi Shubham",null,null);
        }
    }
}
