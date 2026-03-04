package com.videoclub.model;

public class Cassette {
    private int id;
    private String titre, auteur, categorie;
    private double prix;
    private int duree;

    public Cassette(int id, String titre, String auteur, int duree, double prix, String categorie) {
        this.id = id; this.titre = titre; this.auteur = auteur;
        this.duree = duree; this.prix = prix; this.categorie = categorie;
    }
    // Getters/Setters : id, titre, auteur, duree, prix, categorie

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}