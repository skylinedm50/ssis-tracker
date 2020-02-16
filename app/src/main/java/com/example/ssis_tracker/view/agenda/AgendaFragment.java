package com.example.ssis_tracker.view.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.agenda.AdapterAgenda;
import com.example.ssis_tracker.model.Agenda;
import com.example.ssis_tracker.presenter.agenda.AgendaFragmentPresenter;
import com.example.ssis_tracker.presenter.agenda.AgendaFragmentPresenterImpl;
import java.util.ArrayList;

public class AgendaFragment  extends Fragment implements AgendaFragmentView {

    private View view;
    private RecyclerView rvAgenda;
    private AdapterAgenda adapterAgenda;
    private AgendaFragmentPresenter agendaFragmentPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_agenda, container, false);
        super.onCreate(savedInstanceState);
        this.rvAgenda = this.view.findViewById(R.id.rvAgenda);
        this.agendaFragmentPresenter = new AgendaFragmentPresenterImpl(this);

        adapterAgenda = new AdapterAgenda(getContext());
        rvAgenda.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAgenda.setAdapter(adapterAgenda);

        FloatingActionButton FloatActionButton = view.findViewById(R.id.FloatingActionButtonAgendar);
        FloatActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAgendar  = new Intent(v.getContext(),AgendarTemaActivity.class);
                v.getContext().startActivity(intentAgendar);
            }
        });

        GetTemasAgendados();

        return view;
    }

    @Override
    public void configAppBar(boolean bolDefault) {
        if(bolDefault)
            ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("");
        else
            ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Agenda Staff");
    }


    @Override
    public void GetTemasAgendados() {
        this.agendaFragmentPresenter.GetTemasAgendados();
    }

    @Override
    public void ListarTemasAgendados(ArrayList<Agenda> TemasAgendados) {
        adapterAgenda.AgregarTemasAgendados(TemasAgendados);
    }


    @Override
    public void EliminarTemasAgendados(int IdTema) {
        if(this.agendaFragmentPresenter == null )
            this.agendaFragmentPresenter = new AgendaFragmentPresenterImpl(this);
        this.agendaFragmentPresenter.EliminarTemasAgendados(IdTema);
    }
}
