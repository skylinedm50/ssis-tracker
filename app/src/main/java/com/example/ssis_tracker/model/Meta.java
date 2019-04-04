package com.example.ssis_tracker.model;

import com.google.gson.annotations.SerializedName;

public class Meta {
    private String actividad;
    private String unidad;
    private int programado;
    @SerializedName("porcentaje_ejecutado")
    private int porcentajeEjecutado;

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getProgramado() {
        return programado;
    }

    public void setProgramado(int programado) {
        this.programado = programado;
    }

    public int getPorcentajeEjecutado() {
        return porcentajeEjecutado;
    }

    public void setPorcentajeEjecutado(int porcentajeEjecutado) {
        this.porcentajeEjecutado = porcentajeEjecutado;
    }
}
