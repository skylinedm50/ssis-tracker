package com.example.ssis_tracker.api.performance;

import com.example.ssis_tracker.model.Performance;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServicePerformance {

    @GET("performance/get")
    Call<ArrayList<Performance>> getPerformance();
}
