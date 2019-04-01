package com.example.ssis_tracker.view.actividades;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.actividades.adapter_actividades;

public class ActividadesActivity extends AppCompatActivity {

    private ViewPager actividadesViewPager;
    private adapter_actividades viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        this.actividadesViewPager = findViewById(R.id.viewPagerActividades);
        SetViewPager();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void SetViewPager(){
        viewPagerAdapter = new adapter_actividades(getSupportFragmentManager());
        for(int i = 0; i  < 5; i++) {
            viewPagerAdapter.AddFragment(ActividadesFragment.NuevaInstancia(i , 5), null);
        }
        actividadesViewPager.setAdapter(viewPagerAdapter);
    }

}
