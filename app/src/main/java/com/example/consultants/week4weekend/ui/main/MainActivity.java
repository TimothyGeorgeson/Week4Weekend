package com.example.consultants.week4weekend.ui.main;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.example.consultants.week4weekend.R;
import com.example.consultants.week4weekend.model.remote.RemoteDataSource;
import com.example.consultants.week4weekend.model.remote.WeatherRepository;
import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;

public class MainActivity extends AppCompatActivity implements MainContract.View,
        ZipcodeDialog.OnInputListener {
    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    public String zipCode;
    public TextView tvZipCode;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(new WeatherRepository(new RemoteDataSource()));

        tvZipCode = findViewById(R.id.tvZipCode);

        //show dialog to ask for zipcode
        ZipcodeDialog zcDialog = new ZipcodeDialog();
        zcDialog.show(getSupportFragmentManager(), "ZipCodeDialog");

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
    }

    @Override
    public void onWeather(WeatherResponse wResponse) {
        Log.d(TAG, "onWeather: " + wResponse.getMain().getTemp());
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: " + error);
    }
}
