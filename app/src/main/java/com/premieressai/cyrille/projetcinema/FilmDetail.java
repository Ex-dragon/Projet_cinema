package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyrille on 13/03/2016.
 */
public class FilmDetail extends Activity {

    // afficher titre, durée, synopsis, Acteurs, directeur, séances, langue, photos, vidéos

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
        TextView Is_troisd = (TextView)findViewById(R.id.is_troisd);

        Titre.setText(film_test.getTitre());
        Duree.setText(String.valueOf(film_test.getDuree()));
        Genre.setText(film_test.getGenre());
        Is_troisd.setText(String.valueOf(film_test.getIs_troisd()));



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
