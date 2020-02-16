package com.example.ssis_tracker.repository.agenda;

import com.example.ssis_tracker.api.agenda.ApiAdapterAgenda;
import com.example.ssis_tracker.api.agenda.ApiServiceAgenda;
import com.example.ssis_tracker.model.Agenda;
import com.example.ssis_tracker.presenter.agenda.AgendaFragmentPresenter;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgendaFragmentRepositoryImpl implements AgendaFragmentRepository {

    private AgendaFragmentPresenter agendaFragmentPresenter;
    private ApiServiceAgenda servicesAgenda;

    public AgendaFragmentRepositoryImpl(AgendaFragmentPresenter agendaFragmentPresenter){
        this.agendaFragmentPresenter = agendaFragmentPresenter;
        this.servicesAgenda = new ApiAdapterAgenda().getClientService();
    }

    @Override
    public void GetTemasAgendados() {
        Call<ArrayList<Agenda>> ListarAgenda = this.servicesAgenda.ListarTemaAgenda();
        ListarAgenda.enqueue(new Callback<ArrayList<Agenda>>() {
            @Override
            public void onResponse(Call<ArrayList<Agenda>> call, Response<ArrayList<Agenda>> response) {

                ArrayList<Agenda> arrayListAgenda = new ArrayList<>();
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - LEPAERA", "20 de Octubre de 2019" ,1));
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - LA CEIBA", "20 de Septiembre de 2019", 2));
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - YORO", "10 de Marzo de 2019",3));
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - LEMPIRA", "20 de Diciembre de 2019",4));
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - LA PAZ", "20 de Octubre de 2019",5));
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - INTIBUCÁ", "20 de Octubre de 2019",6));
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - ROATÁN", "20 de Octubre de 2019",7));
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - COPAN", "20 de Octubre de 2019",8));
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - GRACIAS A DIOS", "20 de Octubre de 2019",9));
                arrayListAgenda.add(new Agenda("ENTREGA DE MOCHILAS - YUSCARÁN", "20 de Octubre de 2019",10));
                agendaFragmentPresenter.ListarTemasAgendados(arrayListAgenda);
              //  agendaFragmentPresenter.ListarTemasAgendados(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Agenda>> call, Throwable t) {

            }
        });
    }


    @Override
    public void EliminarTemasAgendados(int IdTema) {
        Call<ArrayList<Agenda>> EliminarAgenda = this.servicesAgenda.EliminarTemaAgenda(IdTema);
        EliminarAgenda.enqueue(new Callback<ArrayList<Agenda>>() {
            @Override
            public void onResponse(Call<ArrayList<Agenda>> call, Response<ArrayList<Agenda>> response) {

            }

            @Override
            public void onFailure(Call<ArrayList<Agenda>> call, Throwable t) {

            }
        });
    }

}
