package com.example.openweatherapi.models;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class DataSingleton {
    private static DataSingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private DataSingleton(Context context){
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized DataSingleton getInstance(Context context) {
        if(singleton == null) singleton = new DataSingleton(context);
        return singleton;
    }

    private RequestQueue getRequestQueue() {
        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return  requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {getRequestQueue().add(request);}
}
