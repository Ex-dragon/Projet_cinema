package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by Cyrille on 31/01/2016.
 */
public class PreChargement extends Activity {

    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


    if(networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {

        //  boolean wifi = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;

        Log.d("NetworkState", "Pas de connexion internet");

    }
    else {Log.d("NetworkState", "Connexion établie.");}
}
