package com.seals.shubham.mytouristapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PlacesName extends AppCompatActivity {

    ListView lv;
    Integer img[] = {R.drawable.akshardham,R.drawable.humayun,R.drawable.indiagate,R.drawable.jamamasjid,R.drawable.lotustemple,R.drawable.selectcitywalk};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.expandableListView);
        listCustom lid = new listCustom();
        lv.setAdapter(lid);
    }
    public class listCustom extends BaseAdapter{

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
           View myview =  getLayoutInflater().inflate(R.layout.customisedresource,parent,false);
            ImageView iv = (ImageView)findViewById(R.id.imageView);
            iv.setImageResource(img[position]);
            return myview;
        }
    }
}
