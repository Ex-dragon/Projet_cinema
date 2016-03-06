package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import java.io.IOException;


/**
 * Created by Cyrille on 31/01/2016.
 */
public class PreChargement extends Activity {

    private static final String TAG = "Ma chaine";

    private String liste;

    public PreChargement() throws IOException {

        this.liste = RetrieveList();
    }

    private String RetrieveList() throws IOException {

        CinemaActivity cinema = null;

        PreChargementAsync task = new PreChargementAsync(cinema);
        String a = String.valueOf(task.execute("http://centrale.corellis.eu/events.json",
                "http://centrale.corellis.eu/filmseances.json",
                "http://centrale.corellis.eu/prochainement.json",
                "http://centrale.corellis.eu/seances.json"));



        return a;
    }

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


// "http://centrale.corellis.eu/animations_commerciales.json"


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_chargement);

        if(isInternetAvailable(this))
        {
            Toast toast = Toast.makeText(this, "Connection à internet établie", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Impossible de se connecter à internet", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}
