package com.seals.shubham.customize;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by shubham on 6/10/2016.
 */
public class FragmentViewPager extends FragmentPagerAdapter{
    public FragmentViewPager(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
