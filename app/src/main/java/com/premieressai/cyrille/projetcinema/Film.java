package com.premieressai.cyrille.projetcinema;

/**
 * Created by Cyrille on 11/03/2016.
 */
public class Film {

// filmseance.json
    private int id = 0;
    private String titre = "";
    private int duree;
    private String affiche;

    private String distributeur;
    private String acteurs;
    private String web;
    private String realisateur;
    private String synopsis;
    private String annee;
    private String date_sortie;
    private String info;
    private String is_visible;
    private String is_vente;
    private String genre_id;  // genre
    private String categorie_id; //categorie
    private String Release_number;
    private String pays;
    private String share_url;
    private String media;
    private String video;
    private String is_avp;
    private String is_alaune; //A la une, sert à rien, toujours false
    private String last_week;

//prochainement
    String current;
    String next;
    String titre_ori;
    //pour le reste, cf ci dessus. Vérifier quand même que les infos sont identiques.

//events
    String type;
    String events;
    String soustitre;
    String description;

    String vad_condition;
    String partenaire;
    String date_deb;
    String date_fin;
    String heure;
    String contact;
    String web_label;

//seances : +id et titre
    String actual_date;
    String show_time;
    String is_troisd;
    String is_malentendant;
    String is_handicape;
    String nationality; //langue
    String cinemaid;
    String filmid;
    String categorieid;
    String performanceid;
    String cinema_salle;

    public void setId(int ID){
        id = ID;
    }

    public int getId(){
        return id;
    }

    public void setTitre(String Titre){
        titre = Titre;
    }

    public String getTitre(){
        return titre;
    }

    public void setDuree(int temps){
        duree = temps;
    }

    public int getDuree(){
        return duree;
    }

    public void setAffiche(String url){
        affiche = url;
    }

    public String getAffiche(){
        return affiche;
    }

}
