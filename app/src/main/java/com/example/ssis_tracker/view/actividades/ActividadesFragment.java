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
import java.util.ArrayList;

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

        View fragmentActividad       = inflater.inflate(R.layout.fragment_actividades , container , false);
        ArrayList<String[]> arrayListActividades  = SolicitarDatosFragment();

        TextView TextViewActividades = fragmentActividad.findViewById(R.id.TextViewNombreActividad);
        TextView TextViewDescripcionActividades = fragmentActividad.findViewById(R.id.TextViewDescripcionActividad);
        View     viewEstadoColor     = fragmentActividad.findViewById(R.id.viewEstadoColor);
        TextView TextViewEstadoDescripcion = fragmentActividad.findViewById(R.id.TextViewEstadoDescripcion);
        TextView txt_position        = fragmentActividad.findViewById(R.id.txt_posicion);
        TextView TxtDireccion        = fragmentActividad.findViewById(R.id.TextViewDireccion);
        TextView TextViewSiglas      = fragmentActividad.findViewById(R.id.TextViewSiglas);
        TextView TextViewUsuarioResponsable = fragmentActividad.findViewById(R.id.TextViewUsuarioResponsable);
        TextView TextViewFechaInicioEstimada = fragmentActividad.findViewById(R.id.TextViewFechaInicioEstimada);
        TextView TextViewFechaFinEstimada = fragmentActividad.findViewById(R.id.TextViewFechaFinEstimada);
        TextView DiasHabilesDuracion = fragmentActividad.findViewById(R.id.DiasHabilesDuracion);
        TextView TextViewFechaInicioReal = fragmentActividad.findViewById(R.id.TextViewFechaInicioReal);
        TextView TextViewFechaFinReal = fragmentActividad.findViewById(R.id.TextViewFechaFinReal);
        TextView TextViewDiasHabilesReales = fragmentActividad.findViewById(R.id.TextViewDiasHabilesReales);
        LinearLayout LinearLayoutMetas = fragmentActividad.findViewById(R.id.LinearLayoutMetas);
        LinearLayout LinearLayoutDependencia = fragmentActividad.findViewById(R.id.LinearLayoutDependencia);

        TextViewActividades.setText(arrayListActividades.get(getArguments().getInt("position"))[0] );
        TextViewDescripcionActividades.setText(arrayListActividades.get(getArguments().getInt("position"))[1] );

        Drawable drawable = viewEstadoColor.getBackground();
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setColor(Color.parseColor( arrayListActividades.get(getArguments().getInt("position"))[2] ));

        TextViewEstadoDescripcion.setText(arrayListActividades.get(getArguments().getInt("position"))[3] );
        txt_position.setText( String.valueOf( getArguments().getInt("position") + 1 )+"/"+String.valueOf(getArguments().getInt("size")) );
        TxtDireccion.setText(arrayListActividades.get(getArguments().getInt("position"))[4] );
        TextViewSiglas.setText(arrayListActividades.get(getArguments().getInt("position"))[5] );
        TextViewUsuarioResponsable.setText(arrayListActividades.get(getArguments().getInt("position"))[6] );
        TextViewFechaInicioEstimada.setText(arrayListActividades.get(getArguments().getInt("position"))[7] );
        TextViewFechaFinEstimada.setText(arrayListActividades.get(getArguments().getInt("position"))[8] );
        DiasHabilesDuracion.setText(arrayListActividades.get(getArguments().getInt("position"))[9] );
        TextViewFechaInicioReal.setText(arrayListActividades.get(getArguments().getInt("position"))[10] );
        TextViewFechaFinReal.setText(arrayListActividades.get(getArguments().getInt("position"))[11] );
        TextViewDiasHabilesReales.setText(arrayListActividades.get(getArguments().getInt("position"))[12] );

        LinearLayoutMetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }
        });

        LinearLayoutDependencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }
        });

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

        return fragmentActividad;
    }

    private ArrayList<String[]> SolicitarDatosFragment(){
        ArrayList<String[]> arrayListActividades = new ArrayList<>();

        arrayListActividades.add(new String[]{"OBTENER CARRO PARA EL TRASLADO DE MOCHILAS","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "#2E9ADE" , "INICIADO","SISTEMA DE INFORMACIÓN GERENCIAL", "SIG", "USUARIO RESPONSABLE","FECHA INICIO ESTIMADA","FECHA FIN ESTIMADA", "DIAS HABILES DE DURACION",
            "FECHA INICIO REAL","FECHA FIN REAL","DIAS HABILES REALES",""
        });
        arrayListActividades.add(new String[]{"OBTENER CARRO PARA EL TRASLADO DE MOCHILAS","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "#2E9ADE" , "INICIADO","SISTEMA DE INFORMACIÓN GERENCIAL", "SIG", "USUARIO RESPONSABLE","FECHA INICIO ESTIMADA","FECHA FIN ESTIMADA", "DIAS HABILES DE DURACION",
                "FECHA INICIO REAL","FECHA FIN REAL","DIAS HABILES REALES",""
        });
        arrayListActividades.add(new String[]{"OBTENER CARRO PARA EL TRASLADO DE MOCHILAS","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "#2E9ADE" , "INICIADO","SISTEMA DE INFORMACIÓN GERENCIAL", "SIG", "USUARIO RESPONSABLE","FECHA INICIO ESTIMADA","FECHA FIN ESTIMADA", "DIAS HABILES DE DURACION",
                "FECHA INICIO REAL","FECHA FIN REAL","DIAS HABILES REALES",""
        });
        arrayListActividades.add(new String[]{"OBTENER CARRO PARA EL TRASLADO DE MOCHILAS","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "#2E9ADE" , "INICIADO","SISTEMA DE INFORMACIÓN GERENCIAL", "SIG", "USUARIO RESPONSABLE","FECHA INICIO ESTIMADA","FECHA FIN ESTIMADA", "DIAS HABILES DE DURACION",
                "FECHA INICIO REAL","FECHA FIN REAL","DIAS HABILES REALES",""
        });
        arrayListActividades.add(new String[]{"OBTENER CARRO PARA EL TRASLADO DE MOCHILAS","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "#2E9ADE" , "INICIADO","SISTEMA DE INFORMACIÓN GERENCIAL", "SIG", "USUARIO RESPONSABLE","FECHA INICIO ESTIMADA","FECHA FIN ESTIMADA", "DIAS HABILES DE DURACION",
                "FECHA INICIO REAL","FECHA FIN REAL","DIAS HABILES REALES",""
        });
        arrayListActividades.add(new String[]{"OBTENER CARRO PARA EL TRASLADO DE MOCHILAS","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "#2E9ADE" , "INICIADO","SISTEMA DE INFORMACIÓN GERENCIAL", "SIG", "USUARIO RESPONSABLE","FECHA INICIO ESTIMADA","FECHA FIN ESTIMADA", "DIAS HABILES DE DURACION",
                "FECHA INICIO REAL","FECHA FIN REAL","DIAS HABILES REALES",""
        });

        return arrayListActividades;
    }


}
