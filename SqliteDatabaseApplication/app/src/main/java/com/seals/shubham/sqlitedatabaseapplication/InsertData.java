package com.seals.shubham.sqlitedatabaseapplication;

import android.app.Application;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InsertData extends AppCompatActivity implements View.OnClickListener{
    DbController db = new DbController(this);
    EditText ed1,ed2;
    Button sub;
    String Gen,Name,Roll;
    RadioGroup rg;
    RadioButton rm,rf;
    static int i = 0;
    MainActivity main = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        sub = (Button)findViewById(R.id.btnSub);
        ed1 = (EditText)findViewById(R.id.InsNam);
        ed2 = (EditText)findViewById(R.id.InsRoll);
        rf = (RadioButton)findViewById(R.id.GenF);
        rm = (RadioButton)findViewById(R.id.GenM);
        rg = (RadioGroup)findViewById(R.id.GrpGen);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               if(checkedId==R.id.GenM)
                   Gen = "Male";
                else if(checkedId==R.id.GenF)
                   Gen = "Female";
            }
        });
        sub.setOnClickListener(this);
    }
    public void callHomeActivity(View v)
    {
        Intent obj = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(obj);
    }

    @Override
    public void onClick(View v) {
        i++;
        Name = ed1.getText().toString();
        Roll = ed2.getText().toString();
        db.addData(i,Name,Roll,Gen);
        this.callHomeActivity(v);
    }
}