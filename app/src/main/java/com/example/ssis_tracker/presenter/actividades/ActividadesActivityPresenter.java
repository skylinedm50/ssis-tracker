package com.example.ssis_tracker.presenter.actividades;

import com.example.ssis_tracker.model.Actividad;

import java.util.ArrayList;

public interface ActividadesActivityPresenter {
    void getActividades(int proceso);
    void showActividades(ArrayList<Actividad> actividadArrayList);
    void showMessage(String strMessage);
}
