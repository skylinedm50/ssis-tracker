package com.example.ssis_tracker.model;

public class Proceso {
    private int idProyecto;
    private String Nombre_Proyecto;
    private String Descripcion;
    private int idEstado;

    public Proceso(String Nombre_Proyecto, String Descripcion){
        this.Nombre_Proyecto = Nombre_Proyecto;
        this.Descripcion = Descripcion;
    }
    public Proceso(){}

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre_Proyecto() {
        return Nombre_Proyecto;
    }

    public void setNombre_Proyecto(String nombre_Proyecto) {
        Nombre_Proyecto = nombre_Proyecto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
}
