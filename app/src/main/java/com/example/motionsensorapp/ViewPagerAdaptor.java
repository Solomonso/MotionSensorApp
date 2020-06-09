package com.example.motionsensorapp;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdaptor extends FragmentPagerAdapter {
    public ViewPagerAdaptor(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
          Fragment fragment = null;
          switch (position)
          {
              case 0:
                  fragment = new AllSensorData();
                  break;
              case 1:

                  fragment = new MostRecent();
                  break;
          }
          return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position){
           case 0:
               return "All Sensor Data";
           case 1:
               return "Most Recent";
       }
       return null;
    }
}
