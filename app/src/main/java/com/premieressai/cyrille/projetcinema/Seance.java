package com.premieressai.cyrille.projetcinema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Cyrille on 15/03/2016.
 */

//Classe décrivant une séance de cinéma.
public class Seance {

    private String date = "";
    private String heure = "";
    private String langue = "";
    private boolean is_troisd = false;
    private boolean is_malentendant = false;
    private boolean is_handicape = false;
    private int cinemaid = 0;
    private int filmid = 0;
    private String cinema_salle = "";

    public String getDate() {
        String annee = "";
        String mois = "";
        String jour = "";

        for (int i =0; i<4; i++){
            annee += date.charAt(i);
        }
        for (int i =4; i<6; i++){
            mois += date.charAt(i);
        }
        for (int i =6; i<8; i++){
            jour += date.charAt(i);
        }

        return annee + "-" + mois + "-" + jour;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        String hour = "";
        for (int i =0; i<heure.length()-3; i++){
            hour += heure.charAt(i);
        }
        return hour;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setIs_troisd(boolean troisd){
        is_troisd = troisd;
    }

    public String getIs_troisd(){
        if (is_troisd) {return "oui";}
        else {return "non";}
    }

    public void setIs_malentendant(boolean mal){
        is_malentendant = mal;
    }

    public String getIs_malentendant(){
        if (is_malentendant) {return "oui";}
        else {return "non";}
    }

    public void setIs_handicape(boolean hand){
        is_handicape = hand;
    }

    public String getIs_handicape(){
        if (is_handicape) {return "oui";}
        else {return "non";}
    }

    public int getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(int cinemaid) {
        this.cinemaid = cinemaid;
    }

    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public String getCinema_salle() {
        return cinema_salle;
    }

    public void setCinema_salle(String cinema_salle) {
        this.cinema_salle = cinema_salle;
    }
}
