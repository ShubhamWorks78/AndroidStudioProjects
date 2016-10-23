package com.seals.shubham.loginconfirm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SendSmsActivity extends AppCompatActivity {

    double i;
    TextView tv;
    Button sub,bck;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        tv = (TextView)findViewById(R.id.txtViewSms);
        sub = (Button)findViewById(R.id.btnSubSms);
        bck = (Button)findViewById(R.id.btnBckSms);
        ed = (EditText)findViewById(R.id.editCode);
        Bundle extra = getIntent().getExtras();
        String phone = extra.getString("mobile");
        char mob[] = phone.toCharArray();
        for(int i=0;i<mob.length-4;i++)
            mob[i] = '*';
        i = 100000*Math.random();
        final int j = (int)i;
        String fin = new String(mob);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(fin,null,""+j,null,null);
        Toast.makeText(this,"Strng is "+phone+" and final is "+fin,Toast.LENGTH_LONG).show();
        tv.setText("A text has been sent to"+fin+".Enter the Six Digit Code:-");
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = ed.getText().toString();
                String mn = " "+j;
                if(mn.substring(1,mn.length()).equals(str))
                {

                }
            }
        });
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SendSmsActivity.this,ForgotPass.class);
                startActivity(i);
            }
        });

    }
}




