package com.premieressai.cyrille.projetcinema;

/**
 * Created by Cyrille on 11/03/2016.
 */
public class Film {

// filmseance.json
    String id;
    String titre;
    String duree;
    String affiche;
    String distributeur;
    String acteurs;
    String web;
    String realisateur;
    String synopsis;
    String annee;
    String date_sortie;
    String info;
    String is_visible;
    String is_vente;
    String genre_id;  // genre
    String categorie_id; //categorie
    String Release_number;
    String pays;
    String share_url;
    String media;
    String video;
    String is_avp;
    String is_alaune; //A la une, sert à rien, toujours false
    String last_week;

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

}
