package com.example.consultants.week4weekend.model.remote;

import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.consultants.week4weekend.NetworkHelper;
import com.example.consultants.week4weekend.model.forecastdata.ForecastResponse;
import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RemoteDataSource {
    public static final String TAG = RemoteDataSource.class.getSimpleName() + "_TAG";

    //get forecast with volley
    public void getForecastVolley(String zip, final ForecastCallback callback) {

        //build URL
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("api.openweathermap.org")
                .appendPath("data")
                .appendPath("2.5")
                .appendPath("forecast")
                .appendQueryParameter("zip", zip)
                .appendQueryParameter("APPID", NetworkHelper.API_KEY);

        String url = builder.build().toString();

        Log.d(TAG, "getForecastVolley: " + url);

        //use string request, then convert string with Gson to ForecastResponse
        StringRequest stringRequest = new StringRequest
                (Request.Method.GET, url, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: " + response.substring(0, 50));
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        ForecastResponse forecastResponse = gson.fromJson(response, ForecastResponse.class);
                        Log.d(TAG, "onResponse2: " + forecastResponse.getCod());
                        callback.onSuccess(forecastResponse);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onFailure(error.getMessage());
                    }
                });

        // Access the RequestQueue through your singleton class.
        VolleyQueue.getInstance().addToRequestQueue(stringRequest);
    }

    //get weather with volley
    public void getWeatherVolley(String zip, final WeatherCallback callback) {

        //build URL
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("api.openweathermap.org")
                .appendPath("data")
                .appendPath("2.5")
                .appendPath("weather")
                .appendQueryParameter("zip", zip)
                .appendQueryParameter("APPID", NetworkHelper.API_KEY);

        String url = builder.build().toString();

        Log.d(TAG, "getWeatherVolley: " + url);

        //use string request, then convert string with Gson to WeatherResponse
        StringRequest stringRequest = new StringRequest
                (Request.Method.GET, url, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: " + response.substring(0, 50));
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        WeatherResponse wResponse = gson.fromJson(response, WeatherResponse.class);
                        Log.d(TAG, "onResponse2: " + wResponse.getCod());
                        callback.onSuccess(wResponse);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onFailure(error.getMessage());
                    }
                });

        // Access the RequestQueue through your singleton class.
        VolleyQueue.getInstance().addToRequestQueue(stringRequest);
    }

}
