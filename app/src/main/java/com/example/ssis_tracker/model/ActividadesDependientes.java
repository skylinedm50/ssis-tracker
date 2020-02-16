package com.example.ssis_tracker.model;

import com.google.gson.annotations.SerializedName;

public class ActividadesDependientes {

    private String Actividad;
    private String Unidad;
    private String Proceso;
    private int procentajeRealizado;

    public String getActividad() {
        return Actividad;
    }
    public void setActividad(String actividad) {
        Actividad = actividad;
    }
    public String getUnidad() {
        return Unidad;
    }
    public void setUnidad(String unidad) {
        Unidad = unidad;
    }
    public int getProcentajeRealizado() {
        return procentajeRealizado;
    }
    public void setProcentajeRealizado(int procentajeRealizado) {
        this.procentajeRealizado = procentajeRealizado;
    }
    public String getProceso() {
        return Proceso;
    }
    public void setProceso(String proceso) {
        Proceso = proceso;
    }

}
