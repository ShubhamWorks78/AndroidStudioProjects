package com.seals.shubham.ecommerce;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by shubham on 7/14/2016.
 */
public class pager extends FragmentStatePagerAdapter{
    int tabCount;
    public pager(FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                tab1 tb1 = new tab1();
                return tb1;
            case 1:
                tab2 tb2 = new tab2();
                return tb2;
            case 2:
                tab3 tb3 = new tab3();
                return tb3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
