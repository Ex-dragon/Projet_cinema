package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Cyrille on 31/01/2016.
 * Classe principale où sont effectués les chargements des json et une partie du traitement des données.
 */
public class PreChargement extends Activity {


    public static JSONArray liste_temporaire;
    public static JSONObject liste_temp_proc;
    public static List<Film> liste_films_affiche;
    public static List<Film> liste_seances_films;
    public static List<Film> liste_prochainement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_chargement);

        //Vérification de la disponibilité d'une connection internet
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

        // Préparation du cache et du réseau. Démarrage de la queue des requêtes.
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        RequestQueue mRequestQueue = new RequestQueue(cache, network);
        mRequestQueue.start();

        //requêtes de récupération du flux Séances
        String url_seance = "http://centrale.corellis.eu/seances.json";
        JsonArrayRequest jsArrRequestSeance = new JsonArrayRequest
                (Request.Method.GET, url_seance, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        liste_temporaire = response;
                        liste_seances_films = film_seance(liste_temporaire, liste_films_affiche);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error seance", error.getMessage());
                    }
                });
        Singleton.getInstance(this).addToRequestQueue(jsArrRequestSeance);

        //Requête de récupération du flux Prochainement
        String url_prochainement = "http://centrale.corellis.eu/prochainement.json";
        JsonObjectRequest jsObjRequestProc = new JsonObjectRequest
                (Request.Method.GET, url_prochainement, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        liste_temp_proc = response;
                        liste_prochainement = film_prochainement(liste_temp_proc);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error proc", error.getMessage());
                    }
                });
        Singleton.getInstance(this).addToRequestQueue(jsObjRequestProc);

        //Requête de récupération du flux Filmseances
        String url = "http://centrale.corellis.eu/filmseances.json";
        JsonArrayRequest jsArrRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.d("test", response.toString());
                        liste_temporaire = response;
                        liste_films_affiche = film_affiche(liste_temporaire);
                        Intent intent = new Intent(PreChargement.this, Affiche.class);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error affiche", error.getMessage());
                    }
                });
        Singleton.getInstance(this).addToRequestQueue(jsArrRequest);
    }


    //Fonction vérifiant la disponibilité d'une connection internet
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

    //Fonction récupérant la liste des films à l'affiche. Les films sont ensuite réunis dans une ArrayList
    public List<Film> film_affiche(JSONArray flux){

        List<Film> liste_films = new ArrayList<>();

        try {
            for (int i=0; i<flux.length(); i++){

                Film film_test = new Film();

                JSONObject jsonObject = flux.getJSONObject(i);

                film_test.setId(jsonObject.getInt("id"));
                film_test.setTitre(jsonObject.getString("titre"));
                film_test.setDuree(jsonObject.getInt("duree"));
                film_test.setAffiche(jsonObject.getString("affiche"));
                film_test.setGenre(jsonObject.getString("genre"));
                film_test.setDistributeur(jsonObject.getString("distributeur"));
                film_test.setActeurs(jsonObject.getString("participants"));
                film_test.setRealisateur(jsonObject.getString("realisateur"));
                film_test.setSynopsis(jsonObject.getString("synopsis"));
                film_test.setCategorie(jsonObject.getString("categorie"));

                liste_films.add(film_test);

            }

        } catch (JSONException e) {
            Log.d("error jsonarray", e.getMessage());
        }
        return liste_films;
    }

    //Fonction récupérant les séances pour chaque film. Les séances sont stockées dans une ArrayList<Séance>
    public List<Film> film_seance(JSONArray flux, List<Film> liste){

        try {
            for (int i=0; i<flux.length(); i++){

                JSONObject jsonObject = flux.getJSONObject(i);

                for (int j=0; j<liste.size(); j++) {

                    if (liste.get(j).getId() == jsonObject.getInt("filmid")){
                        Seance seance = new Seance();

                        seance.setIs_troisd(jsonObject.getBoolean("is_troisd"));
                        seance.setIs_malentendant(jsonObject.getBoolean("is_malentendant"));
                        seance.setIs_handicape(jsonObject.getBoolean("is_handicape"));
                        seance.setCinemaid(jsonObject.getInt("cinemaid"));
                        seance.setLangue(jsonObject.getString("nationality"));
                        seance.setDate(jsonObject.getString("actual_date"));
                        seance.setHeure(jsonObject.getString("show_time"));
                        seance.setCinema_salle(jsonObject.getString("cinema_salle"));
                        seance.setFilmid(jsonObject.getInt("filmid"));

                        liste.get(j).getSeance().add(seance);
                    }
                }
            }
        } catch (JSONException e) {
            Log.d("error jsonarray", e.getMessage());
        }
        return liste;
    }

    //Fonction récupérant la liste des films de la semain suivante
    public List<Film> film_prochainement(JSONObject flux){

        List<Film> liste_films;
        JSONArray proc = new JSONArray();
        try {
            proc = flux.getJSONArray("films");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //réutilisation de film affiche car le traitement des données est le même.
        liste_films = film_affiche(proc);
        return liste_films;
    }
}
