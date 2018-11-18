package com.example.consultants.week4weekend.model.remote;

import com.example.consultants.week4weekend.NetworkHelper;
import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private Retrofit createInstance() {

        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_URL)
//                use for converting the response using Gson
                .addConverterFactory(GsonConverterFactory.create())
                //using rxjava adapter
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private  RemoteService getRemoteService() {
        return createInstance().create(RemoteService.class);
    }


    //using rxjava
    public Observable<WeatherResponse> getWeatherObs(String zip) {
        return getRemoteService().getWeatherObs(zip, NetworkHelper.API_KEY);
    }
}
