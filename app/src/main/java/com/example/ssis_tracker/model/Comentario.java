package com.example.ssis_tracker.model;

public class Comentario {

    private String NombreUsuario;
    private String FechaComentario;
    private String Comentario;

    public String getNombreUsuario() {
        return NombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }
    public String getFechaComentario() {
        return FechaComentario;
    }
    public void setFechaComentario(String fechaComentario) {
        FechaComentario = fechaComentario;
    }
    public String getComentario() {
        return Comentario;
    }
    public void setComentario(String comentario) {
        Comentario = comentario;
    }


}
