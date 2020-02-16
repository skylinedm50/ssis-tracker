package com.example.ssis_tracker.model;

public class Login
{
    private int CodigoUsuario;
    private String NombreUsuario;
    private int Rol;

    public int getCodigoUsuario() {
        return CodigoUsuario;
    }
    public void setCodigoUsuario(int codigoUsuario) {
        CodigoUsuario = codigoUsuario;
    }
    public String getNombreUsuario() {
        return NombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }
    public int getRol() {
        return Rol;
    }
    public void setRol(int rol) {
        Rol = rol;
    }

}
