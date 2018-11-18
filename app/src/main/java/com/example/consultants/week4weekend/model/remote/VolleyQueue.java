package com.example.consultants.week4weekend.model.remote;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyQueue {

    private Context context;
    private RequestQueue queue;

    private static VolleyQueue soleInstance;

    private VolleyQueue(){}

    public static VolleyQueue getInstance(){
        if (soleInstance == null){ //if there is no instance available... create new one
            soleInstance = new VolleyQueue();
        }

        return soleInstance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setQueue() {
        this.queue = Volley.newRequestQueue(context);
    }

    public void addToRequestQueue(StringRequest stringRequest) {
        queue.add(stringRequest);
    }
}
