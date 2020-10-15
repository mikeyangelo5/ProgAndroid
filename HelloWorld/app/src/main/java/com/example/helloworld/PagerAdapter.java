package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int pageamount;

    public PagerAdapter(@NonNull FragmentManager fm, int amount) {
        super(fm, amount);
        this.pageamount = amount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return new FragmentOne();
            case 1 : return new FragmentTwo();
            default : return null;
        }
    }

    @Override
    public int getCount() {
        return pageamount;
    }
}
