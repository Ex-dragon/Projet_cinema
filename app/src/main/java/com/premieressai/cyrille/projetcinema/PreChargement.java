package com.premieressai.cyrille.projetcinema;

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
 * Created by Cyrille on 31/01/2016.
 */
public class PreChargement extends Activity {

    private static final String TAG = "Ma chaine";

    public static boolean isInternetAvailable(Context context)
    {
        boolean isInternetAvailable = false;

        try
        {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if(networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected())
            {
                isInternetAvailable  = true;
            }
        }
        catch(Exception exception)
        {
            // Do Nothing
        }

        return isInternetAvailable;
    }

    private StringBuffer request(String urlString) {
        StringBuffer chaine = new StringBuffer("");
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("User-Agent", "");
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while((line = rd.readLine()) != null){
                chaine.append(line);
            }

        } catch (IOException e) {
            //writing exception to log
            e.printStackTrace();
        }

        return chaine;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_chargement);

        StringBuffer a;

        if(isInternetAvailable(this))
        {
            Toast toast = Toast.makeText(this, "internet available", Toast.LENGTH_SHORT);
            toast.show();
            try {
                a = request("http://centrale.corellis.eu/animations_commerciales.json");
                //Log.d(TAG, a.toString());
            } catch (Exception e) {
                Toast toaaast = Toast.makeText(this, "Chargement impossible", Toast.LENGTH_SHORT);
                toaaast.show();
            }
        }
        else
        {
            Toast toast = Toast.makeText(this, "internet not available", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}
