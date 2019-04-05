package com.example.ssis_tracker.repository.performance;

import com.example.ssis_tracker.api.performance.ApiAdapterPerformance;
import com.example.ssis_tracker.api.performance.ApiServicePerformance;
import com.example.ssis_tracker.model.Performance;
import com.example.ssis_tracker.presenter.performance.PerformanceFragmentPresenter;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerformanceFragmentRepositoryImpl implements PerformanceFragmentRepository {

    private PerformanceFragmentPresenter performanceFragmentPresenter;
    private ApiAdapterPerformance adapterPerformance;
    private ApiServicePerformance servicePerformance;

    public PerformanceFragmentRepositoryImpl(PerformanceFragmentPresenter performanceFragmentPresenter){
         this.performanceFragmentPresenter = performanceFragmentPresenter;
         adapterPerformance = new ApiAdapterPerformance();
         servicePerformance = adapterPerformance.getClientService();
    }

    @Override
    public void SolicitarDatosPerformance() {
        final ArrayList<Performance> performances = new ArrayList<>();

        Performance perf1 = new Performance();
        perf1.setPerformance(1);
        perf1.setProcentaje(75);

        performances.add(perf1);

        Performance perf2 = new Performance();
        perf2.setPerformance(2);
        perf2.setProcentaje(85);

        performances.add(perf2);

        Performance perf3 = new Performance();
        perf3.setPerformance(3);
        perf3.setProcentaje(90);

        performances.add(perf3);

        Performance perf4 = new Performance();
        perf4.setPerformance(4);
        perf4.setProcentaje(90);

        performances.add(perf4);

        Performance perf5 = new Performance();
        perf5.setPerformance(5);
        perf5.setProcentaje(55);
        performances.add(perf5);

        Call<ArrayList<Performance>> call = servicePerformance.getPerformance();
        call.enqueue(new Callback<ArrayList<Performance>>() {
            @Override
            public void onResponse(Call<ArrayList<Performance>> call, Response<ArrayList<Performance>> response) {
                performanceFragmentPresenter.PresentarDatosPerformance(performances);
            }

            @Override
            public void onFailure(Call<ArrayList<Performance>> call, Throwable t) { }
        });
    }
}
