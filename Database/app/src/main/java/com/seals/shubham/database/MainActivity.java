package com.seals.shubham.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase mSQLiteDatabase;

    static int i = 0;
    Button btn,btn2;
    ListView lv;
    ArrayList arr = new ArrayList();
    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        btn = (Button)findViewById(R.id.button);
        mSQLiteDatabase = openOrCreateDatabase("StudentDb",MODE_PRIVATE,null);
        lv = (ListView)findViewById(R.id.listView);
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                Cursor c = mSQLiteDatabase.rawQuery("Select * from RECORD",null);
                while(c.moveToNext())
                {
                    String ser = c.getString(0);
                    String name = c.getString(1);
                    String age = c.getString(2);
                    sb.append(ser);
                    sb.append(name);
                    sb.append(age);
                    arr.add(sb);
                    ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arr);
                    lv.setAdapter(ad);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                String str = ed1.getText().toString();
                String str2 = ed2.getText().toString();
                mSQLiteDatabase.execSQL("Create table IF NOT exists RECORD"+"(Serial_no varchar primary key, Name varchar(20) not null,Age varchar(3)");
                mSQLiteDatabase.execSQL("INSERT INTO RECORD(Serial_no,Name,Age) values"+"("+i+",'"+str+"','"+str2+"')");
            }
        });
    }
}
