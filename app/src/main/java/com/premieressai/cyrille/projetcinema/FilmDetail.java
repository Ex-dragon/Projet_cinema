package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.util.List;

/**
 * Created by Cyrille on 13/03/2016.
 */
public class FilmDetail extends BaseActivity {

    //requestFeature(FEATURE_ACTION_BAR);

    // séances, langue, photos, vidéos

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fiche_film);

        Film film_test = new Film();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
// Get data via the key
            int id = extras.getInt("id");
            film_test = getFilm(PreChargement.liste_seances_films, id);
            Log.d("centrale", String.valueOf(film_test));

        }

        TextView Titre = (TextView)findViewById(R.id.titre);

        TextView Duree = (TextView)findViewById(R.id.duree);
        TextView Genre = (TextView)findViewById(R.id.genre);
        TextView Categorie = (TextView)findViewById(R.id.categorie);

        TextView Is_troisd = (TextView)findViewById(R.id.is_troisd);
        TextView Malentendant = (TextView)findViewById(R.id.malentendant);
        TextView Handicape = (TextView)findViewById(R.id.handicape);

        TextView Acteurs = (TextView)findViewById(R.id.acteurs);
        TextView Realisateur = (TextView)findViewById(R.id.realisateur);
        TextView Distributeur = (TextView)findViewById(R.id.distributeur);

        TextView Synopsis = (TextView)findViewById(R.id.synopsis);

        Titre.setText(film_test.getTitre());
        Duree.setText(String.valueOf("Durée : " + film_test.getDuree()));
        Genre.setText("Genre : " + film_test.getGenre());
        Categorie.setText("Categorie : " + film_test.getCategorie());
        Is_troisd.setText("3D : " + film_test.getIs_troisd());
        Malentendant.setText("Malentendant : " + film_test.getIs_malentendant());
        Handicape.setText("Handicape : " + film_test.getIs_handicape());

        Log.d("acteurs", String.valueOf(film_test.getActeurs()));

        if (film_test.getActeurs() != "") {
            Acteurs.setText("Acteurs : " + film_test.getActeurs());
        } else {Acteurs.setVisibility(View.GONE);}

        Realisateur.setText("Réalisateur : " + film_test.getRealisateur());
        Distributeur.setText("Producteur : " + film_test.getDistributeur());
        Synopsis.setText("Synopsis : " + film_test.getSynopsis());

    }


    public Film getFilm(List<Film> liste, int id){
        Film film = new Film();

        for (int i = 0; i<liste.size(); i++){
            if (liste.get(i).getId() == id){
                film = liste.get(i);
            }
            if (liste.get(i).getFilmid() == id){
                film = liste.get(i);
            }
        }
        return film;
    }

}
