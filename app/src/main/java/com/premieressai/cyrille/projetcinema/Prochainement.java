package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Cyrille on 14/03/2016.
 */
public class Prochainement extends BaseActivity {

    ListView mListView;
    static final String TAG="centrale";

    public void Prochainement(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.prochainement);

        if (PreChargement.liste_films_affiche != null) {
            Log.d("centrale", PreChargement.liste_films_affiche.toString());
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

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }
    @Override
    protected void onPause() {
        Log.d(TAG,"onPause");
        super.onPause();
    }
    @Override
    protected void onRestart() {
        Log.d(TAG,"onRestart");
        super.onRestart();
    }
    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");
        super.onResume();
    }
    @Override
    protected void onStart() {
        Log.d(TAG,"onStart");
        super.onStart();
    }
    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");
        super.onStop();
    }
}
