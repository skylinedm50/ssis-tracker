package com.example.ssis_tracker.view.actividades;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.actividades.AdapterComentarios;
import com.example.ssis_tracker.adapter.actividades.AdapterImagenesDocs;


public class ActividadesFragment extends Fragment {

    public static ActividadesFragment NuevaInstancia(int position, int size){

        ActividadesFragment actividadesFragment = new ActividadesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        bundle.putInt("size"    ,size);
        actividadesFragment.setArguments(bundle);
        return actividadesFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentActividad   = inflater.inflate(R.layout.fragment_actividades , container , false);
        TextView txt_position    = fragmentActividad.findViewById(R.id.txt_posicion);
        TextView TxtDireccion    = fragmentActividad.findViewById(R.id.txt_direccion);

        RecyclerView rvComentarios = fragmentActividad.findViewById(R.id.rvComentarios);
        RecyclerView RecyclerViewImagenes = fragmentActividad.findViewById(R.id.RecyclerViewImagenes);

        AdapterComentarios adapterComentarios = new AdapterComentarios();
        AdapterImagenesDocs adapterImagenes = new AdapterImagenesDocs(this.getContext());

        LinearLayoutManager linearLayoutManagerComentarios = new LinearLayoutManager(this.getContext());
        LinearLayoutManager linearLayoutManagerImagenes = new LinearLayoutManager(this.getContext());
        linearLayoutManagerImagenes.setOrientation(LinearLayoutManager.HORIZONTAL);

        rvComentarios.setLayoutManager(linearLayoutManagerComentarios);
        rvComentarios.setAdapter(adapterComentarios);

        RecyclerViewImagenes.setAdapter(adapterImagenes);
        RecyclerViewImagenes.setLayoutManager(linearLayoutManagerImagenes);

        txt_position.setText( String.valueOf( getArguments().getInt("position") + 1 )+"/"+String.valueOf(getArguments().getInt("size")) );

        return fragmentActividad;
    }



}
