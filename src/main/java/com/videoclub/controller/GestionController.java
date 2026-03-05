package com.videoclub.controller;

import com.videoclub.view.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestionController {
    private PanelGestion vue;

    public GestionController(PanelGestion vue) {
        this.vue = vue;
        // Charger les données depuis la base au démarrage
        AbonneDAO.chargerAbonnes(vue.modeleAbonne);
        CassetteDAO.chargerCassettes(vue.modeleCassette);
    }

    // --- AJOUTER ---
    public void executerAjout(String type) {
        DialogForm dialogue = new DialogForm(null, "Ajouter " + type);
        dialogue.btnValider.addActionListener(e -> {
            if (type.equals("Abonne")) {
                String nom = dialogue.txtNom.getText().trim();
                String adresse = dialogue.txtAdresse.getText().trim();
                if (nom.isEmpty() || adresse.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
                    return;
                }
                AbonneDAO.ajouterAbonne(nom, "", adresse, nom.toLowerCase() + "@email.com", "");
                AbonneDAO.chargerAbonnes(vue.modeleAbonne);
            } else {
                String titre = dialogue.txtTitre.getText().trim();
                String auteur = dialogue.txtAuteur.getText().trim();
                if (titre.isEmpty() || auteur.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
                    return;
                }
                CassetteDAO.ajouterCassette(titre, auteur, 90, 2.50, 1);
                CassetteDAO.chargerCassettes(vue.modeleCassette);
            }
            dialogue.dispose();
        });
        dialogue.setVisible(true);
    }

    // --- MODIFIER ---
    public void executerModification(JTable table, String type) {
        int ligne = table.getSelectedRow();
        if (ligne == -1) {
            JOptionPane.showMessageDialog(null, "Selectionnez une ligne");
            return;
        }

        DialogForm dialogue = new DialogForm(null, "Modifier " + type);

        if (type.equals("Abonne")) {
            dialogue.txtNom.setText(table.getValueAt(ligne, 1).toString());
            dialogue.txtAdresse.setText(table.getValueAt(ligne, 2).toString());
        } else {
            dialogue.txtTitre.setText(table.getValueAt(ligne, 1).toString());
            dialogue.txtAuteur.setText(table.getValueAt(ligne, 2).toString());
        }

        dialogue.btnValider.addActionListener(e -> {
            int id = Integer.parseInt(table.getValueAt(ligne, 0).toString());
            if (type.equals("Abonne")) {
                AbonneDAO.modifierAbonne(id, dialogue.txtNom.getText(), "", dialogue.txtAdresse.getText());
                AbonneDAO.chargerAbonnes(vue.modeleAbonne);
            } else {
                CassetteDAO.modifierCassette(id, dialogue.txtTitre.getText(), dialogue.txtAuteur.getText());
                CassetteDAO.chargerCassettes(vue.modeleCassette);
            }
            dialogue.dispose();
        });
        dialogue.setVisible(true);
    }

    // --- SUPPRIMER ---
    public void executerSuppression(JTable table, String type) {
        int ligne = table.getSelectedRow();
        if (ligne == -1) {
            JOptionPane.showMessageDialog(null, "Selectionnez une ligne");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
                "Supprimer cet element ?", "Attention", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(table.getValueAt(ligne, 0).toString());
            if (type.equals("Abonne")) {
                AbonneDAO.supprimerAbonne(id);
                AbonneDAO.chargerAbonnes(vue.modeleAbonne);
            } else {
                CassetteDAO.supprimerCassette(id);
                CassetteDAO.chargerCassettes(vue.modeleCassette);
            }
        }
    }
}