package com.example.ssis_tracker.presenter.agenda;

import com.example.ssis_tracker.model.Agenda;
import java.util.ArrayList;

public interface AgendaFragmentPresenter {
    void GetTemasAgendados();
    void ListarTemasAgendados(ArrayList<Agenda> TemasAgendados);
    void EliminarTemasAgendados(int IdTema);
}
