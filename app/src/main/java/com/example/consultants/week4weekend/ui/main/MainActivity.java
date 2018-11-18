package com.example.consultants.week4weekend.ui.main;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.consultants.week4weekend.R;
import com.example.consultants.week4weekend.model.forecastdata.ForecastResponse;
import com.example.consultants.week4weekend.model.remote.RemoteDataSource;
import com.example.consultants.week4weekend.model.remote.VolleyQueue;
import com.example.consultants.week4weekend.model.remote.WeatherRepository;
import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;
import com.example.consultants.week4weekend.ui.fragment.ZipcodeDialog;
import com.example.consultants.week4weekend.util.WeatherConversion;

public class MainActivity extends AppCompatActivity implements MainContract.View,
        ZipcodeDialog.OnInputListener {
    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    private FragmentManager fm;
    private MainPresenter presenter;
    private TextView tvLocation;
    private TextView tvTemp;
    private TextView tvCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(new WeatherRepository(new RemoteDataSource()));

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
        double tempDbl = WeatherConversion.kelvinToF(wResponse.getMain().getTemp());
        int temp = (int)Math.round(tempDbl);
        tvTemp.setText(Integer.toString(temp) + "°");

        //set conditions (rain, sunny, cloudy, etc)
        tvCondition.setText(wResponse.getWeather().get(0).getMain());

    }

    @Override
    public void onForecast(ForecastResponse fResponse) {

    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: " + error);
    }
}
