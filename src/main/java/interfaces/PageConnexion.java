package interfaces;

import database.Connexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PageConnexion extends JFrame {

    private JTextField txtUtilisateur;
    private JPasswordField txtMotDePasse;
    private JButton btnConnecter;

    public PageConnexion() {
        setTitle("Club Vidéo - Connexion");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 60));
        panel.setLayout(null);
        add(panel);

        // Titre
        JLabel lblTitre = new JLabel(" Club Vidéo", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setForeground(Color.WHITE);
        lblTitre.setBounds(0, 20, 400, 40);
        panel.add(lblTitre);

        // Utilisateur
        JLabel lblUser = new JLabel("Utilisateur :");
        lblUser.setForeground(Color.WHITE);
        lblUser.setBounds(60, 90, 120, 25);
        panel.add(lblUser);

        txtUtilisateur = new JTextField();
        txtUtilisateur.setBounds(180, 90, 160, 25);
        panel.add(txtUtilisateur);

        // Mot de passe
        JLabel lblPass = new JLabel("Mot de passe :");
        lblPass.setForeground(Color.WHITE);
        lblPass.setBounds(60, 135, 120, 25);
        panel.add(lblPass);

        txtMotDePasse = new JPasswordField();
        txtMotDePasse.setBounds(180, 135, 160, 25);
        panel.add(txtMotDePasse);

        // Bouton
        btnConnecter = new JButton("Se connecter");
        btnConnecter.setBounds(130, 190, 140, 35);
        btnConnecter.setBackground(new Color(0, 120, 215));
        btnConnecter.setForeground(Color.WHITE);
        btnConnecter.setFont(new Font("Arial", Font.BOLD, 13));
        btnConnecter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnConnecter);

        // Action bouton
        btnConnecter.addActionListener(e -> seConnecter());

        setVisible(true);
    }

    private void seConnecter() {
        String user = txtUtilisateur.getText().trim();
        String pass = new String(txtMotDePasse.getPassword()).trim();

        // Pour l'instant on vérifie simplement admin/admin
        if (user.equals("admin") && pass.equals("ramzia123")) {
            JOptionPane.showMessageDialog(this, "Connexion réussie !");
            new PageAccueil(); // on créera cette page après
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Identifiants incorrects !",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new PageConnexion();
    }
}