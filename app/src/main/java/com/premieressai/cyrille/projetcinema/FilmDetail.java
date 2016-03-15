package com.premieressai.cyrille.projetcinema;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyrille on 13/03/2016.
 */

//Activité  affichant la fiche détaillée d'un film
public class FilmDetail extends BaseActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fiche_film);

        Film film_test = new Film();

        //Récupération de l'id et donc du film.
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int id = extras.getInt("id");
            film_test = getFilm(PreChargement.liste_films_affiche, id);
            Log.d("centrale", String.valueOf(film_test));
        }

        //Affichage + mise en page
        TextView Titre = (TextView)findViewById(R.id.titre);

        TextView Duree = (TextView)findViewById(R.id.duree);
        TextView Genre = (TextView)findViewById(R.id.genre);
        TextView Categorie = (TextView)findViewById(R.id.categorie);

        TextView Acteurs = (TextView)findViewById(R.id.acteurs);
        TextView Realisateur = (TextView)findViewById(R.id.realisateur);
        TextView Distributeur = (TextView)findViewById(R.id.distributeur);

        TextView Synopsis = (TextView)findViewById(R.id.synopsis);

        Titre.setText(film_test.getTitre());
        Duree.setText(String.valueOf("Durée : " + film_test.getDuree()));
        Genre.setText("Genre : " + film_test.getGenre());
        Categorie.setText("Categorie : " + film_test.getCategorie());
        Acteurs.setText("Acteurs : " + film_test.getActeurs());
        Realisateur.setText("Réalisateur : " + film_test.getRealisateur());
        Distributeur.setText("Producteur : " + film_test.getDistributeur());
        Synopsis.setText("Synopsis : " + film_test.getSynopsis());

        //Adapter pour la liste des séances
        mListView = (ListView) findViewById(R.id.listView2);

        SeanceAdapter adapter = new SeanceAdapter(FilmDetail.this, film_test.getSeance());
        mListView.setAdapter(adapter);
        Helper.getListViewSize(mListView);

    }

//Fonction pour retrouver un film dans une liste à partir de son id.
    public Film getFilm(List<Film> liste, int id){
        Film film = new Film();

        for (int i = 0; i<liste.size(); i++){
            if (liste.get(i).getId() == id){
                film = liste.get(i);
            }
        }
        return film;
    }
}
