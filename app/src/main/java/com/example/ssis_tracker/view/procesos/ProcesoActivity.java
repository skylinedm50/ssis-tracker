package com.example.ssis_tracker.view.procesos;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.procesos.adapter_procesos;
import com.example.ssis_tracker.model.Proceso;
import com.example.ssis_tracker.view.actividades.ActividadesActivity;

import java.util.ArrayList;

public class ProcesoActivity extends AppCompatActivity {
    private RecyclerView rvProyectos;
    private ArrayList<Proceso> arrayProcesos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso);
        rvProyectos = findViewById(R.id.rvProyectos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        arrayProcesos = new ArrayList<>();
        arrayProcesos.add(new Proceso("Traslado de mochilas a la SSIS", "Traer los bolsones desde el almacén hasta la SSIS."));
        arrayProcesos.add(new Proceso("Proceso 2", "Descripcion 2"));
        arrayProcesos.add(new Proceso("Proceso 3", "Descripcion 3"));
        arrayProcesos.add(new Proceso("Proceso 4", "Descripcion 4"));
        arrayProcesos.add(new Proceso("Proceso 5", "Descripcion 5"));
        arrayProcesos.add(new Proceso("Proceso 6", "Descripcion 6"));
        arrayProcesos.add(new Proceso("Proceso 7", "Descripcion 7"));

        adapter_procesos adapterRecyclerProcess = new adapter_procesos(arrayProcesos,getApplicationContext());

        rvProyectos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvProyectos.setAdapter(adapterRecyclerProcess);

        Drawable drawable = getResources().getDrawable(R.drawable.drw_acronym);
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setColor(Color.RED);

        adapterRecyclerProcess.setOnClickListener(new adapter_procesos.OnItemClickListener() {
            @Override
            public void onitemClick(int position) {

            }
        });
    }
}
