package com.example.consultants.week4weekend.model.remote;

import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;

public interface WeatherCallback {
    void onSuccess(WeatherResponse wResponse);

    void onFailure(String error);
}
