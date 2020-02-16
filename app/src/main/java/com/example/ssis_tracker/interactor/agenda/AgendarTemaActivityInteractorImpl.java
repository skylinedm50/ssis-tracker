package com.example.ssis_tracker.interactor.agenda;

import com.example.ssis_tracker.presenter.agenda.AgendarTemaActivityPresenter;
import com.example.ssis_tracker.repository.agenda.AgendarTemaActivityRepository;
import com.example.ssis_tracker.repository.agenda.AgendarTemaActivityRepositoryImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AgendarTemaActivityInteractorImpl implements AgendarTemaActitvityInteractor {

    private AgendarTemaActivityRepository agendarTemaActivityRepository;

    public AgendarTemaActivityInteractorImpl(AgendarTemaActivityPresenter agendarTemaActivityPresenter){
        agendarTemaActivityRepository = new AgendarTemaActivityRepositoryImpl(agendarTemaActivityPresenter);
    }

    @Override
    public void AgendarTema(String tema, int usuario , String Comentario) {

        JsonObject TemaAgendar = new JsonObject();
        TemaAgendar.addProperty("Tema"       ,tema);
        TemaAgendar.addProperty("Usuario"    ,String.valueOf(usuario));
        TemaAgendar.addProperty("Comentario" ,Comentario);

        JsonArray JsonTemaAgendar = new JsonArray();
        JsonTemaAgendar.add(TemaAgendar);
        this.agendarTemaActivityRepository.AgendarTema(JsonTemaAgendar);
    }
}
