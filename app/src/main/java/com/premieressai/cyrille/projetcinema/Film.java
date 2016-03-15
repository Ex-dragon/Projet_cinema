package com.premieressai.cyrille.projetcinema;



import java.util.ArrayList;

/**
 * Created by Cyrille on 11/03/2016.
 */
public class Film {

//Classe Film pour stocker et accéder plus facilement aux données.

    private int id = 0;
    private String titre = "";
    private String duree = "";
    private String affiche = "";
    private String distributeur = "";
    private String acteurs = "";
    private String realisateur = "";
    private String synopsis = "";

    private String genre = "";
    private String categorie = "";

    private ArrayList<Seance> seance = new ArrayList<>();

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

    public ArrayList<Seance> getSeance() {
        return seance;
    }

}
