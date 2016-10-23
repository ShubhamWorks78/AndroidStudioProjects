package com.seals.shubham.mygpsproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class showData extends AppCompatActivity {
    dbFinal mDbController = new dbFinal(this);
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        lv = (ListView) findViewById(R.id.listView);
        ArrayList ss = new ArrayList();
        ss.clear();
        ss = mDbController.show();
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ss);
        lv.setAdapter(ad);
        lv.clearChoices();
    }
}
