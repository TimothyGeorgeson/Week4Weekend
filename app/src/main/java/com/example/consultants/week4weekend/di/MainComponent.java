package com.example.consultants.week4weekend.di;

import com.example.consultants.week4weekend.ui.main.MainActivity;

import dagger.Component;

@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
