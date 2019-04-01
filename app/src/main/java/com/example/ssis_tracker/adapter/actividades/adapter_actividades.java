package com.example.ssis_tracker.adapter.actividades;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class adapter_actividades extends FragmentPagerAdapter {

    private List<Fragment> FragmentPageList   = new ArrayList<>();
    private List<String> FragmentPageListName = new ArrayList<>();

    public adapter_actividades(FragmentManager fm) {
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
        FragmentPageListName.add(Titulo);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentPageListName.get(position);
    }
}
