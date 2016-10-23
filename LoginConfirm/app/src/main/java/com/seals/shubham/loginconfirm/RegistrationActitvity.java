package com.seals.shubham.loginconfirm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActitvity extends AppCompatActivity implements View.OnClickListener{
    DbLoader db = new DbLoader(this);
    EditText usr,pass,mob;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_actitvity);
        reg = (Button)findViewById(R.id.btnSign);
        usr = (EditText)findViewById(R.id.editUser);
        pass = (EditText)findViewById(R.id.editPass);
        mob = (EditText)findViewById(R.id.editPhone);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user = usr.getText().toString();
        String passWord = pass.getText().toString();
        String phone = mob.getText().toString();
        db.insertData(user,passWord,phone);
        this.callHomeActivity(v);
    }
    public void callHomeActivity(View v)
    {
        Intent i = new Intent(RegistrationActitvity.this,MainActivity.class);
        startActivity(i);
    }
}
