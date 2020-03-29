package com.example.signuplogin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;



public class TabAdapter extends FragmentPagerAdapter {


    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int tabposition) {
        switch (tabposition){
            case 0:
                profiletab profile_tab=new profiletab();
                return profile_tab;
            case 1:
                UserTab userTab=new UserTab();
                return userTab;
            case 2:
                sharepictureTab sharepicture_Tab=new sharepictureTab();
                return sharepicture_Tab;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {

        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Profile";
            case 1:
                return "Users";
            case 2:
                return "Share Picture";
             default:
                 return null;
        }

    }
}
