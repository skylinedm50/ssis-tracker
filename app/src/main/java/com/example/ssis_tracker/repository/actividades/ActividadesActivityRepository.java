package com.example.ssis_tracker.repository.actividades;

public interface ActividadesActivityRepository {
    void getActividades(int proceso);
    void getComentarios(int actividad);
    void getImagenes(int actividad);
}
