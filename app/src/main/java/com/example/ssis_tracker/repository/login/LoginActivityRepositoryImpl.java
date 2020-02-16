package com.example.ssis_tracker.repository.login;

import com.example.ssis_tracker.api.login.ApiAdapterLogin;
import com.example.ssis_tracker.api.login.ApiServiceLogin;
import com.example.ssis_tracker.model.Login;
import com.example.ssis_tracker.presenter.login.LoginActivityPresenter;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivityRepositoryImpl implements LoginActivityRepository {

    private LoginActivityPresenter loginActivityPresenter;
    private ApiAdapterLogin apiAdapterLogin;
    private ApiServiceLogin apiServiceLogin;

    public  LoginActivityRepositoryImpl(LoginActivityPresenter loginActivityPresenter){
        this.loginActivityPresenter = loginActivityPresenter;
        this.apiAdapterLogin = new ApiAdapterLogin();
        this.apiServiceLogin = apiAdapterLogin.getClientService();
    }

    @Override
    public void LogInUsuario(String Usuario, String Pasword, String IpAddress, double Lat, double Long) {
        Call<ArrayList<Login>> call = this.apiServiceLogin.getLogin();
        call.enqueue(new Callback<ArrayList<Login>>() {
            @Override
            public void onResponse(Call<ArrayList<Login>> call, Response<ArrayList<Login>> response) {
                if(response.isSuccessful()){
                    loginActivityPresenter.UsuarioLogeado(response.body());
                }else{
                    loginActivityPresenter.ShowErrosMsj("Las credenciales son incorrectas");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Login>> call, Throwable t) {
                loginActivityPresenter.ShowErrosMsj(t.getMessage());
            }
        });
    }
}
