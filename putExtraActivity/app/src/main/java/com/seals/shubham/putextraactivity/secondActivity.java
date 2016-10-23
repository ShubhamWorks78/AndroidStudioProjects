package com.seals.shubham.putextraactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by shubham on 5/31/2016.
 */
public class secondActivity extends AppCompatActivity{
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        tv = (TextView) findViewById(R.id.textView);
        Bundle extras;
        String newString = null;
        if(savedInstanceState==null)
        {
            extras = getIntent().getExtras();
            if(extras==null)
            {
                newString = null;
            }
            else
            {
                newString = extras.getString("Val");

            }
        }
        tv.setText(newString);
        
    }
}
