package com.example.ssis_tracker.view.direcciones;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.direcciones.AdapterDirecciones;
import com.example.ssis_tracker.model.Direccion;
import com.example.ssis_tracker.presenter.direcciones.DireccionesFragmentPresenter;
import com.example.ssis_tracker.presenter.direcciones.DireccionesFragmentPresenterImpl;
import java.util.ArrayList;

public class DireccionesFragment extends Fragment implements  DireccionesFragmentView{
    View view;
    AdapterDirecciones adapterDirecciones;
    DireccionesFragmentPresenter direccionesFragmentPresenter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerViewDirecciones;
    private TextView textWithoutData;

    public DireccionesFragment(){}

    @Override
    public void onResume() {
        super.onResume();
        getDirecciones();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        direccionesFragmentPresenter = new DireccionesFragmentPresenterImpl(this);
        view = inflater.inflate(R.layout.fragment_direcciones, container, false);
        textWithoutData = view.findViewById(R.id.textWithoutData);
        recyclerViewDirecciones = view.findViewById(R.id.recyclerViewDirecciones);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        adapterDirecciones = new AdapterDirecciones(view.getContext(), new ArrayList<Direccion>());
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        recyclerViewDirecciones.setAdapter(adapterDirecciones);
        recyclerViewDirecciones.setLayoutManager(linearLayoutManager);
        recyclerViewDirecciones.scheduleLayoutAnimation();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDirecciones();
            }
        });

        configAppBar(false);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        configAppBar(true);
    }

    @Override
    public void getDirecciones() {
        adapterDirecciones.adapterDataChange(new ArrayList<Direccion>());
        showSwipeRefreshLayout(true);
        direccionesFragmentPresenter.getDirecciones();
    }

    @Override
    public void showDirecciones(ArrayList<Direccion> direccionArrayList) {
        showSwipeRefreshLayout(false);
        adapterDirecciones.adapterDataChange(direccionArrayList);
        textWithoutData.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String strMessage) {
        Snackbar.make(view, strMessage, Snackbar.LENGTH_LONG).show();
        showSwipeRefreshLayout(false);
        textWithoutData.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSwipeRefreshLayout(boolean bool) {
        recyclerViewDirecciones.setVisibility(bool ? View.GONE :View.VISIBLE);
        swipeRefreshLayout.setRefreshing(bool);
    }

    @Override
    public void configAppBar(boolean bolDefault) {
        if(bolDefault)
            ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("");
        else
            ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.direcciones);
    }
}
