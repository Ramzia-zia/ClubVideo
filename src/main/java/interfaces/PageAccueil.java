package interfaces;

import com.videoclub.controller.GestionController;
import com.videoclub.location.LocationForm;
import com.videoclub.view.PanelGestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class PageAccueil extends JFrame {

    public PageAccueil() {
        setTitle("Club Vidéo - Accueil");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 60));
        panel.setLayout(null);
        add(panel);

        // Titre
        JLabel lblTitre = new JLabel(" Bienvenue au Club Vidéo", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitre.setForeground(Color.WHITE);
        lblTitre.setBounds(0, 20, 700, 50);
        panel.add(lblTitre);

        JLabel lblSousTitre = new JLabel("Que voulez-vous faire ?", SwingConstants.CENTER);
        lblSousTitre.setFont(new Font("Arial", Font.ITALIC, 14));
        lblSousTitre.setForeground(new Color(180, 180, 180));
        lblSousTitre.setBounds(0, 70, 700, 30);
        panel.add(lblSousTitre);

        // Boutons du menu
        String[] menus = {
                " Gestion des Abonnés",
                " Gestion des Cassettes",
                " Gestion des Locations",
                " Gestion des Retours",
                " Contact",
                " Déconnexion"
        };

        Color[] couleurs = {
                new Color(0, 120, 215),
                new Color(0, 153, 76),
                new Color(204, 102, 0),
                new Color(153, 0, 153),
                new Color(0, 153, 153),
                new Color(200, 0, 0)
        };

        int x = 80, y = 130;
        for (int i = 0; i < menus.length; i++) {
            JButton btn = new JButton(menus[i]);
            btn.setBounds(x, y, 220, 50);
            btn.setBackground(couleurs[i]);
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Arial", Font.BOLD, 13));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setFocusPainted(false);
            panel.add(btn);

            // Passer à la colonne suivante
            if (i == 2) {
                x = 400;
                y = 130;
            } else {
                y += 70;
            }

            // Actions
            final int index = i;
            btn.addActionListener(e -> actionMenu(index));
        }

        setVisible(true);
    }

    private void actionMenu(int index) {
        switch (index) {
            case 0:
            case 1:
                JFrame frameGestion = new JFrame("Gestion Abonnes et Cassettes");
                frameGestion.setSize(800, 600);
                frameGestion.setLocationRelativeTo(null);
                frameGestion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                PanelGestion panelGestion = new PanelGestion();
                GestionController gestionController = new GestionController(panelGestion);

                JPanel panelBoutons = new JPanel();
                JButton btnAjouterAbonne = new JButton("Ajouter Abonne");
                JButton btnModifierAbonne = new JButton("Modifier Abonne");
                JButton btnSupprimerAbonne = new JButton("Supprimer Abonne");
                JButton btnAjouterCassette = new JButton("Ajouter Cassette");
                JButton btnModifierCassette = new JButton("Modifier Cassette");
                JButton btnSupprimerCassette = new JButton("Supprimer Cassette");

                btnAjouterAbonne.addActionListener(ev -> gestionController.executerAjout("Abonne"));
                btnModifierAbonne.addActionListener(ev -> gestionController.executerModification(panelGestion.getTableAbonne(), "Abonne"));
                btnSupprimerAbonne.addActionListener(ev -> gestionController.executerSuppression(panelGestion.getTableAbonne(), "Abonne"));
                btnAjouterCassette.addActionListener(ev -> gestionController.executerAjout("Cassette"));
                btnModifierCassette.addActionListener(ev -> gestionController.executerModification(panelGestion.getTableCassette(), "Cassette"));
                btnSupprimerCassette.addActionListener(ev -> gestionController.executerSuppression(panelGestion.getTableCassette(), "Cassette"));

                panelBoutons.add(btnAjouterAbonne);
                panelBoutons.add(btnModifierAbonne);
                panelBoutons.add(btnSupprimerAbonne);
                panelBoutons.add(btnAjouterCassette);
                panelBoutons.add(btnModifierCassette);
                panelBoutons.add(btnSupprimerCassette);

                frameGestion.add(panelGestion, BorderLayout.CENTER);
                frameGestion.add(panelBoutons, BorderLayout.SOUTH);
                frameGestion.setVisible(true);
                break;
            case 2:
                new LocationForm();
                break;
            case 3:
                new LocationForm();
                break;
            case 4:
                new PageContact();
                break;
            case 5:
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Voulez-vous vous déconnecter ?", "Déconnexion",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    new PageConnexion();
                    dispose();
                }
                break;
        }
    }
}