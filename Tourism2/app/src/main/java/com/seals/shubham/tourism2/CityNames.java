package com.seals.shubham.tourism2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by shubham on 6/1/2016.
 */
public class CityNames extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn)
        {
            Intent i = new Intent(this,Tourism.class);
            startActivity(i);
        }
    }
}
