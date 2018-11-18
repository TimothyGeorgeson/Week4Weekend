package com.example.consultants.week4weekend.model.remote;

import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.consultants.week4weekend.NetworkHelper;
import com.example.consultants.week4weekend.model.weatherdata.WeatherResponse;
import com.example.consultants.week4weekend.ui.main.MainActivity;

import org.json.JSONObject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    public static final String TAG = RemoteDataSource.class.getSimpleName() + "_TAG";

    //Volley
    public void getWeatherVolley(String zip) {

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("api.openweathermap.org")
                .appendPath("data")
                .appendPath("2.5")
                .appendPath("forecast")
                .appendQueryParameter("zip", zip)
                .appendQueryParameter("APPID", NetworkHelper.API_KEY);

        String url = builder.build().toString();

        Log.d(TAG, "getWeatherVolley: " + url);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //mTextView.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

// Access the RequestQueue through your singleton class.
        VolleyQueue.getInstance().addToRequestQueue(jsonObjectRequest);
    }

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
        Log.d(TAG, "getWeatherObs: ");
        return getRemoteService().getWeatherObs(zip, NetworkHelper.API_KEY);
    }
}
