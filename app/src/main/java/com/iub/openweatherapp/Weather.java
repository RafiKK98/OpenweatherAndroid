package com.iub.openweatherapp;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;


public class Weather extends AsyncTask<String, Void, String>{

    String result;
    @Override
    protected String doInBackground(String... urls) {
        result = "";
        URL link;
        HttpURLConnection myConnection;

        try{
            link = new URL(urls[0]);
            myConnection = (HttpURLConnection) link.openConnection();
            InputStream in = myConnection.getInputStream();
            InputStreamReader myStreamReader = new InputStreamReader(in);
            int data = myStreamReader.read();
            while (data != -1){
                char current = (char) data;
                result += current;
                data = myStreamReader.read();
            }
            return result;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);
        ArrayList<String> temps = new ArrayList<>();
        ArrayList<Date> dates = new ArrayList<Date>(); // Will update this in the next submission
        try {
            JSONObject myObject = new JSONObject(result);
            JSONArray listArray = myObject.getJSONArray("list");

            for(int i = 0; i < listArray.length(); i++) {
                JSONObject listObject = listArray.getJSONObject(i);
                JSONObject main = new JSONObject(listObject.getString("main"));

                temps.add(main.getString("temp"));
            }
            JSONObject city = new JSONObject(myObject.getString("city"));
            String place = city.getString("name");


            MainActivity.place.setText("City : " + place);
            MainActivity.temp1.setText("Day 1 temperature : " + temps.get(0) + " \u2103");
            MainActivity.temp2.setText("Day 2 temperature : " + temps.get(8) + " \u2103");
            MainActivity.temp3.setText("Day 3 temperature : " + temps.get(16) + " \u2103");
            MainActivity.temp4.setText("Day 4 temperature : " + temps.get(24) + " \u2103");
            MainActivity.temp5.setText("Day 5 temperature : " + temps.get(32) + " \u2103");
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
