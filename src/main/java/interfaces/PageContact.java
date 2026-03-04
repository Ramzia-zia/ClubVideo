package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PageContact extends JFrame {

    public PageContact() {
        setTitle("Club Vidéo - Contact");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 60));
        panel.setLayout(null);
        add(panel);

        // Titre
        JLabel lblTitre = new JLabel("Contactez-nous", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitre.setForeground(Color.WHITE);
        lblTitre.setBounds(0, 20, 500, 40);
        panel.add(lblTitre);

        // Infos contact
        String[] infos = {
                " Adresse : Avedji, Lomé - Togo",
                " Téléphone : +228 92 29 01 05",
                " Email : contact@clubvideo.com",
                " Horaires : Lun - Sam : 8h00 - 20h00"
        };

        int y = 100;
        for (String info : infos) {
            JLabel lbl = new JLabel(info);
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Arial", Font.PLAIN, 14));
            lbl.setBounds(50, y, 400, 30);
            panel.add(lbl);
            y += 50;
        }

        // Séparateur
        JLabel sep = new JLabel("─────────────────────────────────", SwingConstants.CENTER);
        sep.setForeground(new Color(100, 100, 150));
        sep.setBounds(0, 290, 500, 20);
        panel.add(sep);

        // Bouton fermer
        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBounds(180, 320, 140, 35);
        btnFermer.setBackground(new Color(200, 0, 0));
        btnFermer.setForeground(Color.WHITE);
        btnFermer.setFont(new Font("Arial", Font.BOLD, 13));
        btnFermer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFermer.setFocusPainted(false);
        btnFermer.addActionListener(e -> dispose());
        panel.add(btnFermer);

        setVisible(true);
    }
}