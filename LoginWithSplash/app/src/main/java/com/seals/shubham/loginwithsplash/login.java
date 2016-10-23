package com.seals.shubham.loginwithsplash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener{

    static String s,s1;
    Button btn;
    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        s = ed1.getText().toString();
        s1 = ed2.getText().toString();
        String usr = ed1.getText().toString();
        String pass = ed2.getText().toString();
        if(usr.equals(pass))
        {
            Toast.makeText(this,"Login Successfull",Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,third.class);
            i.putExtra("Username",usr);
            i.putExtra("Password",pass);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this,"Login Failed...Try again",Toast.LENGTH_LONG).show();
        }
    }
}
