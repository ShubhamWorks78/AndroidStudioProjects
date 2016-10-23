package com.seals.shubham.sqlitedatabaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateData extends AppCompatActivity implements View.OnClickListener{

    DbController db = new DbController(this);
    Button btn;
    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        btn = (Button)findViewById(R.id.Update);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = ed1.getText().toString();
        String roll = ed2.getText().toString();
        db.updateData(name,roll);
        this.callHomeActivity(v);
    }
    public void callHomeActivity(View v)
    {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
