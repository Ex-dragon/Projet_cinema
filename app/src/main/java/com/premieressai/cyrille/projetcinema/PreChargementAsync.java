package com.premieressai.cyrille.projetcinema;

import android.os.AsyncTask;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Cyrille on 06/03/2016.
 */
public class PreChargementAsync extends AsyncTask<String, Void, String> {

    private final CinemaActivity CinemaActivity;

    public PreChargementAsync(CinemaActivity cinema) {

        CinemaActivity = null;
    }


    @Override
    protected String doInBackground(String... params) {

// méthode qui récupère les json en arrière-plan

        String chaine = "";

        for (String urlString : params) {

            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("User-Agent", "");
                connection.setRequestMethod("POST");
                connection.setDoInput(true);
                connection.connect();

                InputStream inputStream = connection.getInputStream();

                BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    chaine += line;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return chaine;
    }

    protected void onPostExecute(Long result) {

    }

}
