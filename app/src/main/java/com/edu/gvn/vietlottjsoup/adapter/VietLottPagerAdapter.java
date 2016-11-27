package com.edu.gvn.vietlottjsoup.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.edu.gvn.vietlottjsoup.fragment.MaxFragment;
import com.edu.gvn.vietlottjsoup.fragment.MegaFragment;
import com.edu.gvn.vietlottjsoup.model.VietLott;

import java.util.ArrayList;

/**
 * Created by hnc on 25/11/2016.
 */

public class VietLottPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    MegaFragment megaFragment;
    MaxFragment maxFragment;

    public VietLottPagerAdapter(FragmentManager fm) {
        super(fm);
        megaFragment = new MegaFragment();
        maxFragment = new MaxFragment();
        fragments.add(megaFragment);
        fragments.add(maxFragment);

        titles.add("Mega 6/45");
        titles.add("Max 4D");
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void updateData(VietLott vietLott) {
        megaFragment.updateView(vietLott.mega645);
        maxFragment.updateView(vietLott.m4dModel);
    }
}
