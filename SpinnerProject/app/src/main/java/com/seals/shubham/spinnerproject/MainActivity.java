package com.seals.shubham.spinnerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener{
    Spinner sp;
    EditText ed;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this,R.array.Cities,android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);
        btn = (Button)findViewById(R.id.button);
        sp.setOnItemSelectedListener(this);
        ed = (EditText) findViewById(R.id.editText);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String str;
        str = sp.getSelectedItem().toString();
        ed.setText(str);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if(v==btn)
        {

        }
    }
}
