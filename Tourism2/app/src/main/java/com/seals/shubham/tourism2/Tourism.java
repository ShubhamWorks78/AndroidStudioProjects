package com.seals.shubham.tourism2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Tourism extends AppCompatActivity implements AdapterView.OnItemClickListener{
    Spinner sp;
    String str[] = {"Delhi","Mumbai","Banglore","Bhopal","Udaipur","Jaipur"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_names);
        sp = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,str);
        sp.setAdapter(ad);
        sp.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
