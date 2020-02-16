package com.example.ssis_tracker.repository.agregarcomentarios;

import android.support.design.widget.Snackbar;
import android.view.View;
import com.example.ssis_tracker.api.actividades.ApiAdapterActividades;
import com.example.ssis_tracker.api.actividades.ApiServiceActividades;
import com.example.ssis_tracker.presenter.agregarcomentarios.ActivityComentarPresenter;
import com.google.gson.JsonArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityComentarRepositoryImpl implements ActivityComentarRepository {

    private ActivityComentarPresenter activityComentarPresenter;
    private ApiServiceActividades apiServiceActividades;
    private View view;

    public ActivityComentarRepositoryImpl(ActivityComentarPresenter activityComentarPresenter , View view){
        this.activityComentarPresenter = activityComentarPresenter;
        this.apiServiceActividades = new ApiAdapterActividades().getClientService();
        this.view = view;
    }

    @Override
    public void AgregarComentario(JsonArray jsonComentario) {
        Call<Integer>  Call = this.apiServiceActividades.agregarComentarios(jsonComentario);
        Call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(retrofit2.Call<Integer> call, Response<Integer> response) {
             //   activityComentarPresenter.ComentarioAgregado(response.body());
                activityComentarPresenter.ComentarioAgregado(1);
            }

            @Override
            public void onFailure(retrofit2.Call<Integer> call, Throwable t) {
                Snackbar.make(view,"Error al registrar el comentario",Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
