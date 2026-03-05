package com.videoclub.controller;

import database.Connexion;
import java.sql.*;

public class AbonneDAO {

    // Charger tous les abonnés depuis la base
    public static void chargerAbonnes(javax.swing.table.DefaultTableModel modele) {
        modele.setRowCount(0);
        String sql = "SELECT id_client, nom, prenom, adresse FROM Client";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                modele.addRow(new Object[]{
                        rs.getInt("id_client"),
                        rs.getString("nom") + " " + rs.getString("prenom"),
                        rs.getString("adresse"),
                        "2026",
                        "0"
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ajouter un abonné
    public static void ajouterAbonne(String nom, String prenom, String adresse, String email, String telephone) {
        String sql = "INSERT INTO Client(nom, prenom, adresse, email, telephone) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, adresse);
            ps.setString(4, email);
            ps.setString(5, telephone);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Modifier un abonné
    public static void modifierAbonne(int id, String nom, String prenom, String adresse) {
        String sql = "UPDATE Client SET nom=?, prenom=?, adresse=? WHERE id_client=?";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, adresse);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Supprimer un abonné
    public static void supprimerAbonne(int id) {
        String sql = "DELETE FROM Client WHERE id_client=?";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}