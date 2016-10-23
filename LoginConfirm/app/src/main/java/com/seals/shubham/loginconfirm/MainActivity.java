package com.seals.shubham.loginconfirm;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DbLoader db = new DbLoader(this);
    Button log,exit;
    EditText usr,pass;
    TextView tv,frgt;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = (Button)findViewById(R.id.btnLog);
        usr = (EditText)findViewById(R.id.LogUser);
        pass = (EditText)findViewById(R.id.LogPass);
        tv = (TextView)findViewById(R.id.CreAcc);
        exit = (Button)findViewById(R.id.btnExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setMessage("Are You Sure You Wanna Exit???...");
                ad.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                });
                ad.show();
            }
        });
        cb = (CheckBox)findViewById(R.id.showPass);
        cb.setOnCheckedChangeListener(new  CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    pass.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                else
                    pass.setInputType(129);
            }
        });
        frgt = (TextView)findViewById(R.id.frgtPass);
        frgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ForgotPass.class);
                startActivity(i);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = usr.getText().toString();
                String passWord = pass.getText().toString();
                usr.setText("");
                pass.setText("");
                if(db.chckData(userName,passWord)==1)
                {
                    Intent i = new Intent(MainActivity.this,WelcomeActivity.class);
                    i.putExtra("Name",userName);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Wrong Username Or Password",Toast.LENGTH_LONG).show();
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RegistrationActitvity.class);
                startActivity(i);
            }
        });
    }
}
