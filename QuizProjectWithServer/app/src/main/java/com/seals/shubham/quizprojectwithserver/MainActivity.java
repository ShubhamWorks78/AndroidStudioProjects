package com.seals.shubham.quizprojectwithserver;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView log,sign,forg;
    EditText user,pass;
    Button logIn,exit;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = (TextView)findViewById(R.id.LogMess);
        sign = (TextView)findViewById(R.id.CreAcc);
        forg = (TextView)findViewById(R.id.frgtPass);
        logIn = (Button)findViewById(R.id.btnLog);
        user = (EditText)findViewById(R.id.LogUser);
        pass = (EditText)findViewById(R.id.LogPass);
        exit = (Button)findViewById(R.id.btnExit);
        cb = (CheckBox)findViewById(R.id.showPass);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    pass.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
                }
                else
                {
                    pass.setInputType(129);
                }
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Registration.class);
                startActivity(i);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setMessage("Are you Sure You wanna Exit??...");
                ab.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                });
                ab.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ab.show();
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userN = user.getText().toString();
                String passN = pass.getText().toString();
            }
        });
        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ForgetPass.class);
                startActivity(i);
            }
        });
    }
}
