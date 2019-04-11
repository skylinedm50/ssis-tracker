package com.example.ssis_tracker.adapter.actividades;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterFragmentActividades extends FragmentStatePagerAdapter {

    private List<Fragment> FragmentPageList   = new ArrayList<>();

    public AdapterFragmentActividades(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return FragmentPageList.get(i);
    }

    @Override
    public int getCount() {
        return FragmentPageList.size();
    }

    public void AddFragment(Fragment fragmentActividad , String Titulo){
        FragmentPageList.add(fragmentActividad);
    }

    @Override
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }
}
