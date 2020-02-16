package com.example.ssis_tracker.model;


public class Agenda {
    private int idAgenda;
    private String Titulo;
    private String FechaAgregada;

    public Agenda(String Titulo, String FechaAgenda , int IdAgenda){
        this.Titulo        = Titulo;
        this.FechaAgregada = FechaAgenda;
        this.idAgenda      = IdAgenda;
    }

    public int getId_agenda() {
        return idAgenda;
    }

    public void setidAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getFecha_Agregada() {
        return FechaAgregada;
    }

    public void setFechaAgregada(String FechaAgregada) {
        FechaAgregada = FechaAgregada;
    }
}
