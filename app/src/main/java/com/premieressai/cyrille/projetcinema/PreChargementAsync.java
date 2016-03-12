package com.premieressai.cyrille.projetcinema;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Cyrille on 06/03/2016.
 */
public class PreChargementAsync extends AsyncTask<String, Void, String> {



    public PreChargementAsync() {

    }


    @Override
    protected String doInBackground(String... params) {

// méthode qui récupère les json en arrière-plan

        String[] a = new String[]{};
        String chaine = "";
        int i = 0;

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
                String line;
                while ((line = rd.readLine()) != null) {
                    chaine += line;
                }
                a[i] += chaine;
                i++;

                connection.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //PreChargement.liste = a;
        return chaine;
    }

    //@Override
    protected void onPostExecute(String result) {

        //PreChargement.liste[0] = "Yay !"; //Histoire de récupérer un truc sans me faire chier avec les détails

    }

}
