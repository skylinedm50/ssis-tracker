package com.example.ssis_tracker.view.actividades;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.actividades.FragmentAdapterActividades;
import java.util.ArrayList;

public class ActividadesActivity extends AppCompatActivity {

    private ViewPager actividadesViewPager;
    private FragmentAdapterActividades viewPagerAdapter;
    private ArrayList<Integer> arrayListCodigoActividades = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        this.actividadesViewPager = findViewById(R.id.viewPagerActividades);
        this.arrayListCodigoActividades.add(1);
        this.arrayListCodigoActividades.add(2);
        this.arrayListCodigoActividades.add(3);
        this.arrayListCodigoActividades.add(4);
        this.arrayListCodigoActividades.add(5);
        this.arrayListCodigoActividades.add(6);

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
        viewPagerAdapter = new FragmentAdapterActividades(getSupportFragmentManager());
        for(int i = 0; i  < this.arrayListCodigoActividades.size(); i++) {
            viewPagerAdapter.AddFragment(ActividadesFragment.NuevaInstancia(i , this.arrayListCodigoActividades.size()), null);
        }
        actividadesViewPager.setAdapter(viewPagerAdapter);
    }

}
