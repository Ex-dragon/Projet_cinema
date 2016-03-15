package com.premieressai.cyrille.projetcinema;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Cyrille on 14/03/2016.
 */

//Activité affichant la liste des films à venir. Même modèle que pour Affiche.
public class Prochainement extends BaseActivity {

    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.prochainement);

        if (PreChargement.liste_prochainement != null) {
            Log.d("prochainement", PreChargement.liste_prochainement.toString());
        }

        mListView = (ListView) findViewById(R.id.listView);

        FilmAdapter adapter = new FilmAdapter(Prochainement.this, PreChargement.liste_prochainement);
        mListView.setAdapter(adapter);


        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                try {
                    Film o = (Film) mListView.getItemAtPosition(position);
                    Intent monIntent = new Intent(Prochainement.this, FilmDetail.class);
                    monIntent.putExtra("id", o.getId());
                    startActivity(monIntent);
                } catch(Exception e){
                    Log.d("erreur", e.getMessage());
                }
            }
        });

    }




}
