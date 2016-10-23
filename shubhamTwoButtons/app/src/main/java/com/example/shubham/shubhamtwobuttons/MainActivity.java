package com.example.shubham.shubhamtwobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button b,b1;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button);
        b1 = (Button)findViewById(R.id.button2);
        tv = (TextView)findViewById(R.id.textView);
    }
    public void show(View v)
    {
        tv.setText("Shubham Anand alias Sankalp Shubham");
    }
    public void delete(View v)
    {
        tv.setText("");
    }
}
