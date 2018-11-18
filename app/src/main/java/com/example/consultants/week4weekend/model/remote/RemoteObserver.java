package com.example.consultants.week4weekend.model.remote;

import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserver implements Observer<WeatherResponse> {

    WeatherCallback callback;

    public RemoteObserver(WeatherCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(WeatherResponse wResponse) {

        callback.onSuccess(wResponse);
    }

    @Override
    public void onError(Throwable e) {

        callback.onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
