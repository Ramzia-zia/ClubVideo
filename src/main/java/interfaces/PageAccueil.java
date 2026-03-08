package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PageAccueil extends JFrame {

    public PageAccueil() {
        setTitle("Club Video - Accueil");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(50, 50, 50));
        header.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel lblTitre = new JLabel("CLUB VIDEO");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setForeground(Color.WHITE);

        JLabel lblSous = new JLabel("Systeme de gestion");
        lblSous.setFont(new Font("Arial", Font.ITALIC, 12));
        lblSous.setForeground(new Color(200, 200, 200));

        header.add(lblTitre, BorderLayout.WEST);
        header.add(lblSous, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // Panel central avec les boutons
        JPanel center = new JPanel(new GridLayout(2, 3, 15, 15));
        center.setBackground(Color.WHITE);
        center.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        String[] titres = {"Abonnes", "Cassettes", "Locations", "Retours", "Contact", "Deconnexion"};
        String[] descriptions = {
                "Gerer les abonnes",
                "Gerer les cassettes",
                "Gerer les locations",
                "Enregistrer les retours",
                "Nous contacter",
                "Quitter la session"
        };

        for (int i = 0; i < titres.length; i++) {
            final int index = i;
            JPanel card = creerCarte(titres[i], descriptions[i]);
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) { actionMenu(index); }
                @Override
                public void mouseEntered(MouseEvent e) {
                    card.setBackground(new Color(240, 240, 240));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    card.setBackground(Color.WHITE);
                }
            });
            center.add(card);
        }

        add(center, BorderLayout.CENTER);

        // Footer
        JLabel footer = new JLabel("2026 Club Video - Tous droits reserves", SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 11));
        footer.setForeground(new Color(150, 150, 150));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel creerCarte(String titre, String description) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(20, 15, 20, 15)
        ));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 15));
        lblTitre.setForeground(new Color(50, 50, 50));
        lblTitre.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblDesc = new JLabel(description);
        lblDesc.setFont(new Font("Arial", Font.PLAIN, 11));
        lblDesc.setForeground(new Color(120, 120, 120));
        lblDesc.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(Box.createVerticalGlue());
        card.add(lblTitre);
        card.add(Box.createVerticalStrut(8));
        card.add(lblDesc);
        card.add(Box.createVerticalGlue());

        return card;
    }

    private void actionMenu(int index) {
        switch (index) {
            case 0:
            case 1:
                JFrame frameGestion = new JFrame("Gestion Abonnes et Cassettes");
                frameGestion.setSize(800, 600);
                frameGestion.setLocationRelativeTo(null);
                frameGestion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameGestion.setResizable(true);

                com.videoclub.view.PanelGestion panelGestion = new com.videoclub.view.PanelGestion();
                com.videoclub.controller.GestionController gestionController = new com.videoclub.controller.GestionController(panelGestion);

                JPanel panelBoutons = new JPanel();
                panelBoutons.setBackground(new Color(245, 245, 245));
                panelBoutons.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

                JButton btnAjouterAbonne = new JButton("Ajouter Abonne");
                JButton btnModifierAbonne = new JButton("Modifier Abonne");
                JButton btnSupprimerAbonne = new JButton("Supprimer Abonne");
                JButton btnAjouterCassette = new JButton("Ajouter Cassette");
                JButton btnModifierCassette = new JButton("Modifier Cassette");
                JButton btnSupprimerCassette = new JButton("Supprimer Cassette");

                for (JButton btn : new JButton[]{btnAjouterAbonne, btnModifierAbonne, btnSupprimerAbonne,
                        btnAjouterCassette, btnModifierCassette, btnSupprimerCassette}) {
                    btn.setFocusPainted(false);
                    btn.setBackground(new Color(60, 60, 60));
                    btn.setForeground(Color.WHITE);
                    btn.setFont(new Font("Arial", Font.PLAIN, 12));
                }

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
                new com.videoclub.location.LocationForm();
                break;
            case 3:
                new com.videoclub.location.LocationForm();
                break;
            case 4:
                new PageContact();
                break;
            case 5:
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Voulez-vous vous deconnecter ?", "Deconnexion",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    new PageConnexion();
                    dispose();
                }
                break;
        }
    }
}