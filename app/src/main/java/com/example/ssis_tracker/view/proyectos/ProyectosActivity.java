package com.example.ssis_tracker.view.proyectos;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.proyectos.AdapterProyectos;
import com.example.ssis_tracker.model.Proyecto;
import com.example.ssis_tracker.presenter.proyectos.ProyectosActivityPresenter;
import com.example.ssis_tracker.presenter.proyectos.ProyectosActivityPresenterImpl;

import java.util.ArrayList;

public class ProyectosActivity extends AppCompatActivity implements ProyectosActivityView{
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerViewProyectos;
    private AdapterProyectos adapterProyectos;
    private TextView textWithoutData;
    private ProyectosActivityPresenter proyectosActivityPresenter;
    private int direccion;

    @Override
    protected void onCreate(@android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos);
        direccion = getIntent().getIntExtra("direccion",0);
        proyectosActivityPresenter = new ProyectosActivityPresenterImpl(this);

        textWithoutData = findViewById(R.id.textWithoutData);
        recyclerViewProyectos = findViewById(R.id.recyclerViewProyectos);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        adapterProyectos = new AdapterProyectos(getApplicationContext(), new ArrayList<Proyecto>());

        recyclerViewProyectos.setLayoutManager(linearLayoutManager);
        recyclerViewProyectos.setAdapter(adapterProyectos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getProyectos(direccion);
            }
        });
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
        getProyectos(direccion);
    }

    @Override
    public void getProyectos(int direccion) {
        adapterProyectos.adapterDataChange(new ArrayList<Proyecto>());
        showSwipeRefreshLayout(true);
        proyectosActivityPresenter.getProyectos(direccion);
    }

    @Override
    public void showProyectos(ArrayList<Proyecto> proyectoArrayList) {
        showSwipeRefreshLayout(false);
        adapterProyectos.adapterDataChange(proyectoArrayList);
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
        recyclerViewProyectos.setVisibility(bool ? View.GONE :View.VISIBLE);
        swipeRefreshLayout.setRefreshing(bool);
    }
}