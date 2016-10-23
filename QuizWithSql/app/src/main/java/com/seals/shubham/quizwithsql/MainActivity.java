package com.seals.shubham.quizwithsql;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView log,sign,forg;
    EditText user,pass;
    Button logIn,exit;
    CheckBox cb;
    dbController db = new dbController(this);
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
                Intent i = new Intent(MainActivity.this,RegistrationActivity.class);
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
                user.setText("");
                pass.setText("");
                if((db.chckData(userN,passN))==1)
                {
                    String type = db.getType(userN,passN);
                    Toast.makeText(MainActivity.this,"Type is:-"+type,Toast.LENGTH_LONG).show();
                    if((type.toUpperCase()).equals("ADMIN"))
                    {
                        Intent i = new Intent(MainActivity.this,AdminPage.class);
                        i.putExtra("Name",userN);
                        startActivity(i);
                    }
                    else if((type.toUpperCase()).equals("USER"))
                    {
                        Intent i = new Intent(MainActivity.this,UserPage.class);
                        i.putExtra("Name",userN);
                        startActivity(i);
                    }
                    else
                        Toast.makeText(MainActivity.this,""+type,Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Shekarrr",Toast.LENGTH_LONG).show();
                }
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
