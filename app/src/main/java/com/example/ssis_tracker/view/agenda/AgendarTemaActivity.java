package com.example.ssis_tracker.view.agenda;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.presenter.agenda.AgendarTemaActivityPresenter;
import com.example.ssis_tracker.presenter.agenda.AgendarTemaActivityPresenterImpl;

public class AgendarTemaActivity extends AppCompatActivity implements AgendarTemaActivityView {

    private AgendarTemaActivityPresenter agendarTemaActivityPresenter;
    private TextView Tema;
    private TextView Comentario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        agendarTemaActivityPresenter = new AgendarTemaActivityPresenterImpl(this);
        setContentView(R.layout.activity_agendar_tema);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.Tema = findViewById(R.id.EditTextTemaAgendar);
        this.Comentario = findViewById(R.id.EditTextComentario);
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
                AgendarTema(Tema.getText().toString() , 1 , Comentario.getText().toString());
                return false;
            default:
                return true;
        }
    }

    @Override
    public void AgendarTema(String tema, int usuario , String Comentario) {
        agendarTemaActivityPresenter.AgendarTema(tema,usuario,Comentario);
    }

    @Override
    public void TemaRegistrado(boolean registrado) {
        if(registrado){
            onBackPressed();
        }else{
            Snackbar.make(findViewById(R.id.linearLayoutAgendarTema),"Error al agendar el tema",Snackbar.LENGTH_LONG).show();
        }
    }
}
