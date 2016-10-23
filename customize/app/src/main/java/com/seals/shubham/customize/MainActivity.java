package com.seals.shubham.customize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lv;
    Integer img[] = {R.drawable.akshardham,R.drawable.banglasahib,R.drawable.connaughtplacecp,R.drawable.humayun,R.drawable.indiagate,R.drawable.jamamasjid,R.drawable.lotustemple,R.drawable.selectcitywalk,R.drawable.redfort,R.drawable.parliament};
    String name[] = {"Akshardham","Bangla Sahib","Connaught Place","Humayun Tomb","India Gate","Jama Masjid","Lotus Temple","Select CityWalk","Red Fort","Parliament House"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.listView);
        customLayout cust = new customLayout();
        lv.setAdapter(cust);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0)
        {
            Intent i = new Intent(this,Akshardham.class);
            startActivity(i);
        }
        else if(position==1)
        {
            Intent i = new Intent(this,BanglaSahib.class);
            startActivity(i);
        }
        else if(position==2)
        {
            Intent i = new Intent(this,ConnaughtPlace.class);
            startActivity(i);
        }
        else if(position==3)
        {
            Intent i = new Intent(this,HumayunTomb.class);
            startActivity(i);
        }
        else if(position==4)
        {
            Intent i = new Intent(this,IndiaGate.class);
            startActivity(i);
        }
        else if(position==5)
        {
            Intent i = new Intent(this,JamaMasjid.class);
            startActivity(i);
        }
        else if(position==6)
        {
            Intent i = new Intent(this,LotusTemple.class);
            startActivity(i);
        }
        else if(position==7)
        {
            Intent i = new Intent(this,SelectCityWalk.class);
            startActivity(i);
        }
        else if(position==8)
        {
            Intent i = new Intent(this,RedFort.class);
            startActivity(i);
        }
        else if(position==9)
        {
            Intent i = new Intent(this,ParliamentHouse.class);
            startActivity(i);
        }
    }

    public class customLayout extends BaseAdapter{

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
            View view = getLayoutInflater().inflate(R.layout.custom,parent,false);
            ImageView iv = (ImageView)view.findViewById(R.id.imageView);
            TextView tv = (TextView)view.findViewById(R.id.textView);
            iv.setImageResource(img[position]);
            tv.setText(name[position]);
            return view;
        }
    }
}
