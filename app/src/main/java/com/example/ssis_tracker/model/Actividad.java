package com.example.ssis_tracker.model;

import com.google.gson.annotations.SerializedName;

public class Actividad {

    private int id;
    private String nombre;
    private String descripcion;
    private String estado;
    private String color;
    private String direccion;
    private String siglas;
    private String responsable;
    @SerializedName("fecha_inicio_prevista")
    private String fechaInicioPrevista;
    @SerializedName("fecha_fin_prevista")
    private String fechaFinPrevista;
    @SerializedName("dias_habiles_previstos")
    private int diasHabilesPrevistos;
    @SerializedName("fecha_inicio_real")
    private String fechaInicioReal;
    @SerializedName("fecha_fin_real")
    private String fechaFinReal;
    @SerializedName("dias_habiles_reales")
    private int diasHabilesReales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFechaInicioPrevista() {
        return fechaInicioPrevista;
    }

    public void setFechaInicioPrevista(String fechaInicioPrevista) {
        this.fechaInicioPrevista = fechaInicioPrevista;
    }

    public String getFechaFinPrevista() {
        return fechaFinPrevista;
    }

    public void setFechaFinPrevista(String fechaFinPrevista) {
        this.fechaFinPrevista = fechaFinPrevista;
    }

    public int getDiasHabilesPrevistos() {
        return diasHabilesPrevistos;
    }

    public void setDiasHabilesPrevistos(int diasHabilesPrevistos) {
        this.diasHabilesPrevistos = diasHabilesPrevistos;
    }

    public String getFechaInicioReal() {
        return fechaInicioReal;
    }

    public void setFechaInicioReal(String fechaInicioReal) {
        this.fechaInicioReal = fechaInicioReal;
    }

    public String getFechaFinReal() {
        return fechaFinReal;
    }

    public void setFechaFinReal(String fechaFinReal) {
        this.fechaFinReal = fechaFinReal;
    }

    public int getDiasHabilesReales() {
        return diasHabilesReales;
    }

    public void setDiasHabilesReales(int diasHabilesReales) {
        this.diasHabilesReales = diasHabilesReales;
    }
}
