package com.example.ssis_tracker.view.actividades;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.actividades.AdapterComentarios;
import com.example.ssis_tracker.adapter.actividades.AdapterImagenesDocs;
import com.example.ssis_tracker.model.Actividad;

public class ActividadesFragment extends Fragment {
    public Actividad actividad;
    public String posicion;

    public ActividadesFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actividades , container , false);

        TextView textViewNombreActividad = view.findViewById(R.id.textViewNombreActividad);
        TextView textViewDescripcionActividad = view.findViewById(R.id.textViewDescripcionActividad);
        View viewEstadoColor = view.findViewById(R.id.viewEstadoColor);
        TextView textViewEstado = view.findViewById(R.id.textViewEstado);
        TextView textViewPosicion = view.findViewById(R.id.textViewPosicion);
        TextView textViewDireccion = view.findViewById(R.id.textViewDireccion);
        TextView textViewSiglas = view.findViewById(R.id.textViewSiglas);
        TextView textViewResponsable = view.findViewById(R.id.textViewResponsable);
        TextView textViewFechaInicioPrevista = view.findViewById(R.id.textViewFechaInicioPrevista);
        TextView textViewFechaFinPrevista = view.findViewById(R.id.textViewFechaFinPrevista);
        TextView textViewDiasHabilesPrevistos = view.findViewById(R.id.textViewDiasHabilesPrevistos);
        TextView textViewFechaInicioReal = view.findViewById(R.id.textViewFechaInicioReal);
        TextView textViewFechaFinReal = view.findViewById(R.id.textViewFechaFinReal);
        TextView textViewDiasHabilesReales = view.findViewById(R.id.textViewDiasHabilesReales);
        LinearLayout linearLayoutMetas = view.findViewById(R.id.linearLayoutMetas);
        LinearLayout linearLayoutDependencia = view.findViewById(R.id.linearLayoutDependencia);

        textViewNombreActividad.setText(actividad.getNombre());
        textViewDescripcionActividad.setText(actividad.getDescripcion());

        Drawable drawable = viewEstadoColor.getBackground();
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setColor(Color.parseColor(actividad.getColor()));

        textViewEstado.setText(actividad.getEstado());
        textViewPosicion.setText(posicion);
        textViewDireccion.setText(actividad.getDireccion());
        textViewSiglas.setText(actividad.getSiglas());
        textViewResponsable.setText(actividad.getResponsable());
        textViewFechaInicioPrevista.setText(actividad.getFechaInicioPrevista());
        textViewFechaFinPrevista.setText(actividad.getFechaFinPrevista());
        textViewDiasHabilesPrevistos.setText(String.valueOf(actividad.getDiasHabilesPrevistos()));
        textViewFechaInicioReal.setText(actividad.getFechaInicioReal());
        textViewFechaFinReal.setText(actividad.getFechaFinReal());
        textViewDiasHabilesReales.setText(String.valueOf(actividad.getDiasHabilesReales()));

        linearLayoutMetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }
        });

        linearLayoutDependencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }
        });

        RecyclerView rvComentarios = view.findViewById(R.id.recyclerViewComentarios);
        RecyclerView RecyclerViewImagenes = view.findViewById(R.id.recyclerViewImagenes);

        AdapterComentarios adapterComentarios = new AdapterComentarios();
        AdapterImagenesDocs adapterImagenes = new AdapterImagenesDocs(this.getContext());

        LinearLayoutManager linearLayoutManagerComentarios = new LinearLayoutManager(this.getContext());
        LinearLayoutManager linearLayoutManagerImagenes = new LinearLayoutManager(this.getContext());
        linearLayoutManagerImagenes.setOrientation(LinearLayoutManager.HORIZONTAL);

        rvComentarios.setLayoutManager(linearLayoutManagerComentarios);
        rvComentarios.setAdapter(adapterComentarios);

        RecyclerViewImagenes.setAdapter(adapterImagenes);
        RecyclerViewImagenes.setLayoutManager(linearLayoutManagerImagenes);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
