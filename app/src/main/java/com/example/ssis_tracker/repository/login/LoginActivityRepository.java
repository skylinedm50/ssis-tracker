package com.example.ssis_tracker.repository.login;

public interface LoginActivityRepository {

    void LogInUsuario(String Usuario , String Pasword , String IpAddress , double Lat , double Long);

}
