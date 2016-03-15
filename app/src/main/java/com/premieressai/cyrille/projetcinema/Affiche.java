package com.premieressai.cyrille.projetcinema;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

//Activité chargée d'afficher les films à l'affiche
public class Affiche extends BaseActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);

        //Vérification que la liste des films n'est pas vide
        if (PreChargement.liste_films_affiche != null) {
            Log.d("centrale", PreChargement.liste_films_affiche.toString());
        }

        //Adapter pour afficher la liste
        mListView = (ListView) findViewById(R.id.listView);

        FilmAdapter adapter = new FilmAdapter(Affiche.this, PreChargement.liste_films_affiche);
        mListView.setAdapter(adapter);

        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //Cliquer sur un film affiche sa page détaillée
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                try {
                    Film o = (Film) mListView.getItemAtPosition(position);
                    Intent monIntent = new Intent(Affiche.this, FilmDetail.class);
            //On envoie l'id du film dans l'intent pour le récupérer de l'autre côté.
                    monIntent.putExtra("id", o.getId());
                    startActivity(monIntent);
                } catch(Exception e){
                    Log.d("erreur", e.getMessage());
                }
            }
        });

    }

}
