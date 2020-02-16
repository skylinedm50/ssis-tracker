package com.example.ssis_tracker.view.agregarcomentarios;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.presenter.agregarcomentarios.ActivityComentarPresenter;
import com.example.ssis_tracker.presenter.agregarcomentarios.ActivityComentarPresenterImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActivityComentar extends AppCompatActivity implements ActivityComentarView {

    private EditText EditTextUsuario;
    private EditText EditTextFechaIngreso;
    private EditText EditTextComentario;
    private ActivityComentarPresenter activityComentarPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentar);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.EditTextUsuario = findViewById(R.id.EditTextUsuario);
        this.EditTextFechaIngreso = findViewById(R.id.EditTextFechaIngreso);
        this.EditTextComentario = findViewById(R.id.EditTextComentario);
        this.activityComentarPresenter = new ActivityComentarPresenterImpl(this, findViewById(R.id.coordinatorLayoutComentar));
        this.EditTextFechaIngreso.setText(date);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.agendar_tema, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.guardarTema:
                AgregarComentario();
                return false;
            default:
                return true;
        }
    }

    @Override
    public void AgregarComentario() {
        if(  EditTextComentario.getText().toString().trim().length() > 0 ){
            this.activityComentarPresenter.AgregarComentario("codigo_usuario" , EditTextComentario.getText().toString().trim());
        }else{
            Snackbar.make(findViewById(R.id.coordinatorLayoutComentar),"Se tiene que escribir un comentario",Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void ComentarioAgregado(int Repuesta) {
        if(Repuesta == 1){
            onBackPressed();
        }else{
            Snackbar.make(findViewById(R.id.coordinatorLayoutComentar),"Error al registrar el comentario",Snackbar.LENGTH_LONG).show();
        }
    }
}
