package com.example.ssis_tracker.presenter.actividades;

import com.example.ssis_tracker.model.Actividad;
import com.example.ssis_tracker.model.Comentario;
import java.util.ArrayList;


public interface ActividadesActivityPresenter {
    void getActividades(int proceso);
    void showActividades(ArrayList<Actividad> actividadArrayList);
    void showMessage(String strMessage);
    void getComentarios(int actividad);
    void showComentarios(ArrayList<Comentario> comentario);
    void getImagenes(int actividad);
    void showImagenes(ArrayList<String> imagenes);
}
