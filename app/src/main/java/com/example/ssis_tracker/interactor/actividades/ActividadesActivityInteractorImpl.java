package com.example.ssis_tracker.interactor.actividades;

import com.example.ssis_tracker.presenter.actividades.ActividadesActivityPresenter;
import com.example.ssis_tracker.repository.actividades.ActividadesActivityRepository;
import com.example.ssis_tracker.repository.actividades.ActividadesActivityRepositoryImpl;

public class ActividadesActivityInteractorImpl implements ActividadesActivityInteractor {
    private ActividadesActivityRepository actividadesActivityRepository;

    public ActividadesActivityInteractorImpl(ActividadesActivityPresenter actividadesActivityPresenter) {
        actividadesActivityRepository = new ActividadesActivityRepositoryImpl(actividadesActivityPresenter);
    }

    @Override
    public void getActividades(int proceso) {
        actividadesActivityRepository.getActividades(proceso);
    }
}
