package com.seals.shubham.customize;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
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
import android.widget.SpinnerAdapter;
import android.widget.TabHost;

public class LotusTemple extends AppCompatActivity implements View.OnClickListener{

    static final Integer imgLot[] = {R.drawable.lotustemple,R.drawable.lotuso,R.drawable.lotust,R.drawable.lotusth,R.drawable.lotusf};
    Button btn;
    ImageFragmentPagerAdapter mImageFragmentPagerAdapter;
    ViewPager vp;
    TabHost tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotus_temple);
        btn = (Button)findViewById(R.id.btnLot);
       vp = (ViewPager)findViewById(R.id.PagerLot);
        mImageFragmentPagerAdapter = new ImageFragmentPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mImageFragmentPagerAdapter);
        tb = (TabHost)findViewById(R.id.tabHostLot);
        tb.setup();
        TabHost.TabSpec tt = tb.newTabSpec("");
        tt.setIndicator("About");
        tt.setContent(R.id.tabLin1Lot);
        tb.addTab(tt);
        tt = tb.newTabSpec("");
        tt.setIndicator("Details");
        tb.addTab(tt);
        btn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if(v==btn)
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
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
            return imgLot.length;
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
            imageView.setImageResource(imgLot[position]);
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
