package com.premieressai.cyrille.projetcinema;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.util.List;

/**
 * Created by Cyrille on 13/03/2016.
 */

//L'adapter chargé de l'affichage des films à l'affiche.
public class FilmAdapter extends ArrayAdapter<Film> {

    public FilmAdapter(Context context, List<Film> films) {
        super(context, 0, films);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_film_affiche, parent, false);
        }

        FilmViewHolder viewHolder = (FilmViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new FilmViewHolder();
            viewHolder.titre = (TextView) convertView.findViewById(R.id.titre);
            viewHolder.duree = (TextView) convertView.findViewById(R.id.duree);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Film> films
        Film film = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.titre.setText(film.getTitre());
        viewHolder.duree.setText(film.getDuree());

        final ImageView mImageView;
        mImageView = (ImageView) convertView.findViewById(R.id.affiche);

//  Récupération de l'affiche à partir de son url
        ImageRequest request = new ImageRequest(film.getAffiche(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        mImageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, null, Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        mImageView.setImageResource(0);
                    }
                });
        Singleton.getInstance(this.getContext()).addToRequestQueue(request);

        return convertView;
    }

    private class FilmViewHolder {
        public TextView titre;
        public TextView duree;
    }
}
