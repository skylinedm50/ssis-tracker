package com.example.ssis_tracker.view.procesos;

import com.example.ssis_tracker.model.Proceso;

import java.util.ArrayList;

public interface ProcesosActivityView {
    void getProcesos(int proyecto);
    void showProcesos(ArrayList<Proceso> procesoArrayList);
    void showMessage(String strMessage);
    void showSwipeRefreshLayout(boolean bool);
}
