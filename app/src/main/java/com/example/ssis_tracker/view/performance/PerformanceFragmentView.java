package com.example.ssis_tracker.view.performance;

import com.example.ssis_tracker.model.Performance;
import java.util.ArrayList;

public interface PerformanceFragmentView {
    void SolicitarDatosPerformance();
    void PresentarDatosPerformance(ArrayList<Performance> performances);
}
