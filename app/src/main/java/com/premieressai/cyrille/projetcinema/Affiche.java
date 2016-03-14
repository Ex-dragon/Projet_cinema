package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


/*Ecran de chargement qui teste si connexion fonctionne.
Sinon, le dit. Si oui, charge les données + go index.
 */

public class Affiche extends Activity {

    private TextView textView;
    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);

        if (PreChargement.liste_films_affiche != null) {
            textView = (TextView) findViewById(R.id.textView);
            //textView.setText("GG !");
            Log.d("centrale", PreChargement.liste_films_affiche.toString());
        }

        mListView = (ListView) findViewById(R.id.listView);

        FilmAdapter adapter = new FilmAdapter(Affiche.this, PreChargement.liste_films_affiche);
        mListView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index_cinema, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Choose_type_de_flux(){
        //prochainement, event, etc...
    }
}
