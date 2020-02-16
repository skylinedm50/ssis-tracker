package com.example.ssis_tracker.interactor.actividades;

public interface ActividadesActivityInteractor {
    void getActividades(int proceso);
    void getComentarios(int processo);
    void getImagenes(int actividad);
}
