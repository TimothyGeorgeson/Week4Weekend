package com.example.consultants.week4weekend.model.remote;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherRepository {

    RemoteDataSource remoteDataSource;

    public WeatherRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void getWeather(String zip, final WeatherCallback callback) {

        remoteDataSource.getWeatherObs(zip)
//                    make the network call on the worker thread
                .subscribeOn(Schedulers.io())
//                    get the results back on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RemoteObserver(callback));

    }

    public void getForecast(String zip) {
        remoteDataSource.getWeatherVolley(zip);
    }
}

