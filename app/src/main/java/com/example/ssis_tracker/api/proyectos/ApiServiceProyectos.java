package com.example.ssis_tracker.api.proyectos;

import com.example.ssis_tracker.model.Meta;
import com.example.ssis_tracker.model.Proyecto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceProyectos {
    @GET("proyectos/get/{direccion}")
    Call<ArrayList<Proyecto>> getProyectos(@Path("direccion") int direccion);

    @GET("metas/proyecto/{proyecto}")
    Call<ArrayList<Meta>> getMetas(@Path("proyecto") int proyecto);
}
