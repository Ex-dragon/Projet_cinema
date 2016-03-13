package com.premieressai.cyrille.projetcinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyrille on 13/03/2016.
 */
public class FilmAdapter extends ArrayAdapter<Film> {

    public FilmAdapter(Context context, List<Film> films) {
        super(context, 0, films);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_film_affiche,parent, false);
        }

        FilmViewHolder viewHolder = (FilmViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new FilmViewHolder();
            viewHolder.titre = (TextView) convertView.findViewById(R.id.titre);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Film film = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.titre.setText(film.getTitre());

        return convertView;
    }

    private class FilmViewHolder{
        public TextView titre;
    }
}
