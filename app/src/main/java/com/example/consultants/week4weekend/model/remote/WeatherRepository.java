package com.example.consultants.week4weekend.model.remote;

public class WeatherRepository {

    RemoteDataSource remoteDataSource;

    public WeatherRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void getWeather(String zip, final WeatherCallback callback) {
        //call to volley for current weather
        remoteDataSource.getWeatherVolley(zip, callback);
    }

    public void getForecast(String zip, final ForecastCallback callback) {
        //call to volley for forecast
        remoteDataSource.getForecastVolley(zip, callback);
    }
}

