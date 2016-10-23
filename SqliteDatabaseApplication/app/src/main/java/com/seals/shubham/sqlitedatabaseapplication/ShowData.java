package com.seals.shubham.sqlitedatabaseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {
    DbController db = new DbController(this);
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        lv = (ListView)findViewById(R.id.listView);
        ArrayList ss = new ArrayList();
        ss.clear();
        ss = db.showData();
        ArrayAdapter<String> dd = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ss);
        lv.clearChoices();
        lv.setAdapter(dd);
    }
}
