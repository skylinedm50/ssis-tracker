package com.example.ssis_tracker.interactor.login;

import com.example.ssis_tracker.presenter.login.LoginActivityPresenter;
import com.example.ssis_tracker.repository.login.LoginActivityRepository;
import com.example.ssis_tracker.repository.login.LoginActivityRepositoryImpl;

public class LoginActivityInteractorImpl implements LoginActivityInteractor {

    private LoginActivityPresenter loginActivityPresenter;
    private LoginActivityRepository loginActivityRepository;

    public LoginActivityInteractorImpl(LoginActivityPresenter loginActivityPresenter){
        this.loginActivityPresenter = loginActivityPresenter;
        this.loginActivityRepository = new LoginActivityRepositoryImpl(this.loginActivityPresenter);
    }

    @Override
    public void LogInUsuario(String Usuario, String Pasword, String IpAddress, double Lat, double Long) {
        this.loginActivityRepository.LogInUsuario(Usuario , Pasword , IpAddress , Lat , Long);
    }

}
