package com.example.psh.donga_app2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by psh on 17. 7. 22.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter{
    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BuminFragment bumin = new BuminFragment();
                return bumin;
            case 1:
                GuduckFragment gudunk = new GuduckFragment();
                return gudunk;
            case 2:
                SeunghakFragment seunghak = new SeunghakFragment();
                return seunghak;
            default:
                return null;
        }
    }
    public int getCount() {
        return tabCount;
    }
}
