package com.seals.shubham.quizwithsql;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPass extends AppCompatActivity {
    dbController db = new dbController(this);
    CheckBox fir,sec;
    EditText res,cnf;
    Handler hnd;
    String user;
    Button reset;
    TextView mTextView,mess;
    public void  callHomeActivity(View view)
    {
        Intent i = new Intent(ResetPass.this,MainActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        mTextView = (TextView)findViewById(R.id.resetPassMess);
        reset = (Button)findViewById(R.id.btnReset);
        res = (EditText)findViewById(R.id.resetNew);
        cnf = (EditText)findViewById(R.id.resetNewCnfrm);
        mess = (TextView)findViewById(R.id.afterResMess);
        fir = (CheckBox)findViewById(R.id.chckReset);
        sec = (CheckBox)findViewById(R.id.chckResetCnfrm);
        Bundle extras = getIntent().getExtras();
        user = extras.getString("user");
        fir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    res.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
                }
                else
                {
                    res.setInputType(129);
                }
            }
        });
        sec.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    cnf.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
                else
                    cnf.setInputType(129);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str,str1;
                str = res.getText().toString();
                str1 = cnf.getText().toString();
                if(str.equals(str1))
                {
                    hnd = new Handler();
                    int i = db.updatePassword(user,str);
                    if(i==1)
                        mess.setText("Password Not Updated Successfully!!");
                    else
                        mess.setText("Password Updated Successfully!!!");
                    hnd.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    },5000);
                    Intent k = new Intent(ResetPass.this,MainActivity.class);
                    startActivity(k);
                }
            }
        });
    }

}
