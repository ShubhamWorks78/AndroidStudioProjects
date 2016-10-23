package com.seals.shubham.sqlitedatabaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteData extends AppCompatActivity implements View.OnClickListener{
    DbController db = new DbController(this);
    Button btn;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        ed = (EditText)findViewById(R.id.editText3);
        btn = (Button)findViewById(R.id.delete);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String roll = ed.getText().toString();
        db.deleteData(roll);
        this.callHomeActivity(v);
    }
    public void callHomeActivity(View v)
    {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
