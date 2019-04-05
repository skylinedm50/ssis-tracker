package com.example.ssis_tracker.presenter.performance;

import com.example.ssis_tracker.model.Performance;

import java.util.ArrayList;

public interface PerformanceFragmentPresenter {
    void SolicitarDatosPerformance();
    void PresentarDatosPerformance(ArrayList<Performance> performances);
}
