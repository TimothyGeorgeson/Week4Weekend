package com.example.consultants.week4weekend.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

import com.example.consultants.week4weekend.model.remote.RemoteDataSource;
import com.example.consultants.week4weekend.model.remote.WeatherRepository;
import com.example.consultants.week4weekend.ui.main.MainPresenter;

public class WeatherSyncAdapter extends AbstractThreadedSyncAdapter {

    public WeatherSyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    public WeatherSyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        //wasn't sure where to go from here

//        MainPresenter presenter = new MainPresenter(new WeatherRepository(new RemoteDataSource()));
//        presenter.getWeather(zip);
//        presenter.getForecast(zip);

    }

}
