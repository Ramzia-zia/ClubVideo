package com.videoclub.model;

public class Abonne {
    private int id;
    private String nom;
    private String adresse;
    private String dateAbonnement;
    private int nbLocations;

    public Abonne(int id, String nom, String adresse, String dateAbonnement, int nbLocations) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.dateAbonnement = dateAbonnement;
        this.nbLocations = nbLocations;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public String getDateAbonnement() { return dateAbonnement; }
    public int getNbLocations() { return nbLocations; }

    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setDateAbonnement(String dateAbonnement) { this.dateAbonnement = dateAbonnement; }
    public void setNbLocations(int nbLocations) { this.nbLocations = nbLocations; }
}