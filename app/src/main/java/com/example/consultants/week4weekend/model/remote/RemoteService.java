package com.example.consultants.week4weekend.model.remote;

import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService {
    //current weather
    // add to URL: weather?zip=94040&APPID=
    @GET("weather")
    Observable<WeatherResponse> getWeatherObs(@Query("zip") String zip, @Query("APPID") String apiKey);

    //5 day forecast
    //add to URL: forecast?zip=94040
}
