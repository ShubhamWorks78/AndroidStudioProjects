package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPass extends AppCompatActivity{
    dbController db = new dbController(ForgetPass.this);
    Button sub,bck;
    TextView mess;
    EditText user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        sub = (Button)findViewById(R.id.btnSubmit);
        bck = (Button)findViewById(R.id.btnBck);
        mess = (TextView)findViewById(R.id.frgtTextMess);
        user = (EditText)findViewById(R.id.frgtUsr);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userN = user.getText().toString();
                if((db.val(userN))!=null)
                {
                    String mob = db.val(userN);
                    Intent i = new Intent(ForgetPass.this,SendSmsActivity.class);
                    i.putExtra("user",userN);
                    i.putExtra("Mobile",mob);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(ForgetPass.this,"Wrong Username",Toast.LENGTH_LONG).show();
                }
            }
        });
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgetPass.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}