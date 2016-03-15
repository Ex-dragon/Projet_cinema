package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Created by Cyrille on 15/03/2016.
 */

//Classe assurant que les options en commun telles que le menu soient bien transmises à toutes les classes.
public class BaseActivity extends Activity {

    static final String TAG="centrale";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_index_cinema, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case R.id.affiche:
            {
                try {Intent intent = new Intent(this, Affiche.class);
                    this.startActivity(intent);
                    return true;} catch (Exception e){
                    Log.d("affiche", e.getMessage());
                }
            }
            case R.id.prochainement:
            {
                try {Intent intent = new Intent(this, Prochainement.class);
                this.startActivity(intent);
                return true;} catch (Exception e){
                    Log.d("prochainement", e.getMessage());
                }
            }
            case R.id.events:
            {}
            case R.id.préférences:
            {}
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
