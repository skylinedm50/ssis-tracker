package com.example.ssis_tracker.repository.agenda;

import com.example.ssis_tracker.api.agenda.ApiAdapterAgenda;
import com.example.ssis_tracker.api.agenda.ApiServiceAgenda;
import com.example.ssis_tracker.model.Agenda;
import com.example.ssis_tracker.presenter.agenda.AgendarTemaActivityPresenter;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgendarTemaActivityRepositoryImpl implements AgendarTemaActivityRepository {


    private AgendarTemaActivityPresenter agendarTemaActivityPresenter;
    private ApiServiceAgenda servicesAgenda;

    public AgendarTemaActivityRepositoryImpl(AgendarTemaActivityPresenter agendarTemaActivityPresenter){
        this.agendarTemaActivityPresenter = agendarTemaActivityPresenter;
        this.servicesAgenda = new ApiAdapterAgenda().getClientService();
    }

    @Override
    public void AgendarTema(JsonArray tema) {

        Call<ArrayList<Agenda>> call = this.servicesAgenda.AgendarNuevoTema(tema);
        call.enqueue(new Callback<ArrayList<Agenda>>() {
            @Override
            public void onResponse(Call<ArrayList<Agenda>> call, Response<ArrayList<Agenda>> response) {
                agendarTemaActivityPresenter.TemaRegistrado(true);
            }

            @Override
            public void onFailure(Call<ArrayList<Agenda>> call, Throwable t) {
                agendarTemaActivityPresenter.TemaRegistrado(false);
            }
        });
    }
}
