package com.example.ssis_tracker.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Proyecto {
    private int id;
    private String nombre;
    private String descripcion;
    private String estado;
    private String color;
    private String fechas;
    @SerializedName("porcentaje_procesos")
    private int porcentajeProcesos;
    @SerializedName("porcentaje_dias")
    private int porcentajeDias;
    @SerializedName("porcentaje_metas")
    private  int porcentajeMetas;

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

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public int getPorcentajeProcesos() {
        return porcentajeProcesos;
    }

    public void setPorcentajeProcesos(int porcentajeProcesos) {
        this.porcentajeProcesos = porcentajeProcesos;
    }

    public int getPorcentajeDias() {
        return porcentajeDias;
    }

    public void setPorcentajeDias(int porcentajeDias) {
        this.porcentajeDias = porcentajeDias;
    }

    public int getPorcentajeMetas() {
        return porcentajeMetas;
    }

    public void setPorcentajeMetas(int porcentajeMetas) {
        this.porcentajeMetas = porcentajeMetas;
    }
}
