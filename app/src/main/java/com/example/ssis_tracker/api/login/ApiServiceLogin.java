package com.example.ssis_tracker.api.login;

import com.example.ssis_tracker.model.Login;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceLogin {

    @GET("login/get")
    Call<ArrayList<Login>> getLogin();
}
