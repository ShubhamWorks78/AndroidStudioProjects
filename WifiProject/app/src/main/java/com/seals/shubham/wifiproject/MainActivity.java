package com.seals.shubham.wifiproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    WifiManager wifi;
    WifiScanReceiver wifiRec;
    String wifis[];
    Button on,off;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        on = (Button)findViewById(R.id.btnOn);
        off = (Button)findViewById(R.id.btnOff);
        lv = (ListView)findViewById(R.id.listView);
        wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wifi.isWifiEnabled()==false)
                {
                    Toast.makeText(MainActivity.this,"Initially off",Toast.LENGTH_LONG).show();
                    wifi.setWifiEnabled(true);
                }
                wifiRec = new WifiScanReceiver();
                wifi.startScan();

            }
        });
    }

    private class WifiScanReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            List<ScanResult> list = wifi.getScanResults();
            StringBuilder sb = new StringBuilder();
            wifis = new String[list.size()];
            for(int i=0;i<list.size();i++)
            {
                sb.append((list.get(i).SSID).toString());
            }
        }
    }
}
