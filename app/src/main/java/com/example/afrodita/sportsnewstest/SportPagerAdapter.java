package com.example.afrodita.sportsnewstest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.afrodita.sportsnewstest.mvp.SportType;
import com.example.afrodita.sportsnewstest.mvp.eventlist.EventListFragment;

public class SportPagerAdapter extends FragmentPagerAdapter {

    public SportPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return SportType.values()[position].getType();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new EventListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return SportType.values().length;
    }
}
