package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Cyrille on 31/01/2016.
 */
public class PreChargement extends Activity {

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



        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        RequestQueue mRequestQueue = new RequestQueue(cache, network);

        // Start the queue
        mRequestQueue.start();


        //TextView mTxtDisplay;
        //ImageView mImageView;
        //final TextView mTxtDisplay = (TextView) findViewById(R.id.text);
        String url = "http://centrale.corellis.eu/filmseances.json";

        JsonArrayRequest jsArrRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("test", response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error volley", error.getMessage());
                    }
                });

        // Access the RequestQueue through your singleton class.
        Singleton.getInstance(this).addToRequestQueue(jsArrRequest);
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

}
