package com.premieressai.cyrille.projetcinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyrille on 15/03/2016.
 */

//Adapter affichant les séances dans ma page détaillée.
public class SeanceAdapter extends ArrayAdapter<Seance> {

    public SeanceAdapter(Context context, List<Seance> seance) {
        super(context, 0, seance);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_seance, parent, false);
        }

        SeanceViewHolder viewHolder = (SeanceViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new SeanceViewHolder();

            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.heure = (TextView) convertView.findViewById(R.id.heure);
            viewHolder.langue = (TextView) convertView.findViewById(R.id.langue);
            viewHolder.salle = (TextView) convertView.findViewById(R.id.salle);
            viewHolder.troisd = (TextView) convertView.findViewById(R.id.troisd);
            viewHolder.malentendant = (TextView) convertView.findViewById(R.id.malentendant);
            viewHolder.handicape = (TextView) convertView.findViewById(R.id.handicape);
            viewHolder.cinema = (TextView) convertView.findViewById(R.id.cinema);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Film> films
        Seance seance = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.date.setText(String.valueOf(seance.getDate()));
        viewHolder.heure.setText(" - " + seance.getHeure());
        viewHolder.langue.setText(" - " + seance.getLangue());
        viewHolder.salle.setText(", " + seance.getCinema_salle());
        viewHolder.troisd.setText("3D: " + seance.getIs_troisd());
        viewHolder.malentendant.setText(", malentendant: " + seance.getIs_malentendant());
        viewHolder.handicape.setText(", handicape: " + seance.getIs_troisd());

        if (seance.getCinemaid() == 1){
            viewHolder.cinema.setText("Cinema Le Cezanne");
        } else if (seance.getCinemaid() == 2){
            viewHolder.cinema.setText("Cinema Le Renoir");
        } else {
            viewHolder.cinema.setText("Cinema Le Mazarin");
        }
       return convertView;
    }

    private class SeanceViewHolder {
        public TextView date;
        public TextView heure;
        public TextView salle;
        public TextView langue;
        public TextView troisd;
        public TextView malentendant;
        public TextView handicape;
        public TextView cinema;
    }
}
