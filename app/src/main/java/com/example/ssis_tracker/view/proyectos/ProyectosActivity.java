package com.example.ssis_tracker.view.proyectos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.proyectos.adapter_proyectos;


public class ProyectosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos);

        RecyclerView rvProyectos = findViewById(R.id.rvProyectos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        adapter_proyectos adapter_proyectos = new adapter_proyectos(getApplicationContext());

        rvProyectos.setLayoutManager(linearLayoutManager);
        rvProyectos.setAdapter(adapter_proyectos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
