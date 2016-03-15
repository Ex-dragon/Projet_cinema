package com.premieressai.cyrille.projetcinema;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Cyrille on 11/03/2016.
 */
public class Film {

// filmseance.json
    private int id = 0;
    private String titre = "";
    private String duree = "";
    private String affiche = "";
    private String distributeur = "";
    private String acteurs = "";
    private String web = "";
    private String realisateur = "";
    private String synopsis = "";

    private String annee;
    private String date_sortie;
    private String info;
    private String is_visible;
    private String is_vente;
    private String genre = "";  // genre
    private String categorie = ""; //categorie
    private String Release_number;
    private String pays;
    private String share_url;
    private ArrayList<String> media;
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
    private String actual_date = "";
    private String show_time = "";
    private boolean is_troisd = false;
    private boolean is_malentendant = false;
    private boolean is_handicape = false;
    private String nationality = ""; //langue
    private int cinemaid = 0;
    private int filmid = 0;
    private String categorieid;
    private String performanceid;
    private String cinema_salle = "";

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
        String startTime = "00:00";
        int h = temps / 60 + Integer.valueOf(startTime.substring(0,1));
        int m = temps % 60 + Integer.valueOf(startTime.substring(3,4));
        String newtime = h+"h"+m;

        duree = newtime;
    }

    public String getDuree(){
        return duree;
    }

    public void setAffiche(String url){
        affiche = url;
    }

    public String getAffiche(){
        return affiche;
    }

    public void setDistributeur(String distri){
        distributeur = distri;
    }

    public String getDistributeur(){
        return distributeur;
    }

    public void setActeurs(String acteur){
        acteurs = acteur;
    }

    public String getActeurs(){
        return acteurs;
    }

    public void setWeb(String site){
        web = site;
    }

    public String getWeb(){
        return web;
    }

    public void setRealisateur(String real){
        realisateur = real;
    }

    public String getRealisateur(){
        return realisateur;

    }

    public void setSynopsis(String descr){
        synopsis = descr;
    }

    public String getSynopsis(){
        return synopsis;
    }

    public void setGenre(String genrre){
        genre = genrre;
    }

    public String getGenre(){
        return genre;
    }

    public void setCategorie(String cat){
        categorie = cat;
    }

    public String getCategorie(){
        return categorie;
    }

    public void setActual_date(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        actual_date = date;
    }

    public String getActual_date(){
        return actual_date;
    }

    public void setShow_time(String show){
        show_time = show;
    }

    public String getShow_time(){
        return show_time;
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

    public void setFilmid(int id){
        filmid = id;
    }

    public int getFilmid(){
        return filmid;
    }

    public void setNationality(String langue){
        nationality = langue;
    }

    public String getNationality(){
        return nationality;
    }

    public void setCinemaid(int i){
        cinemaid = i;
    }

    public int getCinemaid(){
        return cinemaid;
    }

    public ArrayList<Photo> getMedia() {
        ArrayList<Photo> liste = null;

        for (int i=0 ; i < media.size(); i++){
            assert liste != null;
            liste.add(new Photo(media.get(i)));
        }

        return liste;
    }

    public void setMedia(ArrayList<String> media) {
        this.media = media;
    }


    //private String categorieid;
    //private String performanceid;
    //private String cinema_salle;
}
