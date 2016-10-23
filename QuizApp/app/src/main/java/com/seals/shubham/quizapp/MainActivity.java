package com.seals.shubham.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ema,pass;
    Button log,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ema = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.password);
        log = (Button)findViewById(R.id.btnLogin);
        reg = (Button)findViewById(R.id.btnLinkToRegisterScreen);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Registration.class);
                startActivity(i);
            }
        });
    }
}
