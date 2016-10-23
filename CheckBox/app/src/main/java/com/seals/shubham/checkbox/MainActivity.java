package com.seals.shubham.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,View.OnClickListener{

    ToggleButton tb;
    SeekBar sb;
    TextView tv,tv2;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        cb = (CheckBox) findViewById(R.id.checkBox);
        sb = (SeekBar)findViewById(R.id.seekBar);
        tv = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tb.setOnClickListener(this);
        cb.setOnClickListener(this);
        sb.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tv.setText("Count is "+progress);
        if(progress==90)
            tv2.setText("Crossed "+progress);
        else if(progress==75)
            tv2.setText("Crossed "+progress);
        else if(progress==60)
            tv2.setText("Crossed "+progress);
        else if(progress==40)
            tv2.setText("Crossed "+progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this,"Started",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this,"Stopped",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
     if(v==cb)
     {
         if(cb.isChecked())
         {
             Toast.makeText(this,"Checked",Toast.LENGTH_LONG).show();
         }
         else
         {
             Toast.makeText(this,"UnChecked",Toast.LENGTH_LONG).show();
         }
     }
     else if(v==tb)
     {
         if(tb.isChecked())
         {
             Toast.makeText(this,"On",Toast.LENGTH_LONG).show();
         }
         else
         {
             Toast.makeText(this,"Off",Toast.LENGTH_LONG).show();
         }
     }
    }
}
