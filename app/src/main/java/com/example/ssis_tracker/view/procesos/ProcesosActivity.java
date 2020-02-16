package com.example.ssis_tracker.view.procesos;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.procesos.AdapterProcesos;
import com.example.ssis_tracker.model.Proceso;
import com.example.ssis_tracker.presenter.procesos.ProcesosActivityPresenter;
import com.example.ssis_tracker.presenter.procesos.ProcesosActivityPresenterImpl;

import java.util.ArrayList;

public class ProcesosActivity extends AppCompatActivity implements  ProcesosActivityView{
    private ProcesosActivityPresenter procesosActivityPresenter;
    private RecyclerView recyclerViewProcesos;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AdapterProcesos adapterProcesos;
    private TextView textWithoutData;
    private TextView textViewNombreProyecto;
    private int proyecto;
    private String nombreProyecto;
    private MenuItem searchItem;
    private ArrayList<Proceso> procesosArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesos);
        proyecto = getIntent().getIntExtra("proyecto",0);
        nombreProyecto = getIntent().getStringExtra("nombre");

        procesosActivityPresenter = new ProcesosActivityPresenterImpl(this);
        textWithoutData = findViewById(R.id.textWithoutData);
        textViewNombreProyecto = findViewById(R.id.textViewNombreProyecto);
        recyclerViewProcesos = findViewById(R.id.recyclerViewProcesos);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapterProcesos = new AdapterProcesos(new ArrayList<Proceso>(), getApplicationContext());

        recyclerViewProcesos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewProcesos.setAdapter(adapterProcesos);
        textViewNombreProyecto.setText(nombreProyecto);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getProcesos(proyecto);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        SearchManager searchManager = (SearchManager) ProcesosActivity.this.getSystemService(Context.SEARCH_SERVICE);

        menuInflater.inflate(R.menu.direcciones, menu);
        this.searchItem = menu.findItem(R.id.searchViewFind);


        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(ProcesosActivity.this.getComponentName()));
        }
        searchView.setQueryHint("Buscar Proceso...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList <Proceso> listClone = new ArrayList<Proceso>();
                if(procesosArrayList != null || !s.equals("")){
                    for(Proceso proceso : procesosArrayList){
                        if(proceso.getNombre().toUpperCase().contains(s.toUpperCase())){
                            listClone.add(proceso);
                        }
                    }
                    adapterProcesos.adapterDataChange(listClone);
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
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
        getProcesos(proyecto);
    }

    @Override
    public void getProcesos(int proyecto) {
        adapterProcesos.adapterDataChange(new ArrayList<Proceso>());
        showSwipeRefreshLayout(true);
        procesosActivityPresenter.getProcesos(proyecto);
    }

    @Override
    public void showProcesos(ArrayList<Proceso> procesoArrayList) {
        showSwipeRefreshLayout(false);
        this.procesosArrayList = procesoArrayList;
        adapterProcesos.adapterDataChange(procesoArrayList);
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
        recyclerViewProcesos.setVisibility(bool ? View.GONE :View.VISIBLE);
        swipeRefreshLayout.setRefreshing(bool);
    }
}
