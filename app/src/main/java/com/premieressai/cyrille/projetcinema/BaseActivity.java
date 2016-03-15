package com.premieressai.cyrille.projetcinema;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Created by Cyrille on 15/03/2016.
 */
public class BaseActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_index_cinema, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case R.id.action_settings:
            {
                Intent intent = new Intent(this, Affiche.class);
                this.startActivity(intent);
                return true;
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
}
