package com.seals.shubham.customize;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class BanglaSahib extends AppCompatActivity implements View.OnClickListener{
    static final Integer imgBang[] = {R.drawable.lotustemple};
    static final String que[] = {"Days Open:","Hours for Visit:","Nearest Metro:","Charge:","Camera:","Food:"};
    static final String ans[] = {"All days of the Week","5:00Am to 12:00Am","Chandni Chowk","Rs.35 per head","Allowed","RoadSide Stalls and Restraunts"};
    Button btn;
    ViewPager vp;
    ImageFragmentPagerAdapter mImageFragmentPagerAdapter;
    TabHost tb;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ssss);
        btn = (Button)findViewById(R.id.btnBang);
        tb = (TabHost)findViewById(R.id.tabHost);
        vp = (ViewPager)findViewById(R.id.PagerBang);
        mImageFragmentPagerAdapter = new ImageFragmentPagerAdapter(getSupportFragmentManager());
        tb.setup();
        vp.setAdapter(mImageFragmentPagerAdapter);
        TabHost.TabSpec tt = tb.newTabSpec("");
        tt.setIndicator("About");
        tt.setContent(R.id.linearLayout);
        tb.addTab(tt);
        tt = tb.newTabSpec("");
        tt.setIndicator("Details");
        tt.setContent(R.id.linearLayout3);
        btn.setOnClickListener(this);
        tb.addTab(tt);
    }


    @Override
    public void onClick(View v) {
        if(v==btn)
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }

    public class customLayout extends BaseAdapter{

        @Override
        public int getCount() {
            return que.length;
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
            View view = getLayoutInflater().inflate(R.layout.custom_text,parent,false);
            TextView tv1 = (TextView)view.findViewById(R.id.CustTextO);
            TextView tv2 = (TextView)view.findViewById(R.id.CustTextT);

            tv1.setText(que[position]);
            tv2.setText(ans[position]);
             return view;
        }
    }
    private static class ImageFragmentPagerAdapter extends FragmentPagerAdapter {

        public ImageFragmentPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            SwipeFragment fragment = new SwipeFragment();
            return SwipeFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return imgBang.length;
        }
    }
    public static class SwipeFragment extends  Fragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View swipeView = inflater.inflate(R.layout.fragment_switch,container,false);
            ImageView imageView = (ImageView)swipeView.findViewById(R.id.fragment);
            Bundle bundle = getArguments();
            int position = bundle.getInt("position");
            imageView.setImageResource(imgBang[position]);
            return swipeView;
        }
        static SwipeFragment newInstance(int position)
        {
            SwipeFragment swipeFragment = new SwipeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position",position);
            swipeFragment.setArguments(bundle);
            return swipeFragment;
        }
    }
}
