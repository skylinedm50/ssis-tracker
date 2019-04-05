package com.example.ssis_tracker.view.actividades;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.actividades.AdapterFragmentActividades;
import com.example.ssis_tracker.model.Actividad;
import com.example.ssis_tracker.presenter.actividades.ActividadesActivityPresenter;
import com.example.ssis_tracker.presenter.actividades.ActividadesActivityPresenterImpl;

import java.util.ArrayList;

public class ActividadesActivity extends AppCompatActivity implements ActividadesActivityView {
    private ViewPager viewPagerActividades;
    private ActividadesActivityPresenter actividadesActivityPresenter;
    private TextView textWithoutData;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int proceso;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        proceso = getIntent().getIntExtra("proceso",0);
        String nombreProceso = getIntent().getStringExtra("nombre");
        actividadesActivityPresenter = new ActividadesActivityPresenterImpl(this);
        viewPagerActividades = findViewById(R.id.viewPagerActividades);
        TextView textViewNombreProceso = findViewById(R.id.textViewNombreProceso);
        textWithoutData = findViewById(R.id.textWithoutData);
        //swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        textViewNombreProceso.setText(nombreProceso);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getActividades(proceso);
            }
        });*/
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

    @Override
    protected void onResume() {
        super.onResume();
        getActividades(proceso);
    }

    public void setViewPager(ArrayList<Actividad> actividadArrayList){
        int count = 0;
        AdapterFragmentActividades adapterFragmentActividades;
        adapterFragmentActividades = new AdapterFragmentActividades(getSupportFragmentManager());

        for(Actividad actividad: actividadArrayList){
            count += 1;
            ActividadesFragment actividadesFragment = new ActividadesFragment();
            actividadesFragment.actividad = actividad;
            actividadesFragment.posicion = String.valueOf(count) + '/' + actividadArrayList.size();

            adapterFragmentActividades.AddFragment(actividadesFragment, null);
        }
        viewPagerActividades.setAdapter(adapterFragmentActividades);
    }

    @Override
    public void getActividades(int proceso) {
        showSwipeRefreshLayout(true);
        actividadesActivityPresenter.getActividades(proceso);
    }

    @Override
    public void showActividades(ArrayList<Actividad> actividadArrayList) {
        showSwipeRefreshLayout(false);
        setViewPager(actividadArrayList);
        textWithoutData.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String strMessage) {
        Snackbar.make(findViewById(android.R.id.content), strMessage, Snackbar.LENGTH_LONG).show();
        showSwipeRefreshLayout(false);
        textWithoutData.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSwipeRefreshLayout(boolean bool) {
        viewPagerActividades.setVisibility(bool ? View.GONE :View.VISIBLE);
        //swipeRefreshLayout.setRefreshing(bool);
    }
}
