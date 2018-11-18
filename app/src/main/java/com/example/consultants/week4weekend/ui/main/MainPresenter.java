package com.example.consultants.week4weekend.ui.main;

import com.example.consultants.week4weekend.model.remote.WeatherCallback;
import com.example.consultants.week4weekend.model.remote.WeatherRepository;
import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;

public class MainPresenter implements MainContract.Presenter {

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
        repository.getForecast(zip);
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
