package com.example.openweatherapi.models;

import android.annotation.SuppressLint;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.openweatherapi.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DataMethods {

    //
    public void getWeatherInfo(Context context, String city,int unit) {
        String url;
        List<DataModel> weatherData = new ArrayList<>();

        if(unit == 1) {
            url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid=0d811575c68871f7fc0313a260187eab";
        } else {
            url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=imperial&appid=0d811575c68871f7fc0313a260187eab";
        }


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //JSONArray jsonArray = null;
                        try {
                            String main = response.getJSONArray("weather").getJSONObject(0).getString("main");
                            String description = response.getJSONArray("weather").getJSONObject(0).getString("description");
                            String icon = response.getJSONArray("weather").getJSONObject(0).getString("icon");
                            double temp = response.getJSONObject("main").getDouble("temp");
                            double feelTemp = response.getJSONObject("main").getDouble("feels_like");
                            double minTemp = response.getJSONObject("main").getDouble("temp_min");
                            double maxTemp = response.getJSONObject("main").getDouble("temp_max");
                            int pressure = response.getJSONObject("main").getInt("pressure");
                            int humidity = response.getJSONObject("main").getInt("humidity");
                            double wind = response.getJSONObject("wind").getDouble("speed");
                            long date = response.getLong("dt");
                            String name = response.getString("name");

                            //Date Time Converter
                            @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd hh:mma");
                            dateFormat.setTimeZone(TimeZone.getDefault());
                            String dateString = dateFormat.format(new Date(date*1000));

                            //ImageString
                            String imgStr = "https://openweathermap.org/img/wn/"+icon+"@4x.png";


                            /*jsonArray = response.getJSONArray("response");
                            for (int i = 0; i< jsonArray.length(); i++) {
                                weatherData.add(jsonArray.getJSONObject(i).getString("name"));
                            }*/
                            //airport.populateAirportData(airports);
                            ((MainActivity)context).passData(new DataModel(main, description,imgStr,temp,feelTemp,minTemp,maxTemp,pressure,humidity,wind,dateString, name));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        DataSingleton.getInstance(context).addToRequestQueue(request);

    }
}
