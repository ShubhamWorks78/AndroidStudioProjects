package com.seals.shubham.calculatorsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button add,sub,mult,div,cncl;
    EditText fir,sec;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.Reslt);
        fir = (EditText)findViewById(R.id.first);
        sec = (EditText)findViewById(R.id.second);
        add = (Button) findViewById(R.id.btnAdd);
        sub = (Button) findViewById(R.id.btnSub);
        mult = (Button) findViewById(R.id.btnMult);
        div = (Button) findViewById(R.id.btnDiv);
        cncl = (Button)findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.Reslt);
        add.setOnClickListener(this);
        cncl.setOnClickListener(this);
        sub.setOnClickListener(this);
        mult.setOnClickListener(this);
        div.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int ans;
        String first = fir.getText().toString();
        int firstOne = Integer.parseInt(first);
        String second = sec.getText().toString();
        int secondOne = Integer.parseInt(second);
        if(TextUtils.isEmpty(fir.getText().toString())||TextUtils.isEmpty(sec.getText().toString()))
            return;
        if(v==add)
        {
            ans = firstOne+secondOne;
            tv.setText(String.valueOf(ans));
        }
        else if(v==sub)
        {
            ans = firstOne-secondOne;
            tv.setText(String.valueOf(ans));
        }
        else if(v==mult)
        {
            ans = firstOne*secondOne;
            tv.setText(String.valueOf(ans));
        }
        else if(v==div)
        {
            float val = (float) firstOne/secondOne;
            tv.setText(String.valueOf(val));
        }
        else if(v==cncl)
        {
            fir.setText("");
            sec.setText("");

        }
    }
}
