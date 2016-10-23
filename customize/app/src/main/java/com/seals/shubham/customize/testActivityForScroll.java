package com.seals.shubham.customize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class testActivityForScroll extends AppCompatActivity {

    ListView lv;
    Integer img[] = {R.drawable.redforto,R.drawable.redfortt,R.drawable.redfortth,R.drawable.redfortf,R.drawable.redfortfi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activity_for_scroll);
        lv = (ListView)findViewById(R.id.listViewTest);
        CustomLayout cust = new CustomLayout();
        lv.setAdapter(cust);
    }
    public class CustomLayout extends BaseAdapter{

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = getLayoutInflater().inflate(R.layout.customsec,parent,false);
            ImageView iv = (ImageView)findViewById(R.id.imageViewTest);
            try {
                iv.setImageResource(img[position]);
            }
            catch (Exception e)
            {

            }
            return v;
        }
    }
}
