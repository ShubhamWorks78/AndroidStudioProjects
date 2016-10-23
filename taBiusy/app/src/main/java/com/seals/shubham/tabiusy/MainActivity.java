package com.seals.shubham.tabiusy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    TabHost tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,MySecond.class);
            }
        }, 5000);
        tab = (TabHost) findViewById(R.id.tabHost);
        tab.setup();
        TabHost.TabSpec tt = tab.newTabSpec("");
        tt.setIndicator("Chat");
        tt.setContent(R.id.linearLayout);
        tab.addTab(tt);

        TabHost.TabSpec tb = tab.newTabSpec("");
        tb.setIndicator("Call");
        tb.setContent(R.id.linearLayout2);
        tab.addTab(tb);

        TabHost.TabSpec ta = tab.newTabSpec("");
        ta.setIndicator("Contacts");
        ta.setContent(R.id.linearLayout3);
        tab.addTab(ta);

    }
}
