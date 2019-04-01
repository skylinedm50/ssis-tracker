package com.example.ssis_tracker.repository.proyectos;

import com.example.ssis_tracker.api.proyectos.ApiAdapterProyectos;
import com.example.ssis_tracker.api.proyectos.ApiServiceProyectos;
import com.example.ssis_tracker.model.Proyecto;
import com.example.ssis_tracker.presenter.proyectos.ProyectosActivityPresenter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProyectosActivityRepositoryImpl implements ProyectosActivityRepository {
    private ProyectosActivityPresenter proyectosActivityPresenter;
    private ApiAdapterProyectos adapterProyectos;
    private ApiServiceProyectos serviceProyectos;
    private String strNotData = "No se detectaron datos.";

    public ProyectosActivityRepositoryImpl(ProyectosActivityPresenter proyectosActivityPresenter) {
        this.proyectosActivityPresenter = proyectosActivityPresenter;
        adapterProyectos = new ApiAdapterProyectos();
        serviceProyectos = adapterProyectos.getClientService();
    }

    @Override
    public void getProyectos(int direccion) {
        Call<ArrayList<Proyecto>> call = serviceProyectos.getProyectos(direccion);
        call.enqueue(new Callback<ArrayList<Proyecto>>() {
            @Override
            public void onResponse(Call<ArrayList<Proyecto>> call, Response<ArrayList<Proyecto>> response) {
                if(response.isSuccessful() && !response.body().isEmpty()){
                    proyectosActivityPresenter.showProyectos(response.body());
                }else{
                    proyectosActivityPresenter.showMessage(strNotData);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Proyecto>> call, Throwable t) {
                proyectosActivityPresenter.showMessage(t.getMessage());
            }
        });
    }
}
