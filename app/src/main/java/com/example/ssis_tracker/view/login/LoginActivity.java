package com.example.ssis_tracker.view.login;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;

import com.example.ssis_tracker.R;
import com.example.ssis_tracker.elements.Permissions;
import com.example.ssis_tracker.model.Login;
import com.example.ssis_tracker.presenter.login.LoginActivityPresenter;
import com.example.ssis_tracker.presenter.login.LoginActivityPresenterImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity implements LoginActivityView {

    private Button buttonLoging;
    private TextInputEditText TextInputEditTextUser;
    private TextInputEditText TextInputEditTextPassword;
    private LoginActivityPresenter loginActivityPresenter;
    private double latitud;
    private double longitud;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.buttonLoging = findViewById(R.id.ButtonLogin);
        this.TextInputEditTextUser = findViewById(R.id.TextInputEditTextUser);
        this.TextInputEditTextPassword = findViewById(R.id.TextInputEditTextPassword);
        this.loginActivityPresenter = new LoginActivityPresenterImpl(this);

        this.buttonLoging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Permissions permissions = new Permissions(getApplicationContext(), LoginActivity.this);
                boolean granted = permissions.LocationPermissionsGranted();
                if (granted) {
                    LogInUsuario();
                }
            }
        });
    }

    @Override
    public void LogInUsuario() {
        SolicitarPosicionGeografia();
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService( getApplicationContext().WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        this.loginActivityPresenter.LogInUsuario(TextInputEditTextUser.getText().toString(), TextInputEditTextPassword.getText().toString(), ip , latitud , longitud);
    }

    @Override
    public void UsuarioLogeado(ArrayList<Login> login) {

    }

    @Override
    public void ShowErrosMsj(String Msj) {
        Snackbar.make(this.TextInputEditTextUser , Msj , Snackbar.LENGTH_LONG).show();
    }

    public  void SolicitarPosicionGeografia(){

        LocationManager locationManager = (LocationManager) getApplicationContext().getSystemService(getApplicationContext().LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
        latitud  = location.getLatitude();
        longitud = location.getLongitude();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 5: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    LogInUsuario();
                }else {
                    Snackbar.make(this.TextInputEditTextUser , "La aplicación necesita tener acceso a la ubicación geografica" , Snackbar.LENGTH_LONG).show();
                }
            }
        }
    }
}
