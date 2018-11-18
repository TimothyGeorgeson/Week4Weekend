package com.example.consultants.week4weekend.di;

import com.example.consultants.week4weekend.model.remote.WeatherRepository;
import com.example.consultants.week4weekend.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module(includes = DataModule.class)
public class MainModule {

    @Provides
    MainPresenter providesMainPresenter(WeatherRepository weatherRepository) {
        return new MainPresenter(weatherRepository);
    }
}
