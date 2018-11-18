package com.example.consultants.week4weekend.model.remote;

import com.example.consultants.week4weekend.model.forecastdata.ForecastResponse;

public interface ForecastCallback {
    void onSuccess(ForecastResponse fResponse);

    void onFailure(String error);
}
