package com.videoclub.location;

import database.Connexion;
import java.sql.*;

public class LocationDAO {

    public static boolean abonneExiste(int idAbonne) throws Exception {
        String sql = "SELECT 1 FROM Client WHERE id_client = ?";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAbonne);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public static int nombreLocationsActives(int idAbonne) throws Exception {
        String sql = "SELECT COUNT(*) FROM Location WHERE id_client = ? AND date_retour IS NULL";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAbonne);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return 0;
    }

    public static boolean cassetteEstLoue(int idFilm) throws Exception {
        String sql = "SELECT 1 FROM Location WHERE id_film = ? AND date_retour IS NULL";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idFilm);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public static String louerCassette(int idAbonne, int idFilm) {
        try {
            if (!abonneExiste(idAbonne))
                return "Abonne inexistant.";
            if (nombreLocationsActives(idAbonne) >= 3)
                return "Maximum 3 locations autorisees.";
            if (cassetteEstLoue(idFilm))
                return "Cassette deja louee.";

            String sql = "INSERT INTO Location(date_location, id_client, id_film) VALUES (CURDATE(), ?, ?)";
            try (Connection con = Connexion.getConnexion();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idAbonne);
                ps.setInt(2, idFilm);
                ps.executeUpdate();
            }
            return "Location enregistree avec succes.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors de la location.";
        }
    }

    public static String retournerCassette(int idLocation) {
        String sql = "UPDATE Location SET date_retour = CURDATE() WHERE id_location = ?";
        try (Connection con = Connexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLocation);
            int rows = ps.executeUpdate();
            if (rows > 0) return "Cassette retournee avec succes.";
            else return "Location introuvable.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors du retour.";
        }
    }
}