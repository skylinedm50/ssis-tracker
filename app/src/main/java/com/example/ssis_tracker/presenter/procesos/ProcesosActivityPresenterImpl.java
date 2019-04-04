package com.example.ssis_tracker.presenter.procesos;

import com.example.ssis_tracker.interactor.procesos.ProcesosActivityInteractor;
import com.example.ssis_tracker.interactor.procesos.ProcesosActivityInteractorImpl;
import com.example.ssis_tracker.model.Proceso;
import com.example.ssis_tracker.view.procesos.ProcesosActivityView;

import java.util.ArrayList;

public class ProcesosActivityPresenterImpl implements ProcesosActivityPresenter {
    private ProcesosActivityView procesosActivityView;
    private ProcesosActivityInteractor procesosActivityInteractor;


    public ProcesosActivityPresenterImpl(ProcesosActivityView procesosActivityView) {
        this.procesosActivityView = procesosActivityView;
        procesosActivityInteractor = new ProcesosActivityInteractorImpl(this);
    }

    @Override
    public void getProcesos(int proyecto) {
        procesosActivityInteractor.getProcesos(proyecto);
    }

    @Override
    public void showProcesos(ArrayList<Proceso> procesoArrayList) {
        procesosActivityView.showProcesos(procesoArrayList);
    }

    @Override
    public void showMessage(String strMessage) {
        procesosActivityView.showMessage(strMessage);
    }
}
