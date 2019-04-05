package com.example.ssis_tracker.presenter.actividades;

import com.example.ssis_tracker.interactor.actividades.ActividadesActivityInteractor;
import com.example.ssis_tracker.interactor.actividades.ActividadesActivityInteractorImpl;
import com.example.ssis_tracker.model.Actividad;
import com.example.ssis_tracker.view.actividades.ActividadesActivityView;

import java.util.ArrayList;

public class ActividadesActivityPresenterImpl implements ActividadesActivityPresenter{
    private ActividadesActivityView actividadesActivityView;
    private ActividadesActivityInteractor actividadesActivityInteractor;

    public ActividadesActivityPresenterImpl(ActividadesActivityView actividadesActivityView) {
        this.actividadesActivityView = actividadesActivityView;
        actividadesActivityInteractor = new ActividadesActivityInteractorImpl(this);
    }

    @Override
    public void getActividades(int proceso) {
        actividadesActivityInteractor.getActividades(proceso);
    }

    @Override
    public void showActividades(ArrayList<Actividad> actividadArrayList) {
        actividadesActivityView.showActividades(actividadArrayList);
    }

    @Override
    public void showMessage(String strMessage) {
        actividadesActivityView.showMessage(strMessage);
    }
}
