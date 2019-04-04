package com.example.ssis_tracker.api.procesos;

import com.example.ssis_tracker.model.Meta;
import com.example.ssis_tracker.model.Proceso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceProcesos {
    @GET("procesos/get/{proyecto}")
    Call<ArrayList<Proceso>> getProcesos(@Path("proyecto") int proyecto);

    @GET("metas/proceso/{proceso}")
    Call<ArrayList<Meta>> getMetas(@Path("proceso") int proceso);
}
