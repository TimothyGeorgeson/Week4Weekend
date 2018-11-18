package com.example.consultants.week4weekend.di;

import com.example.consultants.week4weekend.model.remote.RemoteDataSource;
import com.example.consultants.week4weekend.model.remote.WeatherRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    RemoteDataSource providesRemoteDataSource() {
        return new RemoteDataSource();
    }

    @Provides
    WeatherRepository providesWeatherRepository(RemoteDataSource remoteDataSource) {
        return new WeatherRepository(remoteDataSource);
    }
}
