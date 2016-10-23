package com.seals.shubham.mygallery;

import android.os.Vibrator;
import android.provider.ContactsContract;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Gallery gal;
    Vibrator mVibrator;
    ImageView iv;
    long pat[] = {300,4000,100,22,1230};
    Integer img[] = {R.drawable.humayun,R.drawable.ic_launcher,R.drawable.indiagate,R.drawable.indiagateo,R.drawable.indiagatet,R.drawable.jamamasjid,R.drawable.lotusf,R.drawable.lotuso,R.drawable.lotust,R.drawable.selectcitywalk};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gal = (Gallery)findViewById(R.id.gallery);
        iv = (ImageView)findViewById(R.id.imageView);
        Custom cust = new Custom();
        mVibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        gal.setAdapter(cust);
        gal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                iv.setImageResource(img[position]);
                mVibrator.vibrate(4000);
                mVibrator.vibrate(pat,-1);
            }
        });
    }
    public class Custom extends BaseAdapter{

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return img[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView ive = new ImageView(MainActivity.this);
            ive.setImageResource(img[position]);
            return ive;
        }
    }
}
