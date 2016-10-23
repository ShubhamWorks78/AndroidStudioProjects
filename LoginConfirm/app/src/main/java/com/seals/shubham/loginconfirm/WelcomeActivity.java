package com.seals.shubham.loginconfirm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        logOut = (Button)findViewById(R.id.btnLogOut);
        logOut.setOnClickListener(this);
        tv = (TextView)findViewById(R.id.textView);
        Bundle extra = getIntent().getExtras();
        String str = extra.getString("Name");
        tv.setText("Welcome "+str);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(i);
    }
}
