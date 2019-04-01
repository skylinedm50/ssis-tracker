package com.example.ssis_tracker.interactor.proyectos;

import com.example.ssis_tracker.presenter.proyectos.ProyectosActivityPresenter;
import com.example.ssis_tracker.repository.proyectos.ProyectosActivityRepository;
import com.example.ssis_tracker.repository.proyectos.ProyectosActivityRepositoryImpl;

public class ProyectosActivityInteractorImpl implements ProyectosActivityInteractor {
    private ProyectosActivityRepository proyectosActivityRepository;

    public ProyectosActivityInteractorImpl(ProyectosActivityPresenter proyectosActivityPresenter){
        proyectosActivityRepository = new ProyectosActivityRepositoryImpl(proyectosActivityPresenter);
    }

    @Override
    public void getProyectos(int direccion) {
        proyectosActivityRepository.getProyectos(direccion);
    }
}
