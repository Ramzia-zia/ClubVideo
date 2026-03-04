package com.videoclub.location;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LocationForm extends JFrame {

    private JTextField txtAbonne, txtCassette;

    public LocationForm() {
        setTitle("Gestion Location - Club Video");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("GESTION DES LOCATIONS", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(33, 150, 243));
        lblTitle.setBorder(new EmptyBorder(20, 10, 20, 10));
        add(lblTitle, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel(new GridBagLayout());
        panelCenter.setBorder(new EmptyBorder(20, 40, 20, 40));
        panelCenter.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panelCenter.add(new JLabel("ID Abonne:"), gbc);
        gbc.gridx = 1;
        txtAbonne = new JTextField(15);
        panelCenter.add(txtAbonne, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelCenter.add(new JLabel("ID Cassette:"), gbc);
        gbc.gridx = 1;
        txtCassette = new JTextField(15);
        panelCenter.add(txtCassette, gbc);

        add(panelCenter, BorderLayout.CENTER);

        JPanel panelButtons = new JPanel();
        panelButtons.setBorder(new EmptyBorder(10, 10, 20, 10));
        panelButtons.setBackground(Color.WHITE);

        JButton btnLouer = new JButton("Louer");
        JButton btnRetour = new JButton("Retour");

        styleButton(btnLouer, new Color(76, 175, 80));
        styleButton(btnRetour, new Color(244, 67, 54));

        panelButtons.add(btnLouer);
        panelButtons.add(btnRetour);
        add(panelButtons, BorderLayout.SOUTH);

        btnLouer.addActionListener(e -> {
            if (txtAbonne.getText().isEmpty() || txtCassette.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                int idA = Integer.parseInt(txtAbonne.getText());
                int idC = Integer.parseInt(txtCassette.getText());
                String message = LocationDAO.louerCassette(idA, idC);
                JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Entrer des IDs valides !", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnRetour.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Entrer ID Location:");
            if (input == null) return;
            try {
                int idLoc = Integer.parseInt(input);
                String message = LocationDAO.retournerCassette(idLoc);
                JOptionPane.showMessageDialog(this, message, "Retour", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID invalide !", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {
        button.setFocusPainted(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(120, 35));
    }
}