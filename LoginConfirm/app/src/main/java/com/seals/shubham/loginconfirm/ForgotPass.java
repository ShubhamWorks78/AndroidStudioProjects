package com.seals.shubham.loginconfirm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPass extends AppCompatActivity implements View.OnClickListener{

    DbLoader db = new DbLoader(this);
    Button bck,sub;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        bck = (Button)findViewById(R.id.btnBck);
        sub = (Button)findViewById(R.id.btnSubmit);
        ed = (EditText)findViewById(R.id.frgtUsr);
        bck.setOnClickListener(this);
        sub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==bck)
        {
            Intent i = new Intent(ForgotPass.this,MainActivity.class);
            startActivity(i);
        }
        else if(v==sub)
        {
            String str = ed.getText().toString();
            String phone = db.getPhone(str);
            if(phone=="No")
            {

            }
            else
            {
                Intent i = new Intent(ForgotPass.this,SendSmsActivity.class);
                i.putExtra("mobile",phone);
                startActivity(i);
            }
        }
    }
}
