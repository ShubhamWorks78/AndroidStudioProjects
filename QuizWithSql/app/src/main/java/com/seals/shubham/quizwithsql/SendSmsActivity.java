package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SendSmsActivity extends AppCompatActivity {
    double i;
    TextView tv;
    Button sub,bck;
    EditText ed;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        tv = (TextView)findViewById(R.id.txtViewSms);
        sub = (Button)findViewById(R.id.btnSubSms);
        bck = (Button)findViewById(R.id.btnBckSms);
        ed = (EditText)findViewById(R.id.editCode);
        Bundle extra = getIntent().getExtras();
        String phone = extra.getString("Mobile");
        char mob[] = phone.toCharArray();
        for(int i=0;i<mob.length-4;i++)
            mob[i] = '*';
        i = 1000000*Math.random();
        final int j = (int)i;
        Bundle extras = getIntent().getExtras();
        user = extras.getString("user").toString();
        String fin = new String(mob);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phone,null,"You can recover your account by giving this "+j,null,null);
        Toast.makeText(this,"Strng is "+phone+" and final is "+fin+" message is"+j,Toast.LENGTH_LONG).show();
        tv.setText("A text has been sent to"+fin+".Enter the Six Digit Code:-");
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = ed.getText().toString();
                String mn = ""+j;
                if(mn.equals(str))
                {
                    Intent i = new Intent(SendSmsActivity.this,ResetPass.class);
                    i.putExtra("user",user);
                    startActivity(i);
                }
            }
        });
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SendSmsActivity.this,ForgetPass.class);
                startActivity(i);
            }
        });
    }
}
