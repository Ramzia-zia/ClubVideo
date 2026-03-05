package com.videoclub.controller;

import database.Connexion;
import java.sql.*;

public class CassetteDAO {

    // Charger toutes les cassettes depuis la base
    public static void chargerCassettes(javax.swing.table.DefaultTableModel modele) {
        modele.setRowCount(0);
        String sql = "SELECT id_film, titre, auteur, duree, prix_location, nom_categorie " +
                "FROM Film f JOIN Categorie c ON f.id_categorie = c.id_categorie";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                modele.addRow(new Object[]{
                        rs.getInt("id_film"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getInt("duree"),
                        rs.getDouble("prix_location"),
                        rs.getString("nom_categorie")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ajouter une cassette
    public static void ajouterCassette(String titre, String auteur, int duree, double prix, int idCategorie) {
        String sql = "INSERT INTO Film(titre, auteur, duree, prix_location, id_categorie) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, titre);
            ps.setString(2, auteur);
            ps.setInt(3, duree);
            ps.setDouble(4, prix);
            ps.setInt(5, idCategorie);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Modifier une cassette
    public static void modifierCassette(int id, String titre, String auteur) {
        String sql = "UPDATE Film SET titre=?, auteur=? WHERE id_film=?";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, titre);
            ps.setString(2, auteur);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Supprimer une cassette
    public static void supprimerCassette(int id) {
        String sql = "DELETE FROM Film WHERE id_film=?";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}