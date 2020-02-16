package com.example.ssis_tracker.api.actividades;

import com.example.ssis_tracker.model.Actividad;
import com.example.ssis_tracker.model.ActividadesDependientes;
import com.example.ssis_tracker.model.Comentario;
import com.example.ssis_tracker.model.Meta;
import com.google.gson.JsonArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServiceActividades {
    @GET("actividades/get/{proceso}")
    Call<ArrayList<Actividad>> getActividades(@Path("proceso") int proceso);

    @GET("actividades/comentarios/get/{actividad}")
    Call<ArrayList<Comentario>> getComentarios(@Path("actividad") int actividad);

    @GET("actividades/imagenes/get/{actividad}")
    Call<ArrayList<String>> getImagenes(@Path("actividad") int actividad);

    @GET("metas/actividad/{actividad}")
    Call<ArrayList<Meta>> getMetas(@Path("actividad") int actividad);

    @GET("metas/dependientes/{actividad}")
    Call<ArrayList<ActividadesDependientes>> getActividadeDependientes(@Path("actividad") int actividad);

    @POST("actividades/comentarios/nuevo")
    Call<Integer> agregarComentarios(@Body JsonArray comentario);

}
