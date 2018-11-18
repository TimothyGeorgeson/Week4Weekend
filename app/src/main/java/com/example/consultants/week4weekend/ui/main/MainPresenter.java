package com.example.consultants.week4weekend.ui.main;

import android.util.Log;

import com.example.consultants.week4weekend.model.forecastdata.ForecastResponse;
import com.example.consultants.week4weekend.model.remote.ForecastCallback;
import com.example.consultants.week4weekend.model.remote.WeatherCallback;
import com.example.consultants.week4weekend.model.remote.WeatherRepository;
import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;

public class MainPresenter implements MainContract.Presenter {
    public static final String TAG = MainPresenter.class.getSimpleName() + "_TAG";

    MainContract.View view;
    WeatherRepository repository;

    public MainPresenter(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getWeather(String zip) {

        repository.getWeather(zip, new WeatherCallback() {
            @Override
            public void onSuccess(WeatherResponse wResponse) {
                view.onWeather(wResponse);
            }

            @Override
            public void onFailure(String error) {
                view.showError(error);

            }
        });
    }

    public void getForecast(String zip) {

        repository.getForecast(zip, new ForecastCallback() {
            @Override
            public void onSuccess(ForecastResponse fResponse) {
                Log.d(TAG, "onSuccess: volley");
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    @Override
    public void onAttach(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
