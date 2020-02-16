package com.example.ssis_tracker.view.actividades;

import com.example.ssis_tracker.model.Comentario;

import java.util.ArrayList;

public interface ActividadesFragmentView {

    void getComentarios(int actividad);
    void showComentarios(ArrayList<Comentario> comentarios);
    void getImagenes(int actividad);
    void showImagenes(ArrayList<String> imagenes);
}
