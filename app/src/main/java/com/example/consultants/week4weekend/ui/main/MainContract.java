package com.example.consultants.week4weekend.ui.main;

import com.example.consultants.week4weekend.model.forecastdata.ForecastResponse;
import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;
import com.example.consultants.week4weekend.ui.base.BasePresenter;
import com.example.consultants.week4weekend.ui.base.BaseView;

public interface MainContract {

    interface View extends BaseView {

        void onWeather(WeatherResponse wResponse);
        void onForecast(ForecastResponse fResponse);
    }

    interface Presenter extends BasePresenter<View> {

        void getWeather(String zip);
        void getForecast(String zip);
    }
}
