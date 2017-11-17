package com.example.m7mdmimo.jerb.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.m7mdmimo.jerb.fragment.GusetToDoFramgent;
import com.example.m7mdmimo.jerb.fragment.PlanFragment;

/**
 * Created by m7md mimo on 11/12/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new GusetToDoFramgent();
            case 1:
                return new PlanFragment();
            default:
                return null;}
    }

    @Override
    public int getCount() {
        return 2;
    }
}
