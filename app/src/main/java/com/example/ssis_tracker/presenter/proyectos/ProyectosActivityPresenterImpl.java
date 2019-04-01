package com.example.ssis_tracker.presenter.proyectos;

import com.example.ssis_tracker.interactor.proyectos.ProyectosActivityInteractor;
import com.example.ssis_tracker.interactor.proyectos.ProyectosActivityInteractorImpl;
import com.example.ssis_tracker.model.Proyecto;
import com.example.ssis_tracker.view.proyectos.ProyectosActivityView;

import java.util.ArrayList;

public class ProyectosActivityPresenterImpl implements ProyectosActivityPresenter {
    private ProyectosActivityView proyectosActivityView;
    private ProyectosActivityInteractor proyectosActivityInteractor;

    public ProyectosActivityPresenterImpl(ProyectosActivityView proyectosActivityView){
        this.proyectosActivityView = proyectosActivityView;
        proyectosActivityInteractor = new ProyectosActivityInteractorImpl(this);
    }

    @Override
    public void getProyectos(int direccion) {
        proyectosActivityInteractor.getProyectos(direccion);
    }

    @Override
    public void showProyectos(ArrayList<Proyecto> proyectoArrayList) {
        proyectosActivityView.showProyectos(proyectoArrayList);
    }

    @Override
    public void showMessage(String strMessage) {
        proyectosActivityView.showMessage(strMessage);
    }
}
