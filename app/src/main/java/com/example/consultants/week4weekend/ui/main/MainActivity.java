package com.example.consultants.week4weekend.ui.main;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.consultants.week4weekend.R;
import com.example.consultants.week4weekend.di.DaggerMainComponent;
import com.example.consultants.week4weekend.model.forecastdata.ForecastResponse;
import com.example.consultants.week4weekend.model.local.MyForecast;
import com.example.consultants.week4weekend.model.remote.RemoteDataSource;
import com.example.consultants.week4weekend.model.remote.VolleyQueue;
import com.example.consultants.week4weekend.model.remote.WeatherRepository;
import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;
import com.example.consultants.week4weekend.ui.fragment.TopFragment;
import com.example.consultants.week4weekend.ui.fragment.ZipcodeDialog;
import com.example.consultants.week4weekend.util.ConversionHelper;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View,
        ZipcodeDialog.OnInputListener {
    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    private FragmentManager fm;
    private TextView tvLocation;
    private TextView tvTemp;
    private TextView tvCondition;

    RecyclerView rvForecastList;
    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private TopFragment topFragment;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.create().inject(this);

        tvLocation = findViewById(R.id.tvLocation);
        tvTemp = findViewById(R.id.tvTemp);
        tvCondition = findViewById(R.id.tvCondition);

        //setup queue for volley network calls
        VolleyQueue.getInstance().setContext(this);
        VolleyQueue.getInstance().setQueue();

        //initialize fragment manager
        fm = getSupportFragmentManager();

        //show dialog to ask for zipcode
        ZipcodeDialog zcDialog = new ZipcodeDialog();
        zcDialog.show(fm, "ZipCodeDialog");
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDetach();
    }

    @Override
    public void startWeatherWithZip(String zip) {
        presenter.getWeather(zip);
        presenter.getForecast(zip);
    }

    @Override
    public void onWeather(WeatherResponse wResponse) {
        Log.d(TAG, "onWeather: " + wResponse.getMain().getTemp());

        //set city name (the OpenWeatherMap API doesn't give State info)
        tvLocation.setText(wResponse.getName());

        //set temp based on F or C preferences
        double tempDbl = ConversionHelper.kelvinToF(wResponse.getMain().getTemp());
        int temp = (int)Math.round(tempDbl);
        tvTemp.setText(Integer.toString(temp) + "°");

        //set conditions (rain, sunny, cloudy, etc)
        tvCondition.setText(wResponse.getWeather().get(0).getMain());

        //setting color based on temperature
        try {  //getView() may produce null, so wrapping in try catch
            topFragment = (TopFragment)fm.findFragmentById(R.id.fragTop);
            if (temp >= 60) {
                topFragment.getView().setBackgroundColor(getResources().getColor(R.color.colorPrimaryHot));
            } else {
                topFragment.getView().setBackgroundColor(getResources().getColor(R.color.colorPrimaryCool));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onForecast(ForecastResponse fResponse) {
        ArrayList<MyForecast> forecastList = ConversionHelper.parseData(fResponse);

        //setup adapter to populate recyclerview
        adapter = new RecyclerViewAdapter(forecastList);
        layoutManager = new LinearLayoutManager(this);
        rvForecastList = findViewById(R.id.rvForecast);
        rvForecastList.setAdapter(adapter);
        rvForecastList.setLayoutManager(layoutManager);

    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: " + error);
    }
}
