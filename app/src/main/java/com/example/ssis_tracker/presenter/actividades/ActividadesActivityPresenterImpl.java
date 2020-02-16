package com.example.ssis_tracker.presenter.actividades;

import com.example.ssis_tracker.interactor.actividades.ActividadesActivityInteractor;
import com.example.ssis_tracker.interactor.actividades.ActividadesActivityInteractorImpl;
import com.example.ssis_tracker.model.Actividad;
import com.example.ssis_tracker.model.Comentario;
import com.example.ssis_tracker.view.actividades.ActividadesActivityView;
import com.example.ssis_tracker.view.actividades.ActividadesFragmentView;
import java.util.ArrayList;

public class ActividadesActivityPresenterImpl implements ActividadesActivityPresenter{

    private ActividadesFragmentView actividadesFragmentView;
    private ActividadesActivityView actividadesActivityView;
    private ActividadesActivityInteractor actividadesActivityInteractor;

    public ActividadesActivityPresenterImpl(ActividadesActivityView actividadesActivityView , ActividadesFragmentView actividadesFragmentView) {
        this.actividadesActivityView  = actividadesActivityView;
        actividadesActivityInteractor = new ActividadesActivityInteractorImpl(this);
        this.actividadesFragmentView  = actividadesFragmentView;
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

    @Override
    public void getComentarios(int actividad) {
        actividadesActivityInteractor.getComentarios(actividad);
    }

    @Override
    public void showComentarios(ArrayList<Comentario> comentarios) {
        actividadesFragmentView.showComentarios(comentarios);
    }

    @Override
    public void getImagenes(int actividad) {
        actividadesActivityInteractor.getImagenes(actividad);
    }

    @Override
    public void showImagenes(ArrayList<String> imagenes) {
        actividadesFragmentView.showImagenes(imagenes);
    }
}
