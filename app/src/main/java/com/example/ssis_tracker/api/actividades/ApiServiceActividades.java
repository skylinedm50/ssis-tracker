package com.example.ssis_tracker.api.actividades;

import com.example.ssis_tracker.model.Actividad;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceActividades {
    @GET("actividades/get/{proceso}")
    Call<ArrayList<Actividad>> getActividades(@Path("proceso") int proceso);
}
