package com.example.android.seattletourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Rean on 9/11/2017.
 */

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CustomFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new BlankOneFragment();
        } else {
            return new BlankTwoFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return mContext.getString(R.string.TabOne);
        } else {
            return mContext.getString(R.string.TabTwo);
        }
    }
}
