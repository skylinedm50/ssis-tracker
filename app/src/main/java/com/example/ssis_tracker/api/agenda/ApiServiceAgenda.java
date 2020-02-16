package com.example.ssis_tracker.api.agenda;

import com.example.ssis_tracker.model.Agenda;
import com.google.gson.JsonArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServiceAgenda {

    @POST("aganda/crear")
    Call<ArrayList<Agenda>> AgendarNuevoTema(@Body JsonArray tema);

    @GET("agenda/listar")
    Call<ArrayList<Agenda>> ListarTemaAgenda();

    @POST("agenda/eliminar")
    Call<ArrayList<Agenda>> EliminarTemaAgenda(@Body int temaId);
}
