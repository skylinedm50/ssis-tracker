package com.example.ssis_tracker.presenter.procesos;

import com.example.ssis_tracker.model.Proceso;

import java.util.ArrayList;

public interface ProcesosActivityPresenter {
    void getProcesos(int proyecto);
    void showProcesos(ArrayList<Proceso> procesoArrayList);
    void showMessage(String strMessage);
}
