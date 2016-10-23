package com.seals.shubham.customlayoutwithdifferentclickablecomponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button butn,butn1;
    String textV[] = {"Shubham","Abhishek","Madhav","Vivek","Saadique","Niraj","Prajwal"};
    String btn[] = {"next","next","next","next","next","next","next"};
    String btn2[] = {"back","back","back","back","back","back","back"};
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.listView);
        MyCustomView view = new MyCustomView();
        mListView.setAdapter(view);
    }
    public class MyCustomView extends BaseAdapter{

        @Override
        public int getCount() {
            return textV.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myView = getLayoutInflater().inflate(R.layout.customlayout,viewGroup,false);
            tv = (TextView)myView.findViewById(R.id.textView);
            butn = (Button)myView.findViewById(R.id.button);
            butn1 = (Button)myView.findViewById(R.id.button2);
            tv.setText(textV[i]);
            butn.setText(btn[i]);
            butn1.setText(btn2[i]);
            butn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this,ShubhamButn1.class);
                    startActivity(i);
                }
            });
            butn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this,ShubhamButn2.class);
                    startActivity(i);
                }
            });
            return myView;
        }
    }
}
