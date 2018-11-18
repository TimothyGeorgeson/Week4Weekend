package com.example.consultants.week4weekend.model.remote;

import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService {

    // add to URL: weather?zip=94040&APPID=
    @GET("weather")
    Observable<WeatherResponse> getWeatherObs(@Query("zip") String zip, @Query("APPID") String apiKey);
}
