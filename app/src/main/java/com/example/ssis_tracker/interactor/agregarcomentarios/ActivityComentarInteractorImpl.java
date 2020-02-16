package com.example.ssis_tracker.interactor.agregarcomentarios;

import android.view.View;

import com.example.ssis_tracker.presenter.agregarcomentarios.ActivityComentarPresenter;
import com.example.ssis_tracker.repository.agregarcomentarios.ActivityComentarRepository;
import com.example.ssis_tracker.repository.agregarcomentarios.ActivityComentarRepositoryImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ActivityComentarInteractorImpl implements ActivityComentarInteractor {

    private ActivityComentarRepository activityComentarRepository;

    public ActivityComentarInteractorImpl(ActivityComentarPresenter activityComentarPresenter , View view){
        this.activityComentarRepository = new ActivityComentarRepositoryImpl(activityComentarPresenter , view);
    }

    @Override
    public void AgregarComentario(String Usuario , String Comentario) {

        JsonObject JsonObjectComentario = new JsonObject();
        JsonObjectComentario.addProperty("Usuario" , Usuario);
        JsonObjectComentario.addProperty("Comentario" , Comentario);

        JsonArray JsonComentario = new JsonArray();
        JsonComentario.add(JsonObjectComentario);
        this.activityComentarRepository.AgregarComentario(JsonComentario);
    }
}
