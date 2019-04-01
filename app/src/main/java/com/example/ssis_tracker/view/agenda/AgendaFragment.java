package com.example.ssis_tracker.view.agenda;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.agenda.AdapterAgenda;
import com.example.ssis_tracker.model.Agenda;

import java.util.ArrayList;

public class AgendaFragment  extends Fragment {

    private View view;
    private RecyclerView rvAgenda;
    private ArrayList<Agenda> arrayListAgenda;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_agenda, container, false);
        super.onCreate(savedInstanceState);
        this.rvAgenda = this.view.findViewById(R.id.rvAgenda);



        arrayListAgenda = new ArrayList<>();
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - LEPAERA", "20 de Octubre de 2019"));
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - LA CEIBA", "20 de Septiembre de 2019"));
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - YORO", "10 de Marzo de 2019"));
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - LEMPIRA", "20 de Diciembre de 2019"));
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - LA PAZ", "20 de Octubre de 2019"));
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - INTIBUCÁ", "20 de Octubre de 2019"));
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - ROATÁN", "20 de Octubre de 2019"));
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - COPAN", "20 de Octubre de 2019"));
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - GRACIAS A DIOS", "20 de Octubre de 2019"));
        arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - YUSCARÁN", "20 de Octubre de 2019"));


        AdapterAgenda adapterAgenda = new AdapterAgenda(getContext(),arrayListAgenda);
        rvAgenda.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAgenda.setAdapter(adapterAgenda);


        return view;
    }
}
